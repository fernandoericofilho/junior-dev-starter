package EnumCollectionsDatas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class exerc50LocalDate2 {

    //Adicione 10 dias à data atual usando a API de datas (java.time).

    public void adicionarDiasEExibir(int diasParaAdicionar) {
        // 1. Obtém a data atual
        LocalDate dataAtual = LocalDate.now();

        // 2. Adiciona o número de dias especificado.
        //    O metodo plusDays() retorna um NOVO objeto LocalDate.
        LocalDate dataFutura = dataAtual.plusDays(diasParaAdicionar);

        // 3. (Bônus) Cria um formatador para o padrão brasileiro (dd/MM/yyyy)
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // 4. Exibe os resultados formatados
        System.out.println("--- Calculando Datas ---");
        System.out.println("Data de referência (hoje): " + dataAtual.format(formatador));
        System.out.println("Data daqui a " + diasParaAdicionar + " dias: " + dataFutura.format(formatador));
        System.out.println("------------------------");
    }
}
