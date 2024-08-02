//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente juliano = new Cliente();
        juliano.setNome("Juliano");

        Cliente paula = new Cliente();
        paula.setNome("Paula");

        ContaCorrente cc = new ContaCorrente(juliano);
        ContaPoupanca poupanca = new ContaPoupanca(juliano);

        ContaCorrente ccPaula= new ContaCorrente(paula);

        cc.depositar(30000);
        cc.transferir(1000,ccPaula);

       cc.imprimirExtrato();
       ccPaula.imprimirExtrato();

       Conta.listarClientes();
    }
}