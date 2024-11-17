public class SistemaNotificacao {
    public void enviarConfirmacao(String produto, int quantidade) {
        System.out.println("Enviando confirmação de compra para " + quantidade + " unidade(s) de " + produto);
    }

    public void enviarNotificacaoEnvio(String produto, int quantidade) {
        System.out.println("Enviando notificação de envio para " + quantidade + " unidade(s) de " + produto);
    }
}
