import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramNewsNotifier implements NewsObserver {

    private final long targetChatId = 123456789L;  // Substitua pelo ID do chat ou grupo desejado

    @Override
    public void onNewsSent(String topic, String news) {
        // Envia a notícia para o chat específico
        SendMessage message = SendMessage.builder()
                .chatId(targetChatId)
                .text("Notícia sobre " + topic + ": " + news)
                .build();

        try {
            // Aqui você usaria o telegramClient para enviar a mensagem
            // Exemplo: telegramClient.execute(message);
            System.out.println("Enviado para outro chat: " + news);  // Simulando envio no console
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
