package dataFactory;

import client.ProdutoClient;
import model.Produto;
import model.ProdutoAPI;
import model.ProdutoResponse;
import net.datafaker.Faker;
import org.apache.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Locale;



public class ProdutoDataFactory {

    private static ProdutoClient produtoClient = new ProdutoClient();
    private static Faker faker = new Faker(new Locale("PT-BR"));
    private static SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");


    public static Produto produtoValido(){
        return novoProduto();
    }

    public static Produto produtoInvalido(){
        Produto produto = novoProduto();
        produto.setNome("");

        return produto;
    }

    public static Produto produtoComNomeExistente(String nome){
        Produto produto = new Produto();
        produto.setNome(nome);

        return produto;
    }

    public static ProdutoAPI produtoComNomeInvalido(){
        ProdutoAPI produtoAPI = new ProdutoAPI();
        produtoAPI.setNome("");

        return produtoAPI;
    }

    public static ProdutoAPI produtoComIdInvalido(){
        ProdutoAPI produtoAPI = new ProdutoAPI();
        produtoAPI.set_id(faker.animal().name());

        return produtoAPI;
    }

    public static Produto produtoAtualizadoComIdInvalido(){
        Produto produto = new Produto();
        produto.set_id(faker.animal().name());

        return produto;
    }

    public static ProdutoAPI produtoComIdVazio(){
        ProdutoAPI produtoAPI = new ProdutoAPI();
        produtoAPI.set_id(" ");

        return  produtoAPI;
    }


    public static String produtoCadastrado(){
        ProdutoResponse produtoResponse = produtoClient.cadastrarProduto(produtoValido())
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                    .as(ProdutoResponse.class)
                ;
        return produtoResponse.get_id();
    }


    public static Produto produtoPorId(String idProduto){
        Produto produto = produtoClient.listarProdutoPorId(idProduto)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract()
                        .as(Produto.class)
                ;
        return produto;

    }

    public static Produto produtoComDadosAtualizados(String idProduto){
        Produto produtoAtualizado = produtoPorId(idProduto);
        produtoAtualizado.setNome(faker.commerce().productName());
        produtoAtualizado.setDescricao(faker.commerce().department());

        return produtoAtualizado;
    }

    private static Produto novoProduto(){
        Produto novoProduto = new Produto();
        novoProduto.setNome(faker.commerce().productName());
        novoProduto.setPreco(faker.number().numberBetween(10, 800));
        novoProduto.setDescricao(faker.commerce().department());
        novoProduto.setQuantidade(faker.number().randomDigitNotZero());

        return novoProduto;
    }

}
