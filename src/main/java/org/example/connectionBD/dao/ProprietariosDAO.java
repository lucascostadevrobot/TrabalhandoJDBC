package org.example.connectionBD.dao;

import org.example.connectionBD.ConnectionFactory;
import org.example.connectionBD.model.Proprietarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProprietariosDAO {

    //Consulta e Lista no Banco de Dados
    public List<Proprietarios> listar() throws SQLException {

        List<Proprietarios> listProprietarios = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tb_proprietarios;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Proprietarios proprietarios = new Proprietarios(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getInt("idade"),
                        resultSet.getBoolean("ativo")
                );
                listProprietarios.add(proprietarios);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProprietarios;
    }


    //Busca por id do Cliente
    public Proprietarios buscarProprietarioPorId(int id) throws SQLException {
        Proprietarios proprietarioId = new Proprietarios();
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM tb_proprietarios WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Proprietarios proprietarios = new Proprietarios(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getInt("idade"),
                        resultSet.getBoolean("ativo")
                );
                proprietarioId.setId(proprietarios.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proprietarioId;
    }


    //Inserção de Proprietarios
    public void inserindoProprietario(Proprietarios proprietarios) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO tb_proprietarios (nome, idade, ativo) VALUES(? , ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, proprietarios.getNome());
            preparedStatement.setInt(2, proprietarios.getIdade());
            preparedStatement.setBoolean(3, proprietarios.isAtivo());
            int inserindoProprietarioNovo = preparedStatement.executeUpdate();
            System.out.println("Inserção de Proprietario pela DAO foi concluido com sucesso" + inserindoProprietarioNovo);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
