package com.company.aplicacao;


import com.company.Model.Cliente;
import com.company.Model.ClienteWS;
import com.company.Model.Logradouro;
import com.company.dao.ClienteDAO;

public class Read{
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();

      for (Cliente s: clienteDAO.getCliente()){
          System.out.println("Nome Cliente: " + s.getNome());
          System.out.println("Idade Cliente: " + s.getIdade());
          System.out.println("Numero da Casa: " + s.getNumeroCasa());

          String s1 = s.getCep();
          Logradouro logradouro = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", s1);
          System.out.println(logradouro);
      }

    }
}

