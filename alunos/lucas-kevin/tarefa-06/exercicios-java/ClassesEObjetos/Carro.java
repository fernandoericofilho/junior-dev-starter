package ClassesEObjetos;

public class Carro {
    // Atributos
    private String marca;
    private String modelo;
    private int velocidade;

    // Construtor
    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = 0;
    }

    // Método para acelerar
    public void acelerar(int incremento) {
        this.velocidade += incremento;
        System.out.println(this.modelo + " acelerou para " + this.velocidade + " km/h.");
    }

    // Método para diminuir a velocidade
    public void frear(int decremento) {
        this.velocidade -= decremento;
        if (this.velocidade < 0) {
            this.velocidade = 0;
        }
        System.out.println(this.modelo + " freou para " + this.velocidade + " km/h.");
    } // <<<<<<< AQUI termina o método frear.

    // --- MÉTODOS GETTERS ---
    // Os getters ficam AQUI, dentro da classe Carro, mas FORA de outros métodos.
    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

} // <<<<<<< AQUI termina a classe Carro.