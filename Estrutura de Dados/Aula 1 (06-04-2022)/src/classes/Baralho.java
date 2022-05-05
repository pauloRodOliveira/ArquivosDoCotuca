package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Baralho{
    protected ArrayList<Carta> cartas = new ArrayList<Carta>(52);

    public Baralho() throws Exception {
        int qual = 0;

        for (int valor = 1; valor < 14; valor++){
            for (int naipe = 1; naipe <= 4; naipe++) {
                cartas.add(new Carta(naipe, valor));
            }
        }
    }

    public void embaralhar(){
        Collections.shuffle(this.cartas);
    }

    public ArrayList<Carta> retornarBaralhoDesordenado(){
        ArrayList<Carta> baralhoDesordenado = new ArrayList<Carta>(this.cartas);
        Collections.shuffle(baralhoDesordenado);
        return baralhoDesordenado;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public Pilha converterEmPilha() throws Exception {
        Pilha pilha = new Pilha(this.cartas.size());

        for(int posicao = 0; posicao <= this.cartas.size() - 1; posicao++){
            pilha.empilhar(this.cartas.get(posicao));
        }

        return pilha;
    }

    public String toString(){
        String ret = ""+cartas;
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baralho baralho = (Baralho) o;
        return Objects.equals(cartas, baralho.cartas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartas);
    }
}