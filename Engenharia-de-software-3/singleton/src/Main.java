import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Obtém a instância única da conexão com o banco de dados
        ConexaoDatabase conexao1 = ConexaoDatabase.getInstance();

        // Obtém a conexão (exemplo de como seria utilizada em uma consulta, por exemplo)
        Connection connection1 = conexao1.getConnection();
        System.out.println("Conexão 1: " + connection1);

        // Obtém novamente a instância única
        ConexaoDatabase conexao2 = ConexaoDatabase.getInstance();

        // Verifica se as instâncias são as mesmas
        System.out.println("Ambas as instâncias são a mesma? " + (conexao1 == conexao2));

        // Obtém a conexão da segunda instância
        Connection connection2 = conexao2.getConnection();
        System.out.println("Conexão 2: " + connection2);

        // Ambas as instâncias devem ser a mesma
    }
}
