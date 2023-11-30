
package cupom_fiscal;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Erik
 */


public class Main {
    public static void main(String[] args) {
        // Obter dados do cliente
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente (ou deixe em branco):");
        String[] opcoesPagamento = {"Cartao", "Dinheiro"};
        int escolhaPagamento = JOptionPane.showOptionDialog(null, "Escolha a forma de pagamento:", "Forma de Pagamento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesPagamento, opcoesPagamento[0]);

        String formaPagamento = opcoesPagamento[escolhaPagamento];

        // Obter data atualizada
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataPedido = dateFormat.format(new Date());

        // Criar objeto Cliente
        Cliente cliente = new Cliente(nome, cpf, dataPedido, formaPagamento);

        // Criar itens e cupom fiscal
        Item item1 = new Item("001", "SHAMPOO", 1, "UN", 16.3);
        Item item2 = new Item("002", "SABONETE", 3, "UN", 1.5);

        CupomFiscal cupom = new CupomFiscal(cliente);
        cupom.adicionarItem(item1);
        cupom.adicionarItem(item2);

        // Imprimir cupom fiscal
        cupom.imprimirCupom();
    }
}
