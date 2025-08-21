import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class EXERCICIO49 {
    public static void main(String[] args) {
        // LocalDate.now() pega a data atual do sistema
        LocalDate dataAtual = LocalDate.now();

        System.out.println("A data de hoje é: " + dataAtual);

        // .getDayOfWeek() retorna um enum do tipo DayOfWeek
        String diaDaSemana = dataAtual.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));

        System.out.println("Hoje é: " + diaDaSemana);
    }
}