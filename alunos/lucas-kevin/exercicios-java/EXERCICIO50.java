import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EXERCICIO50 {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();

        // O método .plusDays() retorna um NOVO objeto LocalDate com a data calculada.
        // A API java.time é "imutável".
        LocalDate daquiADezDias = hoje.plusDays(10);

        // Criamos um formatador para exibir a data no padrão brasileiro
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Data de hoje: " + hoje.format(formatador));
        System.out.println("Data daqui a 10 dias: " + daquiADezDias.format(formatador));
    }
}