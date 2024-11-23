public class PagamentoCartao implements Pagamento{
    @Override
    public void pagar(double quantia) {
        System.out.println("Pagando" + quantia + " com cartão de crédito.");
    }
}
