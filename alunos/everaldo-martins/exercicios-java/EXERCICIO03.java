public class EXERCICIO03 {
    public static void main(String[]args){
        int val1 = 10;   
        int val2 = 8; 
        
        System.out.println("Antes da troca: " + "\nVal1: " + val1 + "\nVal2: " + val2);

        //Fazendo a troca usando operações aritméticas
        val1 = val1 + val2;
        val2 = val1 - val2;
        val1 = val1 - val2;

        System.out.println("Depois da troca: " + "\nVal1: " + val1 + "\nVal2: " + val2);
    }    
}
