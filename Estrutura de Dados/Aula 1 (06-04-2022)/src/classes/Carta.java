package classes;

import java.util.ArrayList;

public class Carta{
    protected Naipe naipe;
    protected Valor valor;
    protected int valorNumerico;
    protected int naipeNumerico;
    protected char cor;

    public Carta(int n, int v) throws Exception
    {
        Naipe naipe = Naipe.ZAP;
        Valor valor = Valor.A;
        this.naipeNumerico = n;
        this.valorNumerico = v;

        if(n == 1) naipe = Naipe.OUROS;
        else if(n == 2) naipe = Naipe.ESPADAS;
        else if(n == 3) naipe = Naipe.COPAS;
        else if(n == 4) naipe = Naipe.ZAP;
        else throw new Exception("The naipe needs to be a value between: 1, 2, 3, 4.");

        if(v == 1)  valor = Valor.A;
        else if(v == 2)  valor = Valor.DOIS;
        else if(v == 3)  valor = Valor.TRES;
        else if(v == 4)  valor = Valor.QUATRO;
        else if(v == 5)  valor = Valor.CINCO;
        else if(v == 6)  valor = Valor.SEIS;
        else if(v == 7)  valor = Valor.SETE;
        else if(v == 8)  valor = Valor.OITO;
        else if(v == 9)  valor = Valor.NOVE;
        else if(v == 10)  valor = Valor.DEZ;
        else if(v == 11)  valor = Valor.RAINHA;
        else if(v == 12)  valor = Valor.VALETE;
        else if(v == 13)  valor = Valor.REIS;

        this.naipe = naipe;
        this.valor = valor;
    }

    public Carta(Carta carta) {
        this.valorNumerico = carta.valorNumerico;
        this.naipeNumerico = carta.naipeNumerico;
        this.valor = carta.valor;
        this.naipe = carta.naipe;
        this.cor = carta.cor;
    }

    public Naipe getNaipe(){
        return this.naipe;
    }

    public Valor getValor(){
        return this.valor;
    }

    @Override
    public String toString(){
        return valor + " de " + naipe;
    }

    public int comparareTo(Carta carta){
        int result = 0;

        if(this.valorNumerico > carta.valorNumerico) result = 1;

        if(this.valorNumerico == carta.valorNumerico){
            if(this.naipeNumerico > carta.naipeNumerico) result = 1;
        }else if(this.naipeNumerico == carta.naipeNumerico) {
            if (this.valorNumerico > carta.valorNumerico) result = 0;
        }

        //colocar comparação de igual

        return result;
    }
}