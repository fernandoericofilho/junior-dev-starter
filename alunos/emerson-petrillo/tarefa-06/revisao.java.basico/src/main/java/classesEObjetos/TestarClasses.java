package classesEObjetos;

public class TestarClasses {

    public static void main(String[] args) {

        System.out.println("====== INICIANDO TESTE DAS CLASSES ======\n");

        // --- Testando a Classe Pessoa ---
        System.out.println(">>> 1. Testando Classe Pessoa...");
        Pessoa pessoa1 = new Pessoa("João Silva", 30);
        Pessoa pessoa2 = new Pessoa("Maria Souza", 25);

        pessoa1.exibirDados();
        pessoa2.exibirDados();
        System.out.println("----------------------------------------\n");


        // --- Testando a Classe Carro ---
        System.out.println(">>> 2. Testando Classe Carro...");
        Carro meuCarro = new Carro("Fiat", "Uno");
        meuCarro.exibirInfo();
        meuCarro.acelerar(60);
        meuCarro.acelerar(20);
        meuCarro.frear(30);
        meuCarro.frear(60); // Tentando frear mais do que a velocidade atual
        System.out.println("----------------------------------------\n");


        // --- Testando a Classe Aluno ---
        System.out.println(">>> 3. Testando Classe Aluno...");
        Aluno alunoAprovado = new Aluno("Carlos");
        alunoAprovado.setNota(8.5);
        alunoAprovado.exibirBoletim();

        Aluno alunoReprovado = new Aluno("Ana");
        alunoReprovado.setNota(4.0);
        alunoReprovado.setNota(11.0); // Tentando inserir uma nota inválida
        alunoReprovado.exibirBoletim();
        System.out.println("----------------------------------------\n");


        // --- Testando a Classe ContaBancaria ---
        System.out.println(">>> 4. Testando Classe ContaBancaria...");
        ContaBancaria contaDoJoao = new ContaBancaria("12345-6", "João Silva", 1000.00);
        contaDoJoao.exibirSaldo();
        contaDoJoao.depositar(500.00);
        contaDoJoao.sacar(200.00);
        contaDoJoao.sacar(2000.00); // Tentando sacar mais do que o saldo
        contaDoJoao.exibirSaldo();
        System.out.println("----------------------------------------\n");


        // --- Testando a Classe Produto ---
        System.out.println(">>> 5. Testando Classe Produto...");
        Produto notebook = new Produto("Notebook Gamer", 4500.00);
        notebook.exibirInfo();

        // Calculando o preço com imposto de 7% (ICMS de exemplo)
        double impostoSP = 0.07;
        double precoFinalSP = notebook.getPrecoFinal(impostoSP);
        System.out.println("Preço final em SP (imposto de 7%): R$ " + String.format("%.2f", precoFinalSP));

        // Calculando o preço com imposto de 12% (imposto de importação de exemplo)
        double impostoImportacao = 0.12;
        double precoFinalImportado = notebook.getPrecoFinal(impostoImportacao);
        System.out.println("Preço final com imposto de importação (12%): R$ " + String.format("%.2f", precoFinalImportado));
        System.out.println("----------------------------------------\n");

        System.out.println("====== FIM DOS TESTES ======");
    }
}