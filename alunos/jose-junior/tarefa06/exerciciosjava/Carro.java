public class Carro {
    private String marca;
    private String modelo;
    private int velocidade;

    public Carro() {

    }

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = 0;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public void acelerar() {
        this.velocidade += 10;
        System.out.println("Acelerando o " + getMarca() + " " + getModelo() + "...");
    }

    public void frear() {
        this.velocidade = 0;
        System.out.println("Freando o " + getMarca() + " " + getModelo() + "...");
    }
}
