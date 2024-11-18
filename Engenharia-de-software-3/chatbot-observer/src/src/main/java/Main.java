import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    public static void main(String[] args) {
        String botToken = "6621767934:AAFLxf_Lnb_BQNtw74-Yly0ajUuqFi0Ik2w";  // Token do seu bot

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            // Criação do bot
            MyAmazingBot bot = new MyAmazingBot(botToken);

            // Adiciona a estratégia de notícias padrão (Esportes, Tecnologia, Economia)
            bot.setNewsStrategy(new SportsNewsStrategy());  // Inicializa com Esportes, mas pode ser alterado

            // Adiciona observadores para monitorar o envio de notícias
            bot.addObserver(new ConsoleNewsLogger());  // Exibe no console sempre que uma notícia é enviada
            bot.addObserver(new TelegramNewsNotifier());  // Envia a notificação para outro chat ou grupo

            // Registra o bot no Telegram
            botsApplication.registerBot(botToken, bot);
            System.out.println("MeuAmazingBot foi inicializado com sucesso!");

            // Mantém o bot em execução
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
