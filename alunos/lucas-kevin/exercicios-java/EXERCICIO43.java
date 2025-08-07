package ClassesEObjetos;
// Não precisamos importar a classe Calculadora se ela estiver no mesmo pacote

public class EXERCICIO43 {
    public static void main(String[] args) {
        // Note que NÃO criamos um objeto:
        // ERRADO: Calculadora calc = new Calculadora();

        // Chamamos os métodos diretamente a partir do nome da CLASSE
        double soma = Calculadora.somar(10, 5);
        double divisao = Calculadora.dividir(10, 4);

        System.out.println("Soma (usando método estático): " + soma); // Esperado: 15.0
        System.out.println("Divisão (usando método estático): " + divisao); // Esperado: 2.5
    }
}