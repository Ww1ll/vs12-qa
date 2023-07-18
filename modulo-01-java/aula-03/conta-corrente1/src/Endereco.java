public class Endereco {
    public int tipoEndereco = 0;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;
    public void imprimirEndereco(){
        System.out.println(" 1 - residencial / 2 - comercial");
        System.out.println(tipoEndereco + "- " + logradouro + ", " + numero + " - " + complemento + " - " + cep + " / " + cidade + ", "+ estado + ", " + pais);

    }

}
