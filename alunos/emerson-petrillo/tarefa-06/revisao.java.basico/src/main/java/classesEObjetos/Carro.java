package classesEObjetos;

public class Carro {

    //exerc37
    //Crie uma classe Carro com marca, modelo e velocidade. Adicione métodos para acelerar e frear.

    private String marca;
    private String modelo;
    private int velocidade;

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = 0;
    }

    public void acelerar(int incremento) {
        if (incremento > 0) {
            this.velocidade = this.velocidade + incremento;
            System.out.println(this.modelo + " acelerando... Velocidade atual: " + this.velocidade + " km/h");
        }
    }

    public void frear(int decremento) {
        if (decremento > 0) {
            this.velocidade = this.velocidade - decremento;
            if (this.velocidade < 0) {
                this.velocidade = 0;
            }
            System.out.println(this.modelo + " freando... Velocidade atual: " + this.velocidade + " km/h");
        }
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public void exibirInfo() {
        System.out.println("Carro: " + this.marca + " " + this.modelo);
    }
}
