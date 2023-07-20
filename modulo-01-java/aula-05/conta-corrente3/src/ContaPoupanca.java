public class ContaPoupanca extends Conta implements Iimpressao{

    final double JUROS_MENSAL = 1.01;


    public ContaPoupanca(Cliente cliente, String numero, int agencia, double saldo) {
        super(cliente, numero, agencia, saldo);
    }

    public void creditarTaxa(Conta conta){
        double saldoConta = conta.getSaldo();
       saldoConta *= JUROS_MENSAL;
        System.out.println("Saldo considerando juros: " + saldoConta);
    }


    @Override
    public boolean sacar(double sacar){
        if(sacar > this.getSaldo() || sacar < 0){
            return false;
        }{
            return true;
        }

    }

    @Override
    public boolean sacar(double sacar, ContaPagamento contaPagamento) {
        return false;
    }

    @Override
    public void imprimir() {

    }
}
