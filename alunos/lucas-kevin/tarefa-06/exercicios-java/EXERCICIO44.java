import ClassesEObjetos.Funcionario;

public class EXERCICIO44 {
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario("José", 3000.00);

        System.out.println("--- Salário Inicial ---");
        func1.exibirDetalhes();

        System.out.println("\n--- Aplicando aumento de 10% ---");
        func1.aplicarAumento(10); // Aumento de 10%

        System.out.println("\n--- Salário Final ---");
        func1.exibirDetalhes(); // Esperado: 3300.00
    }
}