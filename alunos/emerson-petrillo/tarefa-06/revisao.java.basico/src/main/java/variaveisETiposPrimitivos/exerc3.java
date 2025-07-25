package variaveisETiposPrimitivos;

public class exerc3 {

    public static void main(String[] args) {

        //Escreva um programa que troque os valores entre duas variáveis sem usar uma variável auxiliar.

        //primeira versão
        int a = 5;
        int b = 10;

        System.out.println("Antes da troca: a = " + a + " e b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("Depois da troca: a = " + a + " e b = " + b);

        //segunda versão
        int x = 5;
        int y = 10;

        System.out.println("Antes da troca: a = " + a + " e b = " + b);

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println("Depois da troca: a = " + a + " e b = " + b);
    }

}
