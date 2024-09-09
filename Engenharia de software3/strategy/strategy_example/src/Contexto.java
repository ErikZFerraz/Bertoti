public class Contexto {
    private Limpeza limpeza;

    public void setLimpeza(Limpeza limpeza) {
        this.limpeza = limpeza;
    }

    public void executarLimpeza() {
        limpeza.limpar();
    }
}
