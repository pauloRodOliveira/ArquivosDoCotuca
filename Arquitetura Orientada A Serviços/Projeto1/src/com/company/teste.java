package com.company;

import classes.Logradouro;
import classes.UsuarioWS;
import classes.classesDAO.UsuarioDAO;
import classes.classesDBO.UsuarioDBO;

public class teste {
    public static void main(String[] args) {
        System.out.println(UsuarioDAO.getUser("Paulo"));
    }
}
