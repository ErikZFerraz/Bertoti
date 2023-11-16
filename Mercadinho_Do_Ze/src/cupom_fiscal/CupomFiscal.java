
package cupom_fiscal;

/**
 *
 * @author Erik
 */

import java.util.ArrayList;
import java.util.List;


class CupomFiscal {
    private List<Item> itens;
    private Cliente cliente;

    public CupomFiscal(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }

    public void imprimirCupom() {
        
        System.out.println("CUPOM FISCAL");
        System.out.printf("Cliente: %s\nCPF: %s\nData do Pedido: %s\nForma de Pagamento: %s\n", cliente.getNome(), cliente.getCpf(), cliente.getDataPedido(), cliente.getFormPagamento());
        System.out.println("ITEM CODIGO DESCRICAO QTD.UN.VL TOTAL");

        for (Item item : itens) {
            System.out.println(item.toString());
        }

        System.out.printf("\nTOTAL R$%.2f\n", calcularTotal());
    }
}