public class EXERCICIO46 {
    public enum DiaSemana {
        DOMINGO, 
        SEGUNDA, 
        TERCA, 
        QUARTA, 
        QUINTA, 
        SEXTA, 
        SABADO
    }

    public static void main(String[] args) {
        for (DiaSemana d : DiaSemana.values()) {
            System.out.println(d);
        }
    }
}
