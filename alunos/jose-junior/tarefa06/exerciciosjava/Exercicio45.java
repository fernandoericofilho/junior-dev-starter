public class Exercicio45 {
    public static void main(String[] args) {
        Funcionario primeiroFuncionario = new Funcionario("Júnior", 3000);
        primeiroFuncionario.receberAumento(20);
        
        Funcionario segundoFuncionario = new Funcionario("Ana", 5000);
        segundoFuncionario.receberAumento(10);

        System.out.println("Após o aumento, " + primeiroFuncionario.getNome() + " agora tem um salário de " + primeiroFuncionario.getSalario() + " R$");
        System.out.println("Após o aumento, " + segundoFuncionario.getNome() + " agora tem um salário de " + segundoFuncionario.getSalario() + " R$");
    }
}
