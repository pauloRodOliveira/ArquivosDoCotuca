package classes;

import java.util.ArrayList;

public class FileiraOrganizada {
    int qtd = 4;
    protected ArrayList<Pilha> fileira;

    public FileiraOrganizada(int qtd){
        this.qtd = qtd;
        this.fileira = new ArrayList<>(4);
        for(int posicao = 0; posicao <= qtd; posicao++){
            Pilha pilha = new Pilha(13);
            this.fileira.add(pilha);
        }
    }

    public ArrayList<Pilha> getPilhaDaFileira(){
        return this.fileira;
    }

    @Override
    public String toString(){
        String primeirasCartas = "";
        try {
            for(int posicao = 0; posicao <= 3; posicao++){
                if(fileira.get(posicao).consulta() == null) primeirasCartas += "\nPilha " + posicao + ": " + " vazia.";
                else primeirasCartas += "\nPilha " + posicao + ": " + fileira.get(posicao).consulta();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return primeirasCartas;
    }
}
