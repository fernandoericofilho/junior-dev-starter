public class EXERCICIO05 {
    public static void main(String[]args){
        final int val = 10;

        val = 15; //Exception: The final local variable val cannot be assigned. It must be blank and not using a compound assignment

        System.out.println("Valor final: " + val);
    } 
}
