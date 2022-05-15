package com.company;

import com.company.DAO.ConexaoDAO;
import com.company.DAO.UsuarioDAO;
import com.company.DTO.UsuarioDTO;
import com.company.pauloutil.Teclado;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        String nome, senha = null;
        try{
            ConexaoDAO conexao = new ConexaoDAO();

            System.out.println("Digite seu nome: ");
            nome = Teclado.getUmString();

            if(nome != null){
                System.out.println("\nAgora digite sua senha: ");
                senha = Teclado.getUmString();
            }

            if(nome != null && senha != null){
                usuarioDTO.setNome_usuario(nome);
                usuarioDTO.setSenha_usuario(senha);
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ResultSet result = usuarioDAO.autenticacaoUsuario(usuarioDTO);

            if(result.next()){
                //chamar a tela que eu quero abrir
                System.out.println("Senha e Usuário corretos, obrigado por usar o programa :)");
                System.exit(0);
            }else{
                System.out.println("Usuário ou senha errados!");
            }

        }catch (Exception e){
            System.err.println(e);
        }
    }
}
