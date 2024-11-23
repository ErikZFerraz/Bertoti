import java.util.ArrayList;
import java.util.List;

public class Pasta implements SistemaArquivos{

    private String nome;
    private List<SistemaArquivos> children = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void add(SistemaArquivos component) {
        children.remove(component);
    }

    @Override
    public void show() {
        System.out.println("Pasta: " + nome);
        for (SistemaArquivos component : children) {
            component.show();
        }
    }
}
