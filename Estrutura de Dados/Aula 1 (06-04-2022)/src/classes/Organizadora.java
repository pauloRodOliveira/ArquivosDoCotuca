package classes;

import java.util.ArrayList;

public class Organizadora {
    protected Baralho baralho;
    protected Pilha ouros,
                    espadas,
                    copas,
                    zap;

    static Pilha organizaOuros(Pilha baralho) throws Exception {
        Pilha Copiabaralho = new Pilha(baralho);
        ArrayList<Carta> baralhoAux = new ArrayList<Carta>();
        Pilha pilhaDeOurosPorValor = new Pilha();

        for(int posicaoDaCarta = 0; posicaoDaCarta <= Copiabaralho.quantidadeElementos() - 1; posicaoDaCarta++){
            Carta carta = (Carta)Copiabaralho.desempilhar();
            if(carta.getNaipe() == Naipe.OUROS) baralhoAux.add(carta);
        }

        int posicao;
        for (posicao = 0; pilhaDeOurosPorValor.quantidadeElementos() < baralhoAux.size(); posicao ++) {
            Carta carta = baralhoAux.get(posicao);
            switch (carta.getValor()){
                case A : pilhaDeOurosPorValor.empilhar(carta);
                case DOIS:
                    if(baralhoAux.get(0).getValor() == Valor.A) {
                        pilhaDeOurosPorValor.empilhar(carta);
                        baralhoAux.remove(posicao);
                    }
                case TRES: if(baralhoAux.get(1).getValor() == Valor.DOIS) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case QUATRO: if(baralhoAux.get(2).getValor() == Valor.TRES) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case CINCO: if(baralhoAux.get(3).getValor() == Valor.QUATRO) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case SEIS: if(baralhoAux.get(4).getValor() == Valor.CINCO) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case SETE: if(baralhoAux.get(5).getValor() == Valor.SEIS) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case OITO: if(baralhoAux.get(6).getValor() == Valor.SETE) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case NOVE: if(baralhoAux.get(7).getValor() == Valor.OITO) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case DEZ: if(baralhoAux.get(8).getValor() == Valor.NOVE) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case RAINHA: if(baralhoAux.get(9).getValor() == Valor.DEZ) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case VALETE: if(baralhoAux.get(10).getValor() == Valor.RAINHA) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
                case REIS: if(baralhoAux.get(11).getValor() == Valor.VALETE) {
                    pilhaDeOurosPorValor.empilhar(carta);
                    baralhoAux.remove(posicao);
                }
            }
        }

        return pilhaDeOurosPorValor;
    }
}
