import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private static List<Conta> contas = new ArrayList<>(); // Lista estática de contas

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        contas.add(this);
    }

    public void sacar(double valor) {
        saldo -= valor;
    }


    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
    public static void listarClientes() {
        System.out.println("=== Lista de Clientes ===");
        for (Conta conta : contas) {
            System.out.println(String.format("Titular: %s, Agencia: %d, Numero: %d, Saldo: %.2f",
                    conta.cliente.getNome(), conta.getAgencia(), conta.getNumero(), conta.getSaldo()));
        }
    }
}
