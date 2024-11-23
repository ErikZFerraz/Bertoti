public class Facade {
    private SistemaPagamento sistemaPagamento;
    private SistemaEstoque sistemaEstoque;
    private SistemaEnvio sistemaEnvio;
    private SistemaNotificacao sistemaNotificacao;

    public Facade() {
        this.sistemaPagamento = new SistemaPagamento();
        this.sistemaEstoque = new SistemaEstoque();
        this.sistemaEnvio = new SistemaEnvio();
        this.sistemaNotificacao = new SistemaNotificacao();
    }

    // Método simplificado para processar o pedido
    public void processarPedido(String produto, int quantidade) {
        System.out.println("Iniciando processo de compra...");
        sistemaEstoque.verificarDisponibilidade(produto, quantidade);
        sistemaPagamento.processarPagamento(produto, quantidade);
        sistemaEnvio.agendarEnvio(produto, quantidade);
        sistemaNotificacao.enviarConfirmacao(produto, quantidade);
        sistemaNotificacao.enviarNotificacaoEnvio(produto, quantidade);
        System.out.println("Compra concluída com sucesso!");
    }
}
