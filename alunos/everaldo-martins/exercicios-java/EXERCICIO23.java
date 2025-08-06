public class EXERCICIO23 {
    public static void main(String[] args) {
        double[] array = {25.2, 15.3, 52, 78.3};
        
        double maior = 0;

        for(int i = 0; i < array.length; i++){
            if(array [i] > maior) maior = array [i];
        }
        
        System.out.print("O maior valor encontrado foi: " + maior);
    }
}
