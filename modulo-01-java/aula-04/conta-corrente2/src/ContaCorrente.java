public class ContaCorrente extends Conta implements Iimpressao {

    private static double chequeEspecial = 300;
    private Cliente cliente;


    public ContaCorrente( Cliente cliente) {
        this.cliente = cliente;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente(Cliente cliente){
        System.out.println("Nome do cliente: " + cliente.getNome());
        System.out.println("Saldo: " + this.getSaldo());

    }

    public boolean retornarSaldoComChequeEspecial(double retornarSaldoComChequeEspecial, Conta conta){
        System.out.println("Saldo considerando o limite do cheque especial " + conta.getSaldo() + " + " + chequeEspecial);
        return true;
    }

    @Override
    public boolean sacar(double sacar){
        if(sacar > this.getSaldo() + chequeEspecial){
            return false;
        }{
            return true;
        }

    }

    @Override
    public void imprimir() {

    }
}
