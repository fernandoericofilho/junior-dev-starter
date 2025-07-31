import java.time.LocalDate;

public class EXERCICIO49 {
    public static void main(String[] args) {
        LocalDate dataAtual = LocalDate.now();
        
        System.out.println("Data atual: " + dataAtual);
        System.out.println("Dia da semana: " + dataAtual.getDayOfWeek());
    }
}
