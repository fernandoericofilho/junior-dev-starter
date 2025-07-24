public class EXERCICIO22 {
    public static void main(String[] args) {
        double[] array = {25.2, 15.3, 52, 78.3};
        
        double soma = 0;
        double media = 0;

        for(int i = 0; i < array.length; i++){
            soma += array [i];
        }

        media = soma / array.length;
        
        System.out.print("A média dos valores é: " + media);
    }
}