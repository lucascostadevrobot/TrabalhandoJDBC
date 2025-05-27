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
            int idClienteEncontrado = 0;
            Proprietarios proprietarios = new ProprietariosDAO().buscarProprietarioPorId(1);
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
                    "Bruno Silva",
                    43,
                    false
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

    }
}
