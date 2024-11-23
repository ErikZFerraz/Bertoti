import java.util.ArrayList;
import java.util.List;

public class Canal {
    private String nome;
    private List<Observer> usuarios;
    private String novoVideo;

    public Canal(String nome) {
        this.nome = nome;
        this.usuarios = new ArrayList<>();
    }

    public void inscrever(Observer usuario) {
        usuarios.add(usuario);
        System.out.println(usuario.getClass().getSimpleName() + " se inscreveu no canal " + nome + ".");
    }

    public void desinscrever(Observer usuario) {
        usuarios.remove(usuario);
        System.out.println(usuario.getClass().getSimpleName() + " cancelou a inscrição do canal " + nome + ".");
    }

    public void notificarInscritos() {
        for (Observer usuario : usuarios) {
            usuario.atualizar(novoVideo);
        }
    }

    public void postarVideo(String video) {
        this.novoVideo = video;
        System.out.println(" Você postou um novo vídeo: " + video + ".");
        notificarInscritos();
    }
}
