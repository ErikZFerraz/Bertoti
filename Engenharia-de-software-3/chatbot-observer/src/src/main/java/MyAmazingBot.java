import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.ArrayList;
import java.util.List;

// Estratégia de seleção de notícias
interface NewsStrategy {
    String getNews(String topic);
}

class SportsNewsStrategy implements NewsStrategy {
    @Override
    public String getNews(String topic) {
        return "Notícia de Esportes: Seu time favorito venceu o jogo!";
    }
}

class TechnologyNewsStrategy implements NewsStrategy {
    @Override
    public String getNews(String topic) {
        return "Notícia de Tecnologia: Novo smartphone lançado com funcionalidades incríveis!";
    }
}

class EconomyNewsStrategy implements NewsStrategy {
    @Override
    public String getNews(String topic) {
        return "Notícia de Economia: Mercado de ações em alta após anúncio econômico!";
    }
}

// Observador de Envio de Notícias
interface NewsObserver {
    void onNewsSent(String topic, String news);
}

class ConsoleNewsLogger implements NewsObserver {
    @Override
    public void onNewsSent(String topic, String news) {
        System.out.println("Notícia enviada sobre " + topic + ": " + news);
    }
}

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private NewsStrategy newsStrategy;
    private final List<NewsObserver> observers = new ArrayList<>();

    public MyAmazingBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        newsStrategy = new SportsNewsStrategy();  // Estratégia padrão
    }

    public void setNewsStrategy(NewsStrategy newsStrategy) {
        this.newsStrategy = newsStrategy;
    }

    public void addObserver(NewsObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String topic, String news) {
        for (NewsObserver observer : observers) {
            observer.onNewsSent(topic, news);
        }
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            String topic = "";
            if (messageText.equalsIgnoreCase("/news_sports")) {
                topic = "Esportes";
                setNewsStrategy(new SportsNewsStrategy());
            } else if (messageText.equalsIgnoreCase("/news_technology")) {
                topic = "Tecnologia";
                setNewsStrategy(new TechnologyNewsStrategy());
            } else if (messageText.equalsIgnoreCase("/news_economy")) {
                topic = "Economia";
                setNewsStrategy(new EconomyNewsStrategy());
            } else {
                SendMessage message = SendMessage.builder()
                        .chatId(chatId)
                        .text("Comando desconhecido. Tente /news_sports, /news_technology ou /news_economy.")
                        .build();
                try {
                    telegramClient.execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                return;
            }

            // Obtém a notícia baseada na estratégia atual
            String news = newsStrategy.getNews(topic);
            SendMessage message = SendMessage.builder()
                    .chatId(chatId)
                    .text("Última notícia sobre " + topic + ": " + news)
                    .build();
            try {
                telegramClient.execute(message);
                notifyObservers(topic, news);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
