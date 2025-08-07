import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercicio50 {
    public static void main(String[] args) {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("A data atual é " + dataAtual.format(formatador));
        System.out.println("Daqui a 10 dias será " + dataAtual.plusDays(10).format(formatador));
    }
}
