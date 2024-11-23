class Context {
    private Pagamento pagamento;

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void realizarPagamento(double valor) {
        pagamento.pagar(valor);
    }
}
