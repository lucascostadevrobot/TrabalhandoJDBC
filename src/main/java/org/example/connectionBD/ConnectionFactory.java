package org.example.connectionBD;

import javax.swing.*;
import java.sql.*;

public class ConnectionFactory {
    /*public static void main(String[] args) {

    }*/

    private static final String URL = "jdbc:mysql://localhost:3306/meu_condominio";
    private static final String USER = "root";
    private static final String PASSWORD = "admin123";

    private ConnectionFactory() {
        // construtor privado para evitar instâncias
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carrega o driver
            JOptionPane.showMessageDialog(null, "Conexão Estabelecida com sucesso...");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Drive não econtrado. Erro na Conection Factory");
            throw new RuntimeException("Driver JDBC não encontrado", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

