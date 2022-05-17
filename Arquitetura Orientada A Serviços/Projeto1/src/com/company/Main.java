package com.company;

import classes.Logradouro;
import classes.Teclado;
import classes.UsuarioWS;
import classes.bd.ConexaoBD;
import classes.classesDAO.UsuarioDAO;
import classes.classesDBO.UsuarioDBO;

public class Main {

    public static void main(String[] args) {
        try {
            UsuarioDBO usuarioDBO = new UsuarioDBO();

            //Pedindo para o usuario digitar o nome
            System.out.println("Por favor, digite seu nome: ");
            String nome = Teclado.getUmString();

            //Verificando se o nome excede o número de caracteres permitidos, se é nulo ou se é vazio
            if(nome.length() > 40 || nome.equals(" ") || nome == null) throw new Exception("Nome inválido");

            //Adicionando o nome na classe usuario
            usuarioDBO.setNome(nome);

            //Pedindo para o usuario digitar o seu cep
            System.out.println("\nPor favor, digite seu Cep neste formato 10000-100: ");
            String cep = Teclado.getUmString();
            String cepAdd = null;

            //verificando se o cep excede o número de algarismos permitido, se ele é nulo, se ele é vazio
            /*if(cep.length() != 9 || cep.equals(" ") || cep == null) throw new Exception("CEP inválido");
            int pos = 0;
            for (char caract : cep.toCharArray()){
                pos++;
                if((pos <=5 || pos > 6) && Character.isDigit(caract)) cepAdd += caract;
                if(pos == 6 && Character.isLetter(caract)) cepAdd += caract;
                else throw new Exception("Formato inválido!");
            }*/

            //Adicionando o cep à classe usuariro
            usuarioDBO.setCep(cep);

            //Pedindo para o usuario digitar o seu número de casa
            System.out.println("\nPor favor, digite o número da sua casa: ");
            int numCasa = Teclado.getUmInt();

            //Verificando o que o usuário digitou
            if(numCasa < 0) throw new Exception("Número inválido");

            //Adicionando o numero da casa à classe usuario
            usuarioDBO.setNumCasa(numCasa);

            //Pedindo para o usuario digitar o seu complemento
            System.out.println("\nPor favor, digite o seu complemento: ");
            String complemento = Teclado.getUmString();

            //Verificando se o que o usuário digitou
            if(complemento.length() > 40 || complemento.equals(" ")) throw new Exception("Complemento inválido!");

            //Adicionando o complemento na classe usuario
            usuarioDBO.setComplemento(complemento);

            //Enviando os dados do usuário para o banco de dados
            UsuarioDAO.insert(usuarioDBO);

            Logradouro logradouro = (Logradouro) UsuarioWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", usuarioDBO.getCep());
            System.out.println(logradouro);

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            for(UsuarioDBO usuario : usuarioDAO.getUsuarios()){
                System.out.println(usuario);
            }
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
        }
    }
}
