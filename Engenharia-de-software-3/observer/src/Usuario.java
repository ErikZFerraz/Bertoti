public class Usuario implements Observer {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void atualizar(String video) {
        System.out.println(nome + ":" + "Você recebeu um novo vídeo: " + video + ".");
    }
}