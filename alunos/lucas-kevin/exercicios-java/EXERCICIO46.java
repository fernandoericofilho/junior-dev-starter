package Extras;

public class EXERCICIO46 {
    public static void main(String[] args) {
        System.out.println("--- Dias da Semana ---");

        // O método .values() de um enum retorna um array com todas as suas constantes.
        // Usamos um for-each para percorrer e imprimir cada uma.
        for (DiaDaSemana dia : DiaDaSemana.values()) {
            System.out.println(dia);
        }
    }
}