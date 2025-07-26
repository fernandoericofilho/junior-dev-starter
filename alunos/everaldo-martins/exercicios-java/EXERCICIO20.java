public class EXERCICIO20 {
    public static void main(String[] args) {
        for(int i = 0; i < 4; i++){
            String[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
            System.out.println("Tabuada de " + operacoes[i] + "\n");
            for(int j = 1; j <= 10; j++){                
                for(int l = 1; l <= 10; l++){
                    if(i == 0){
                        System.out.println(j + " + " + l + " = " + (j + l));
                    }
                    else if(i == 1){
                        System.out.println(j + " - " + l + " = " + (j - l));
                    }
                    else if(i == 2){
                        System.out.println(j + " × " + l + " = " + (j * l));
                    }
                    else {
                        System.out.println(j + " ÷ " + l + " = " + (j / l));
                    }
                }
                System.out.println();
            }
        }
    }
}
