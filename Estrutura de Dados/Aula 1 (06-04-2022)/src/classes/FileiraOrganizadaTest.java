package classes;

class FileiraOrganizadaTest {
    public static void main(String[] args) throws Exception {
        Baralho baralho = new Baralho();
        //baralho.embaralhar();
        try{
            baralho.embaralhar();
            System.out.println(baralho.converterEmPilha().toString());
            System.out.println(Organizadora.organizaOuros(baralho.converterEmPilha()));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}