
package cupom_fiscal;

/**
 *
 * @author Erik
 */

class Item {
    private String codigo;
    private String descricao;
    private int quantidade;
    private String unidade;
    private double valor;

    public Item(String codigo, String descricao, int quantidade, String unidade, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.valor = valor;
    }

    public double calcularTotal() {
        return quantidade * valor;
    }

    public String toString() {
        return String.format("%s %s %sUN valor %.2f", codigo, descricao, quantidade + unidade, valor);
    }
}