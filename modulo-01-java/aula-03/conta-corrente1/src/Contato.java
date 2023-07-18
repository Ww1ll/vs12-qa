public class Contato {
    public String descricao;
    public String telefone;
    public int tipoEndereco = 0;


    public void imprimirContato(){
        if (telefone != null){
        System.out.println("Contato cliente:");
        System.out.println(" 1 - residencial / 2 - comercial");
        System.out.println(descricao + " - " + telefone + " - " + tipoEndereco);
        }
    }

}
