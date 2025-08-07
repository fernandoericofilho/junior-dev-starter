public class EXERCICIO31 {

    // Este é o nosso método.
    // public: Pode ser acessado de qualquer lugar.
    // static: Pode ser chamado sem criar um objeto da classe.
    // int: É o tipo de dado que o método VAI RETORNAR.
    // somar: É o nome do método.
    // (int num1, int num2): São os parâmetros, os dados que o método RECEBE.
    public static int somar(int num1, int num2) {
        return num1 + num2; // A palavra 'return' envia o resultado de volta.
    }

    // O método 'main' é usado aqui para testar nosso novo método 'somar'.
    public static void main(String[] args) {
        int resultado = somar(10, 5); // Chamando o método e guardando o retorno.
        System.out.println("A soma de 10 + 5 é: " + resultado);

        int resultado2 = somar(100, 250);
        System.out.println("A soma de 100 + 250 é: " + resultado2);
    }
}