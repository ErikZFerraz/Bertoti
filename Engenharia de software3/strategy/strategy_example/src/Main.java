public class Main {
    public static void main(String[] args) {
        Contexto contexto = new Contexto();

        contexto.setLimpeza(new Veiculo());
        contexto.executarLimpeza();

        contexto.setLimpeza(new Casa());
        contexto.executarLimpeza();
    }
}
