package com.company.DTO;

public class UsuarioDTO {
    private int id_usuario;
    private String nome_usuario;
    private String Senha_usuario;


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
        return Senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        Senha_usuario = senha_usuario;
    }
}
