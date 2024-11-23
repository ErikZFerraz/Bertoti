import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDatabase {

    private static ConexaoDatabase instance;

    private Connection connection;

    private String url = "jdbc:mysql://localhost:3306/mydatabase";
    private String username = "root";
    private String password = "password";

    private ConexaoDatabase() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer conexão com o banco de dados.");
            e.printStackTrace();
        }
    }

    public static ConexaoDatabase getInstance() {
        if (instance == null) {
            synchronized (ConexaoDatabase.class) {
                if (instance == null) {
                    instance = new ConexaoDatabase();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
