package br.com.dccompany;

public interface Iimpressao {

    boolean transferir(Double transferir, Conta contaTransferida);

    default void imprimir(){
    }

}