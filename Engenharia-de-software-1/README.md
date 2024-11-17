# Bertoti

<h1 align="center" dir="auto"><a id="user-content--sprint-1-08032021-a-28032021-" class="anchor" aria-hidden="true" href="#-sprint-1-08032021-a-28032021-"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a><g-emoji class="g-emoji" alias="dart" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f3af.png">📝</g-emoji> Diagrama de classes: Mercadinho_Do_Ze</h1>

<!--<div align="center" dir="auto">
<h2>!!!<h2>
| Client| CupomFiscal  | Item | 
|:-----:|:-------------:|:----------:|
|  - nome: String    | - itens: List<Item> | - codigo: String    |
| - cpf: String      | - cliente: Cliente| - descricao: String |
| - dataPedido: String |                | - quantidade: int   |
| - formPagamento: String |                | - unidade: String   |      
|                    |                | - valor: double     |      

</div>-->


<img src="https://raw.githubusercontent.com/ErikZFerraz/Bertoti/main/Diagrama%20de%20classes%20Mercadinho-Do-Ze.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDE0Mjk5MzcsIm5iZiI6MTcwMTQyOTYzNywicGF0aCI6Ii8xMjYyNDU3ODcvMjgzNjMwMDQ4LWViMzk2YzgyLTcwZjAtNGI1Yi1iNjUxLTExMDgxMjA2Mzg1ZS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMjAxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTIwMVQxMTIwMzdaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0yZDBiMjNjYTNmNmM3MmExNzZlZTk2YTI3MWNjYmFkOTIyMDhhZGEzMWE0YzRlYjU5YzRmZTMwYmVlODU0NTgxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.QPN_6jNT5uXXo_swdohdBpv711ov-SRF6J4uFuuLI2c" alt="UML drawio" style="max-width: 100%;">


package cupom_fiscal;

/**
 *
 * @author Erik
 */

class Cliente {
    private String nome;
    private String cpf;
    private String dataPedido;
    private String formPagamento;

    public Cliente(String nome, String cpf, String dataPedido, String formPagamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataPedido = dataPedido;
        this.formPagamento = formPagamento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataPedido() {
        return dataPedido;
    }
    public String getFormPagamento() {
        return formPagamento;
    }}
    
package cupom_fiscal;

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
    }}
    
package cupom_fiscal;

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
    }}
    
package cupom_fiscal;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    }}



1° TEXTO:"We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth."

Resposta: Vemos três diferenças críticas entre programação e engenharia de software: tempo, escala e as compensações em jogo. Em um projeto de engenharia de software, os engenheiros precisam estar mais preocupados com a passagem do tempo e com a eventual necessidade de mudanças. Numa organização de engenharia de software, precisamos de estar mais preocupados com a escala e a eficiência, tanto para o software que produzimos como para a organização que o produz. Finalmente, como engenheiros de software, somos solicitados a tomar decisões mais complexas com resultados de maior risco, muitas vezes baseados em estimativas imprecisas de tempo e crescimento.

2° TEXTO:"Within Google, we sometimes say, “Software engineering is programming integrated over time.” Programming is certainly a significant part of software engineering: after all, programming is how you generate new software in the first place. If you accept this distinction, it also becomes clear that we might need to delineate between programming tasks (development) and software engineering tasks (development, modification, maintenance). The addition of time adds an important new dimension to programming. Cubes aren’t squares, distance isn’t velocity. Software engineering isn’t programming."

Resposta: Entendo que a engenharia de software é extremamente importante para o desenvolvimento de nossa tecnologia, pois como uma das principais forças técnicas somos responsáveis por mudanças e melhorias. O engenheiro tem um alto comprometimento com o projeto.
