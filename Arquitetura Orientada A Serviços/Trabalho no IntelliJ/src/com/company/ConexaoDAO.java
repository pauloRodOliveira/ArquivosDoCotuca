package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexaoDAO {
    public Connection Conection(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3000/teste?user=root&password=2910";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
        }

        return conn;
    }
}