package com.company;

import classes.Logradouro;
import classes.UsuarioWS;
import classes.bd.ConexaoBD;

public class Main {

    public static void main(String[] args) {
        try {
            ConexaoBD conexaoBD = new ConexaoBD();
            Logradouro logradouro = (Logradouro) UsuarioWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", "13069526");
            System.out.println(logradouro);
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
        }
    }
}
