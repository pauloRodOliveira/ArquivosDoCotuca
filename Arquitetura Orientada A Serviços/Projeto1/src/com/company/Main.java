package com.company;

import classes.Logradouro;
import classes.Teclado;
import classes.UsuarioWS;
import classes.classesDAO.UsuarioDAO;
import classes.classesDBO.UsuarioDBO;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean sair = false;
        while(!sair) {
            System.out.println("Já utilizou o programa antes? ");
            String resposta = Teclado.getUmString();

            resposta.toLowerCase();

            if(!resposta.equals("sim") && !resposta.equals("nao")) {
                System.err.println("Resposta inválida");
                continue;
            }

            //Se a resposta for "nao", ele segue para a área de cadastro
            if(resposta.equals("nao")) {
                System.out.println("\n Seja bem-vindo(a)!");

                boolean cadastrado = false;
                do {
                    try {
                        //classe usuarioDBO, irá representar uma instância da tabela usuarios dentro do programa
                        UsuarioDBO usuarioDBO = new UsuarioDBO();

                        //Pedindo para o usuario digitar o nome
                        for(;;) {
                            System.out.println("\nPor favor, digite seu nome de usuario: ");
                            String nome = Teclado.getUmString();

                            //Verificando se o nome excede o número de caracteres permitidos, se é nulo ou se é vazio
                            if (nome.length() > 40 || nome.equals(" ") || nome == null){
                                System.err.println("Excedeu o número de caracteres, ou está vazio ou voce não digitou nada");
                                continue;
                            }

                            //Verificando se o nome ja existe
                            if(UsuarioDAO.getUser(nome).getNome() != null) {
                                System.err.println("\nNome de usuário já existente");
                                System.out.println(nome);
                                System.out.println(UsuarioDAO.getUser(nome));
                                continue;
                            }

                            //Adicionando o nome na classe usuario
                            usuarioDBO.setNome(nome);

                            //Se tudo for digitado corretamente, sair do loop infinito
                            break;
                        }

                        //Pedindo para o usuario digitar o seu cep
                        for(;;) {
                            System.out.println("\nPor favor, digite seu Cep (sem traço): ");
                            String cep = Teclado.getUmString();

                            //Verificando se o cep excede o número de algarismos permitido, se ele é nulo, se ele é vazio
                            if (cep.length() != 8 || cep.equals(" ") || cep == null) {
                                System.err.println("CEP inválido");
                                continue;
                            }

                            boolean temLetra = false;
                            for (char caract : cep.toCharArray()) {
                                if (Character.isLetter(caract)){
                                    System.err.println("Formato inválido");
                                    temLetra = true;
                                    break;
                                }
                            }
                            if(temLetra) continue;

                            //Adicionando o cep à classe usuariro
                            usuarioDBO.setCep(cep);

                            //Se tudo for digitado corretamente, sair do loop infinito
                            break;
                        }

                        //Pedindo para o usuario digitar o seu número de casa
                        for(;;) {
                            System.out.println("\nPor favor, digite o número da sua casa: ");
                            int numCasa = Teclado.getUmInt();

                            //Verificando o que o usuário digitou
                            if (numCasa < 0){
                                System.err.println("Número inválido");
                                continue;
                            }

                            //Adicionando o numero da casa à classe usuario
                            usuarioDBO.setNumCasa(numCasa);

                            //Se tudo for digitado corretamente, sair do loop infinito
                            break;
                        }

                        //Pedindo para o usuario digitar o seu complemento
                        for(;;) {
                            System.out.println("\nPor favor, digite o seu complemento: ");
                            String complemento = Teclado.getUmString();

                            //Verificando se o que o usuário digitou
                            if (complemento.length() > 40 || complemento.equals(" ")){
                                System.err.println("Complemento inválido!");
                                continue;
                            }

                            //Adicionando o complemento na classe usuario
                            usuarioDBO.setComplemento(complemento);

                            //Se tudo for digitado corretamente, sair do loop infinito
                            break;
                        }

                        //Enviando os dados do usuário para o banco de dados
                        UsuarioDAO.insertUser(usuarioDBO);

                        //Busca as informações do CEP na API
                        Logradouro logradouro = (Logradouro) UsuarioWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", usuarioDBO.getCep());

                        //Insere o complemento no logradouro
                        logradouro.setComplemento(usuarioDBO.getComplemento());

                        //Mostra as informações do logradouro para o cliente
                        System.out.println(
                                "\nNome.......: " + usuarioDBO.getNome() +
                                        "\n" +
                                        logradouro
                        );

                        //Continuar usando programa?
                        for(;;){
                            System.out.println("\nDeseja continuar utilizando o programa");
                            resposta = Teclado.getUmString();

                            resposta.toLowerCase();

                            if(!resposta.equals("nao") && !resposta.equals("sim")) {
                                System.err.println("Resposta inválida");
                                continue;
                            }

                            break;
                        }

                        //Usuario cadastrado pode sair da área de cadastro
                        cadastrado = true;
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }while(!cadastrado);
            }

            //Se o usuario não quis continuar utilizando o programa, terminar o loop e despedir-se do usuario
            if(resposta.equals("nao")) break;
            else {
                try {
                    //Se o usuario confirmou que já usou antes, ele será direcionado para este trecho

                    System.out.println("\nSeja bem-vindo(a), novamente!");
                    UsuarioDBO usuarioDBO = new UsuarioDBO();

                    //Pedindo para o usuario digitar o nome
                    for (; ; ) {
                        System.out.println("\nPor favor, digite seu nome: ");
                        String nome = Teclado.getUmString();

                        //Verificando se o nome excede o número de caracteres permitidos, se é nulo ou se é vazio
                        if (nome.length() > 40 || nome.equals(" ") || nome == null) {
                            System.err.println("Excedeu o número de caracteres, ou está vazio ou voce não digitou nada");
                            continue;
                        }

                        //Adicionando o nome na classe usuario
                        usuarioDBO.setNome(nome);

                        //Se tudo for digitado corretamente, sair do loop infinito
                        break;
                    }

                    //Procura pelo primeiro usuario da lista de acordo com o nome inserido
                    usuarioDBO = UsuarioDAO.getUser(usuarioDBO.getNome());

                    Logradouro logradouro = (Logradouro) UsuarioWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", usuarioDBO.getCep());

                    //Insere o complemento e numero da casa do usuario no logradouro
                    logradouro.setComplemento(usuarioDBO.getComplemento());
                    logradouro.setNumCasa(usuarioDBO.getNumCasa());

                    //Mostra as informações do logradouro para o cliente
                    System.out.println(
                            "\nNome.......: " + usuarioDBO.getNome() +
                                    "\n" +
                                    logradouro
                    );

                    //Continuar utilizando o programa?
                    for (; ; ) {
                        System.out.println("\nDeseja continuar utilizando o programa");
                        resposta = Teclado.getUmString();

                        resposta.toLowerCase();

                        if (!resposta.equals("nao") && !resposta.equals("sim")) {
                            System.err.println("Resposta inválida");
                            continue;
                        }

                        if (resposta.equals("nao")) {
                            sair = true;
                            break;
                        } else {
                            break;
                        }
                    }
                }catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }
        System.out.println("Obrigado por utilizar o Programa!");
        System.exit(0);
    }
}
