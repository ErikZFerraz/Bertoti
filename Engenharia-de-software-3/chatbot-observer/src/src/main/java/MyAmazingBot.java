import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Estratégia de seleção de notícias
interface NewsStrategy {
    String getNews(String topic);
}

class SportsNewsStrategy implements NewsStrategy {
    private final String[] sportsNews = {
        "Hoje é dia de jogo! Seu time enfrentará os rivais no campeonato.",
        "O time está em ótima forma! Prontos para a final do torneio.",
        "A temporada de esportes está agitada, com surpresas incríveis!"
    };

    @Override
    public String getNews(String topic) {
        return sportsNews[new Random().nextInt(sportsNews.length)];
    }
}

class TechnologyNewsStrategy implements NewsStrategy {
    private final String[] techNews = {
        "Novo software promete revolucionar a maneira como usamos dispositivos!",
        "Fique atento, a inteligência artificial está em todo lugar, até no seu celular.",
        "As inovações tecnológicas estão cada vez mais acessíveis, não perca!"
    };

    @Override
    public String getNews(String topic) {
        return techNews[new Random().nextInt(techNews.length)];
    }
}

class EconomyNewsStrategy implements NewsStrategy {
    private final String[] economyNews = {
        "Os mercados estão reagindo positivamente às novas políticas econômicas.",
        "A bolsa de valores teve uma alta surpreendente após as últimas negociações.",
        "Investir no momento é uma jogada inteligente, com vários setores em alta!"
    };

    @Override
    public String getNews(String topic) {
        return economyNews[new Random().nextInt(economyNews.length)];
    }
}

// Observador de Envio de Notícias
interface NewsObserver {
    void onNewsSent(String topic, String news);
}

class ConsoleNewsLogger implements NewsObserver {
    @Override
    public void onNewsSent(String topic, String news) {
        System.out.println("Notícia sobre " + topic + ": " + news);
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
            if (messageText.equalsIgnoreCase("/sports")) {
                topic = "Esportes";
                setNewsStrategy(new SportsNewsStrategy());
            } else if (messageText.equalsIgnoreCase("/tech")) {
                topic = "Tecnologia";
                setNewsStrategy(new TechnologyNewsStrategy());
            } else if (messageText.equalsIgnoreCase("/economy")) {
                topic = "Economia";
                setNewsStrategy(new EconomyNewsStrategy());
            } else if (messageText.equalsIgnoreCase("/help")) {
                SendMessage helpMessage = SendMessage.builder()
                        .chatId(chatId)
                        .text("Comandos disponíveis: /sports, /tech, /economy")
                        .build();
                try {
                    telegramClient.execute(helpMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                return;
            } else {
                SendMessage unknownCommandMessage = SendMessage.builder()
                        .chatId(chatId)
                        .text("Comando não reconhecido. Tente /sports, /tech ou /economy.")
                        .build();
                try {
                    telegramClient.execute(unknownCommandMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                return;
            }

            // Obtém a notícia baseada na estratégia atual
            String news = newsStrategy.getNews(topic);
            SendMessage message = SendMessage.builder()
                    .chatId(chatId)
                    .text("Aqui está a última notícia sobre " + topic + ": " + news)
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
