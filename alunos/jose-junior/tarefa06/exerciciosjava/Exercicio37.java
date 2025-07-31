public class Exercicio37 {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.setMarca("Ford");
        carro1.setModelo("Ka");
        Carro carro2 = new Carro("Fiat", "Cronos");

        carro1.acelerar();
        carro1.acelerar();
        carro1.frear();

        carro2.acelerar();
        carro2.acelerar();
        carro2.frear();
    }
}
