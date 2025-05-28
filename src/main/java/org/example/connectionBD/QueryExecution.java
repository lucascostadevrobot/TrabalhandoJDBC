package org.example.connectionBD;

import org.example.connectionBD.dao.ProprietariosDAO;
import org.example.connectionBD.model.Proprietarios;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class QueryExecution {
    public static void main(String[] args) {
        ProprietariosDAO proprietariosDAO = new ProprietariosDAO();


        /**
         * 1- Listando Proprietarios sem filtro
         */
        try {
            List<Proprietarios> proprietarios = proprietariosDAO.listar();
            proprietarios.stream().forEach(System.out::println);
            JOptionPane.showMessageDialog(null, "Exibindo a lista de Clientes:" + proprietarios);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /**
         * 3- Listando Proprietario Por id
         */
        try {
            int idClienteEncontrado = 1;
            Proprietarios proprietarios = new ProprietariosDAO().buscarProprietarioPorId(idClienteEncontrado);
            if (proprietarios == null) {
                JOptionPane.showMessageDialog(null, "No momento não existem informações no Banco com Ids, o objeto está nulo....");
            } else {
                JOptionPane.showMessageDialog(null, "Busca de proprietario por ID: " + "Nome do Proprietario" + proprietarios);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }


        /**
         * 3- Realizando inserção de novos proprietarios
         */
        try {

            Proprietarios proprietariosInsercoes = new Proprietarios(
                    "Caio Duarte",
                    16,
                    true
            );
            if (proprietariosInsercoes == null) {
                JOptionPane.showMessageDialog(null, "No momento não é possível realizar cadastro de novo proprietario....");

            } else {
                proprietariosDAO.inserindoProprietario(proprietariosInsercoes);
                JOptionPane.showMessageDialog(null, "Cadastro do novo proprietario com sucesso!!!!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        /**
         * 4- Realizando exclusão dos Proprietarios
         */
        try {
            int idProprietarioDeletado = 2;
            Proprietarios proprietarios = proprietariosDAO.deletandoProprietario(idProprietarioDeletado);
            JOptionPane.showMessageDialog(null, "O seu usuário foi deletado com sucesso e serviço finalizado: " + proprietarios);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
