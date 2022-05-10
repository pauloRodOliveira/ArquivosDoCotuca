package com.company;

public class Main {

    public static void main(String[] args) {
        try{
            ConexaoDAO conexao = new ConexaoDAO();
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
