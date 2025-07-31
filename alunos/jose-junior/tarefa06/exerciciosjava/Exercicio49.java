import java.time.LocalDate;

public class Exercicio49 {
    
    public enum DiasDaSemana { Segunda, Terça, Quarta, Quinta, Sexta, Sábado, Domingo}
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        DiasDaSemana diaSemana;
        switch (data.getDayOfWeek()) {
            case MONDAY:
                diaSemana = DiasDaSemana.Segunda;
                break;
            case TUESDAY:
                diaSemana = DiasDaSemana.Terça;
                break;
            case WEDNESDAY:
                diaSemana = DiasDaSemana.Quarta;
                break;
            case THURSDAY:
                diaSemana = DiasDaSemana.Quinta;
                break;
            case FRIDAY:
                diaSemana = DiasDaSemana.Sexta;
                break;
            case SATURDAY:
                diaSemana = DiasDaSemana.Sábado;
                break;
            case SUNDAY:
                diaSemana = DiasDaSemana.Domingo;
                break;
            default:
                diaSemana = DiasDaSemana.Segunda;
                break;
        }
        System.out.println("Hoje é " + diaSemana);
    }
}
