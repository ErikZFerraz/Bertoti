public class Main {
    public static void main(String[] args) {

        Canal canal = new Canal("Canal");

        Usuario inscrito1 = new Usuario("Inscrito 1");
        Usuario inscrito2 = new Usuario("Inscrito 2");

        canal.inscrever(inscrito1);
        canal.inscrever(inscrito2);

        canal.postarVideo("Vídeo");
    }
}
