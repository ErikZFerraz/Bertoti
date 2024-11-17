
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
    }
}