import java.util.Scanner;

public class EXERCICIO15 {
    public static String calculadora(double a, double b, int op){
        if (op == 1) {
            return String.valueOf(a + b);
        } 
        else if (op == 2) {
            return String.valueOf(a - b);
        } 
        else if (op == 3) {
            return String.valueOf(a * b);
        } 
        else if (op == 4) {
            if (b != 0) {
                return String.valueOf(a / b);
            } 
            return "Erro: Divisão por zero!";
        } 
        return  "";     
    }   

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        
        System.out.println("CALCULADORA BÁSICA");
        System.out.println("------------------");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção (1-5): ");
        
        int opcao = l.nextInt();

        if (opcao >= 1 && opcao <= 4) {
            System.out.print("Digite o primeiro número: ");
            double num1 = l.nextDouble();
            System.out.print("Digite o segundo número: ");
            double num2 = l.nextDouble(); 

            System.out.println("Resultado: " + calculadora(num1, num2, opcao));

            l.close();
        } 
        else if (opcao == 5) {
            System.out.println("Saindo do programa...");
        }  
        else {
            System.out.println("Erro: Opção inválida!");
        }              
    }
}
