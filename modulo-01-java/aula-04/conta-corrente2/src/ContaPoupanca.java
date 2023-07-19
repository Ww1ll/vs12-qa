public class ContaPoupanca extends Conta implements Iimpressao{

    final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente) {
    }

    public void creditarTaxa(Conta conta){
        double saldoConta = conta.getSaldo();
       saldoConta *= JUROS_MENSAL;
        System.out.println("Saldo considerando juros: " + saldoConta);
    }


    @Override
    public boolean sacar(double sacar){
        if(sacar > this.getSaldo()){
            return false;
        }{
            return true;
        }

    }


    @Override
    public void imprimir() {

    }
}
