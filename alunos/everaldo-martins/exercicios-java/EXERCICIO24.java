public class EXERCICIO24 {
    public static int[] reversedArray(int[] oArr) {
        int[] rArr = new int[oArr.length];
        for (int i = 0; i < oArr.length; i++) {
            rArr[i] = oArr[(oArr.length - 1) - i];
        }
        return rArr;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.print("Array inicial: [");
        for(int i = 0; i < array.length; i++){
            if(i < array.length - 1) System.out.printf("%d ", array [i]);
            else System.out.printf("%d", array [i]);
        }
        System.out.println("]");

        array = reversedArray(array);
        
        System.out.print("Array após reverção: [");
        for(int i = 0; i < array.length; i++){
            if(i < array.length - 1) System.out.printf("%d ", array [i]);
            else System.out.printf("%d", array [i]);
        }
        System.out.print("]");
    }
}
