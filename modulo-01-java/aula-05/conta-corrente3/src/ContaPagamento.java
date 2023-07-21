public class ContaPagamento extends Conta implements Iimpressao{

    static final Double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numero, int agencia, double saldo) {
        super(cliente, numero, agencia, saldo);
    }
    public ContaPagamento(Cliente cliente) {
    }

    @Override
    public boolean sacar(double sacar, ContaPagamento contaPagamento){
        double saldoContaPagamento = contaPagamento.getSaldo() + TAXA_SAQUE;
        if (sacar < 0 || sacar > saldoContaPagamento){
            return false;
        } else {
        saldoContaPagamento -= TAXA_SAQUE;
        return true;
        }
    }

}
