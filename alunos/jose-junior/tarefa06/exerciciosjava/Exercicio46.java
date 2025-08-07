public class Exercicio46 {

    public enum DiasDaSemana { Segunda, Terça, Quarta, Quinta, Sexta, Sábado, Domingo}

    public static void main(String[] args) {
        System.out.println("--- Dias da Semana ---");
        for (DiasDaSemana dia : DiasDaSemana.values()) {
            System.out.println(dia);
        }
        System.out.println("---------");
    }
}
