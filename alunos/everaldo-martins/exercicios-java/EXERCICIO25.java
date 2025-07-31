public class EXERCICIO25 {
    public static int paresEmArray(int[] oArr) { 
        int par = 0;       
        for (int i = 0; i < oArr.length; i++) {
            if(oArr [i] % 2 == 0) par += 1;
        }
        return par;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
        
        System.out.print("Existem " + paresEmArray(array) + " números pares no array.");
    }
}
