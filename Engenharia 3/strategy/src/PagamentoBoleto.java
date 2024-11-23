public class PagamentoBoleto implements Pagamento{
    @Override
    public void pagar(double quantia) {
        System.out.println("Pagando" + quantia + " com boleto bancário.");
    }
}
