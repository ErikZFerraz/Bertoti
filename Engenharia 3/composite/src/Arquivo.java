public class Arquivo implements SistemaArquivos {
    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    @Override
    public void show() {
        System.out.println("Arquivo " + nome);
    }
}
