public class EXERCICIO37 {
    public class Carro {
        private String marca;
        private String modelo;
        private double velocidade;

        public Carro(){};

        public Carro(String marca, String modelo, double velocidade){
            this.marca = marca;
            this.modelo = modelo;
            this.velocidade = velocidade;
        }

        public void acelerar(double velocidade) {
            this.velocidade += velocidade;
        }

        public void frear(double velocidade) {
            this.velocidade -= velocidade;
            if (this.velocidade < 0) {
                this.velocidade = 0;
            }
        }
        
        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public double getVelocidade() {
            return velocidade;
        }

        public void setVelocidade(double velocidade) {
            this.velocidade = velocidade;
        }
    }
}
