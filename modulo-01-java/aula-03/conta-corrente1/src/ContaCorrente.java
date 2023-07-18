public class ContaCorrente {

    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial = 300;

    public void imprimirContaCorrente(){
        System.out.println("Nome do cliente: " + cliente.nome);
        System.out.println("Saldo: " + this.saldo);

    }

    public boolean sacar(double sacar){
        if(sacar > saldo + chequeEspecial){
            return false;
        }{
            return true;
        }

    }

    public boolean depositar(double depositar){
        if (depositar < 0){
            return false;
        } else {
            this.saldo += depositar;
            return true;
        }

    }

    public boolean retornarSaldoComChequeEspecial(double retornarSaldoComChequeEspecial){
        System.out.println("Saldo considerando o limite do cheque especial " + saldo + " + " + chequeEspecial);
        return true;
    }

    public boolean transferir(Double transferir, Cliente clienteTransferido){
        if (transferir < 0){
            return false;
        }
        this.saldo -= transferir;
        System.out.println(cliente.nome + " transferiu " + transferir + " para " + clienteTransferido.nome);
        return true;
    }
}
