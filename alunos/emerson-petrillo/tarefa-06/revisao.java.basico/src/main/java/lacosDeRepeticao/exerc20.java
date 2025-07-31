package lacosDeRepeticao;

public class exerc20 {

    public static void main(String[] args) {

        //Implemente uma tabuada do 1 ao 10 com for aninhado.

        for (int i = 1; i <= 10; i++) {
            System.out.println("Tabuada do " + i + ":");
            for (int j = 1; j <= 10; j++) {
                int resultado = i * j;
                System.out.println(i + " x " + j + " = " + resultado);
            }
            System.out.println();
        }
    }
}
