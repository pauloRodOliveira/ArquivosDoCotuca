import java.sql.conection;
import java.sql.DriverManager;

public class ConexaoDAO {
    public Conection(){
        Conection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3000/teste?user=root&password=2910";
            conn = DriverManager();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

        return conn;
    }
}