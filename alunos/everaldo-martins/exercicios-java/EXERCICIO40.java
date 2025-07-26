public class EXERCICIO40 {
    public class Produto {
        private String nome;
        private double preco;
        private double taxa;

        public Produto(){}

        public Produto(String nome, double preco, double taxa) {
            this.nome = nome;
            this.preco = preco;
            this.taxa = taxa;
        }

        public double calcularPrecoFinal() {
            double imposto = preco * (taxa / 100);
            return preco + imposto;
        }

        public void exibirPreco() {
            System.out.printf("%s - Preço: R$%.2f (Imposto: %.1f%%) - Total: R$%.2f%n",
                nome, preco, taxa, calcularPrecoFinal());
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public double getTaxa() {
            return taxa;
        }

        public void setTaxa(double taxa) {
            this.taxa = taxa;
        }
    }
}
