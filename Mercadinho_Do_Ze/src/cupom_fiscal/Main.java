
package cupom_fiscal;


/**
 *
 * @author Erik
 */


public class Main {
	public static void main(String[] args) {
       
        Cliente cliente = new Cliente("Jose da Silva", "123.456.789-01", "06/12/2023", "Cartao");

        Item item1 = new Item("001", "SHAMPOO", 1, "UN", 16.3);
        Item item2 = new Item("002", "SABONETE", 3, "UN", 1.5);

        CupomFiscal cupom = new CupomFiscal(cliente);
        cupom.adicionarItem(item1);
        cupom.adicionarItem(item2);

        cupom.imprimirCupom();
    }
}