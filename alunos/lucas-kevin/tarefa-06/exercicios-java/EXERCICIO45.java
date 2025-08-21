import ClassesEObjetos.Usuario;

public class EXERCICIO45 {
    public static void main(String[] args) {
        // Verificando o total de usuários ANTES de criar qualquer um.
        // Chamamos o método estático diretamente da classe.
        System.out.println("Total de usuários no início: " + Usuario.getTotalDeUsuarios());

        System.out.println("\n--- Criando usuários... ---");

        // Criando o primeiro objeto. O construtor será executado.
        Usuario usuario1 = new Usuario("Alice");

        // Criando o segundo objeto. O construtor será executado novamente.
        Usuario usuario2 = new Usuario("Beto");

        // Criando o terceiro objeto.
        Usuario usuario3 = new Usuario("Carla");

        System.out.println("\n--- Verificação Final ---");
        // Verificando o total de usuários DEPOIS de criar os objetos.
        // O valor é 3, pois o atributo estático foi incrementado 3 vezes.
        System.out.println("Total de usuários agora: " + Usuario.getTotalDeUsuarios());
    }
}