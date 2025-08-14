public class EXERCICIO20 {
    public static void main(String[] args) {
        System.out.println("--- Tabuada Completa do 1 ao 10 ---");

        // O primeiro laço 'for' (externo) controla qual tabuada estamos calculando (do 1, do 2, etc.)
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nTabuada do " + i + ":");

            // O segundo laço 'for' (interno) calcula cada linha da tabuada (i * 1, i * 2, etc.)
            for (int j = 1; j <= 10; j++) {
                int resultado = i * j;
                System.out.println(i + " x " + j + " = " + resultado);
            }
        }
    }
}