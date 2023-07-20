public interface Iimpressao {

    boolean transferir(Double transferir, Conta contaTransferida);

    default void imprimir(){
    }
}
