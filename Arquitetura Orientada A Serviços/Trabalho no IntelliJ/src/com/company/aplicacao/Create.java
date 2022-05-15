package com.company.aplicacao;

import com.company.Model.Cliente;
import com.company.dao.ClienteDAO;

public class Create {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();


        Cliente cliente = new Cliente();

        cliente.setNome("Rafael Zanon");
        cliente.setIdade(18);
        //digite seu cep aqui
        cliente.setCep("00000000");
        //digite o seu numero da casa
        cliente.setNumeroCasa(0000);
        cliente.setComplemento("");

        clienteDAO.save(cliente);

    }
}
