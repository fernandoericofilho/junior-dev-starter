import ClassesEObjetos.Carro;

public class EXERCICIO37 {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Ford", "Mustang");

        System.out.println("Carro criado: " + meuCarro.getMarca() + " " + meuCarro.getModelo());
        System.out.println("Velocidade inicial: " + meuCarro.getVelocidade() + " km/h.");

        meuCarro.acelerar(60);
        meuCarro.acelerar(40);
        meuCarro.frear(20);
        meuCarro.frear(90); // Vai tentar frear 90, mas a velocidade ficará em 0.
    }
}