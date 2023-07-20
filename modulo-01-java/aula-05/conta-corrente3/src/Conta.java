public class Conta implements Imovimentacao {

    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;


    public Conta(Cliente cliente, String numeroConta, int agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Conta() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public boolean sacar(double sacar){
        if(sacar > this.getSaldo() || saldo < 0){
            return false;
        }{
            return true;
        }

    }


    @Override
    public boolean sacar(double sacar, ContaCorrente contaCorrente) {
        if(sacar > saldo + contaCorrente.getChequeEspecial() || sacar < 0){
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
    public boolean depositar(double depositar) {
        if (depositar < 0){
            return false;
        } else {
            this.saldo += depositar;
            return true;
        }
    }

    @Override
    public boolean transferir(Double transferir, Conta contaTransferida){
        if (transferir < 0){
            return false;
        }
        double saldoNovo = this.saldo - transferir;
        setSaldo(saldoNovo);

        double contaATransferir = contaTransferida.saldo + transferir;
        contaTransferida.setSaldo(contaATransferir);

        System.out.println(cliente.getNome() + " transferiu " + transferir + " para " + contaTransferida.getCliente().getNome());
        return true;
    }

}

