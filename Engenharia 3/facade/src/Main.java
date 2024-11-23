public class Main {
    public static void main(String[] args) {
        // Criando a fachada
        Facade lojaOnline = new Facade();

        // Fazendo a compra do produto
        lojaOnline.processarPedido("Laptop", 1);
    }
}
