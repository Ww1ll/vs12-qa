package br.com.dccompany;

public class ContaCorrente extends Conta implements Iimpressao {

    private static double chequeEspecial = 300;
    private Cliente cliente;


    public ContaCorrente(Cliente cliente, String numero, int agencia, double saldo) {
        super(cliente, numero, agencia, saldo);
    }

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
    public boolean sacar(double sacar) {

        if (sacar > this.getSaldo() + chequeEspecial || sacar < 0) {
            return false;
        }
        this.setSaldo(this.getSaldo() - sacar);
        return true;
    }

    @Override
    public boolean sacar(double sacar, ContaPagamento contaPagamento) {
        return false;
    }

    @Override
    public void imprimir(){

    }

}
