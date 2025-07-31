import java.time.LocalDate;

public class EXERCICIO50 {
    public static void main(String[] args) {
        LocalDate dataAtual = LocalDate.now();

        System.out.println("Data atual: " + dataAtual);
        System.out.println("+10 dias: " + dataAtual.plusDays(10));
        System.out.println("-10 dias: " + dataAtual.minusDays(10));
    }
}
