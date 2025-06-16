import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Conta {
    int numeroConta;
    String agenciaConta;
    String clienteNome;
    double saldo;

    public Conta(int numeroConta, String agenciaConta, String clienteNome, double saldo) {
        this.numeroConta = numeroConta;
        this.agenciaConta = agenciaConta;
        this.clienteNome = clienteNome;
        this.saldo = saldo;
    }

}

public class ContaTerminal {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<Integer, Conta> contas = new HashMap<>();

        contas.put(123, new Conta(123, "0001-1", "João da Silva", 1000.00));
        contas.put(456, new Conta(456, "0001-1", "Maria do Carmo", 1227.00));
        contas.put(789, new Conta(789, "0001-1", "José Leôncio", 987.00));
        contas.put(987, new Conta(987, "0002-1", "Ernesto Souza", -12.50));

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("                      DIO BANK                       ");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        System.out.println();
        System.out.println("             Bem-vindo(a) ao DIO Bank !!!\n");

        System.out.print("  Primeiro, digite o número da sua conta:\n   >> ");
        var contaNumero = scan.nextInt();
        scan.nextLine();

        System.out.print("\n  Agora, digite o número da sua agência (ex: 1111-1): \n   >> ");
        var contaAgencia = scan.nextLine();

        Conta conta = contas.get(contaNumero);

        if (conta != null && conta.agenciaConta.equals(contaAgencia) && conta.saldo > 0) {
            System.out.printf("\n  Olá %s, obrigado por criar uma conta" +
                            "\n  em nosso banco, seus dados bancários são:" +
                            "\n  Agência: %s" +
                            "\n  Conta: %d" +
                            "\n  Saldo: %.2f" +
                            "\n  Já está disponível para saque.", conta.clienteNome, conta.agenciaConta,
                            conta.numeroConta,  conta.saldo);
        }
        else if (conta != null && conta.agenciaConta.equals(contaAgencia) && conta.saldo <= 0) {
            System.out.printf("\n  Olá %s, obrigado por criar uma conta" +
                            "\n  em nosso banco, seus dados bancários são:" +
                            "\n  Agência: %s" +
                            "\n  Conta: %d" +
                            "\n  Saldo: %.2f", conta.clienteNome, conta.agenciaConta, conta.numeroConta,  conta.saldo);
        }
        else {
            System.out.println("\n  Desculpe, dados não encontrados. ");
        }

        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    }
}