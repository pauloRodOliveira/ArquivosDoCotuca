package classes.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    //Conexão com o banco de dados

    public static Connection createConnecticonToMySQL() throws Exception {

        //faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.jdbc.Driver");

        //Cria conexão com o banco de dados
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cliente", "sqluser", "password");

        return connection;
    }
}

