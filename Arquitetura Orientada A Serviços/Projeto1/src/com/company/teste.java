package com.company;

import classes.classesDAO.UsuarioDAO;
import classes.classesDBO.UsuarioDBO;

public class teste {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        for(UsuarioDBO usuario : usuarioDAO.getUsuarios()){
            System.out.println(usuario);
        }
    }
}
