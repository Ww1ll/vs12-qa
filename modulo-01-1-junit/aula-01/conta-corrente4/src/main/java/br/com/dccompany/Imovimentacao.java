package br.com.dccompany;

public interface Imovimentacao {

    boolean sacar(double sacar);
    boolean sacar(double sacar, ContaCorrente contaCorrente);

    boolean sacar(double sacar, ContaPagamento contaPagamento);

    boolean depositar(double depositar);

    boolean transferir(Double transferir, Conta contaTransferida);



}
