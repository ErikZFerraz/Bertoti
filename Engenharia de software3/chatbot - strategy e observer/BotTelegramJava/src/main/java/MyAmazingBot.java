import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.ArrayList;
import java.util.List;

// Strategy Pattern
interface DiscountStrategy {
    double applyDiscount(double price);
}

class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}

class PercentageDiscountStrategy implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * percentage / 100);
    }
}

// Observer Pattern
interface PurchaseObserver {
    void onPurchaseCompleted(String item, double finalPrice);
}

class PurchaseNotifier implements PurchaseObserver {
    @Override
    public void onPurchaseCompleted(String item, double finalPrice) {
        System.out.println("Compra finalizada: " + item + " por R$ " + finalPrice);
    }
}

class EmailNotifier implements PurchaseObserver {
    @Override
    public void onPurchaseCompleted(String item, double finalPrice) {
        System.out.println("Email enviado: You comprou " + item + " por R$" + finalPrice);
    }
}

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private DiscountStrategy discountStrategy;
    private final List<PurchaseObserver> observers = new ArrayList<>();

    public MyAmazingBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        discountStrategy = new NoDiscountStrategy();
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void addObserver(PurchaseObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String item, double finalPrice) {
        for (PurchaseObserver observer : observers) {
            observer.onPurchaseCompleted(item, finalPrice);
        }
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (message_text.startsWith("/buy")) {

                String item = "Bolsa";
                double originalPrice = 100.0;
                double finalPrice = discountStrategy.applyDiscount(originalPrice);

                SendMessage message = SendMessage.builder()
                        .chatId(chat_id)
                        .text("Item: " + item +" - R$ "+ originalPrice +"\n"+
                                "Desconto: R$ "+(originalPrice - finalPrice)+"\n"+
                                "Você comprou " + item + " por R$ " + finalPrice)
                        .build();
                try {
                    telegramClient.execute(message);
                    notifyObservers(item, finalPrice);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                SendMessage message = SendMessage.builder()
                        .chatId(chat_id)
                        .text(message_text)
                        .build();
                try {
                    telegramClient.execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
