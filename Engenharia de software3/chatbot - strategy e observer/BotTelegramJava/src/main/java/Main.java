import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    public static void main(String[] args) {
        String botToken = "7527608316:AAGkw-8OBTelQo5bX9mpSzx0Y5Z1ozBY8pg";
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            MyAmazingBot bot = new MyAmazingBot(botToken);

            bot.setDiscountStrategy(new PercentageDiscountStrategy(20));

            bot.addObserver(new PurchaseNotifier());
            bot.addObserver(new EmailNotifier());

            botsApplication.registerBot(botToken, bot);
            System.out.println("MyAmazingBot foi inicializado com sucesso!");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
