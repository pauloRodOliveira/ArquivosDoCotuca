package com.company;
import classes.*;


public class Main {

    public static void main(String[] args) throws Exception {
        /*System.out.println( "Baralho desordenado: " + meuBaralho.retornarBaralhoDesordenado());
        System.out.println( "Baralho ordenado: " + meuBaralho + "\n");*/

        Baralho baralho = new Baralho();
        baralho.embaralhar();
        Pilha pilha = new Pilha(baralho.converterEmPilha());
        Carta carta = pilha.desempilhar();
        FileiraOrganizada fileiraOrganizada = new FileiraOrganizada(4);
        FileiraOrganizada fileiraAuxilio = new FileiraOrganizada(10);


        boolean terminou = false;
        byte escolha;

        do{
            System.out.println("\nPrimeira carta do Baralho: " + carta);
            System.out.println("Escolha sua pilha: ");
            System.out.println("Fileira de Auxílio:" + fileiraAuxilio +
                               "Fileira de Organização: \n" + fileiraAuxilio);
            escolha = Teclado.getUmByte((byte) 0, (byte)3);
            fileiraOrganizada.getPilhaDaFileira().get(escolha).empilhar(carta);
            carta = pilha.desempilhar();
            terminou = true;
        }while(!terminou);
    }
}
