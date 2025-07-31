public class EXERCICIO35 {
    public static int media(int[] array) {
        int soma = 0;
        for (int i = 0; i < array.length; i++){
            soma += array[i];
        }

        return soma / array.length;
    }

    public static void main(String[] args) {
        int[] array = {25, 13, 52, 73};  
        System.out.printf("A média dos valores é %d", media(array));
    }
}
