package classes;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Pilha {
    protected int topo;
    protected ArrayList<Carta> p;
    Carta c;

    public Pilha(){
        this(10);
    }
    public Pilha(int qtos){
        this.p = new ArrayList<Carta>(qtos);
        this.topo = -1;
    }

    public void empilhar(Carta c) throws Exception{
        if(cheia()) throw new Exception("Overflow!");
        if(c == null) throw new Exception("Invalid object!");

        topo++;
        p.add(topo, c);
    }

    public Carta desempilhar() throws Exception{
        if(vazia()) throw new Exception("Underflow error!");

        Carta ret = new Carta(p.get(topo));
        p.remove(p.get(topo));
        topo--;
        return ret;
    }

    public Carta consulta() throws Exception{
        if(vazia()) return null;
        return this.p.get(this.topo);
    }
    public boolean cheia(){
        return (this.topo == this.p.size());
    }

    public boolean vazia(){
        return (this.topo == -1);
    }

    public int quantidadeElementos(){
        return this.p.size();
    }

    public Pilha(Pilha pilha){
        this.topo = pilha.topo;
        this.p = pilha.p;
    }

    @Override
    public String toString (){
        String retorno = "" + this.p;

        return retorno;
    }
}