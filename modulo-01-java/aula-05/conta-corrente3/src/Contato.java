public class Contato {
    private String descricao;
    private String telefone;
    private int tipoEndereco = 0;

    public Contato(String descricao, String telefone, int tipoEndereco){
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipoEndereco = tipoEndereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(int tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public void imprimirContato(){
        if (telefone != null){
        System.out.println("Contato cliente:");
        System.out.println(" 1 - residencial / 2 - comercial");
        System.out.println(descricao + " - " + telefone + " - " + tipoEndereco);
        }
    }

    @Override
    public String toString(){
        return  descricao + " " + telefone;
    }

}
