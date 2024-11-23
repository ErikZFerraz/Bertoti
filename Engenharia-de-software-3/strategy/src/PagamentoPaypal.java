public class PagamentoPaypal implements Pagamento{
    @Override
    public void pagar(double quantia) {
        System.out.println("Pagando" + quantia + " com conta Paypal.");
    }
}
