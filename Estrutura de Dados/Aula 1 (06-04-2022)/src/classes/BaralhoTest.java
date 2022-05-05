package classes;

class BaralhoTest {
    public static void main(String[] args) throws Exception {
        Baralho baralho = new Baralho();
        try{
            System.out.println(baralho.converterEmPilha().toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}