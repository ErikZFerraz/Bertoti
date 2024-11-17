public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        context.setPagamento(new PagamentoCartao());
        context.realizarPagamento(500.00);

        context.setPagamento(new PagamentoPaypal());
        context.realizarPagamento(400.00);

        context.setPagamento(new PagamentoBoleto());
        context.realizarPagamento(350.00);
    }
}