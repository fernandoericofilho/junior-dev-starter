package EnumCollectionsDatas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class exerc49LocalDate {

    //Crie uma LocalDate com a data atual e imprima o dia da semana.

    public void exibirDiaDaSemanaAtual() {
        // 1. Obtém a data atual do relógio do sistema
        LocalDate dataAtual = LocalDate.now();

        // 2. Obtém o dia da semana a partir da data
        DayOfWeek diaDaSemanaEnum = dataAtual.getDayOfWeek();

        // 3. Define o idioma para a tradução do nome do dia
        Locale portuguesBrasil = new Locale("pt", "BR");

        // 4. Obtém o nome completo do dia da semana no idioma desejado
        String nomeDoDia = diaDaSemanaEnum.getDisplayName(TextStyle.FULL, portuguesBrasil);

        System.out.println("--- Análise da Data Atual ---");
        System.out.println("A data de hoje é: " + dataAtual);
        System.out.println("Hoje é: " + nomeDoDia);
        System.out.println("-----------------------------");
    }
}

