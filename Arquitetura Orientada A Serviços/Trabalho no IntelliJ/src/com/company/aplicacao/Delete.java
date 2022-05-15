package com.company.aplicacao;

import com.company.dao.ClienteDAO;

public class Delete {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();

        // Passe o ID nos parenteses para deletar.

        clienteDAO.deleteByID(4);

        System.out.println("DADOS DELETADOS COM SUCESSO");

    }
}
