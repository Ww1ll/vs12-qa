package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Produto;
import utils.Auth;

import static io.restassured.RestAssured.*;

public class ProdutoClient extends BaseClient{

    private static String token = Auth.token();
    private static String PRODUTO = "/produtos";

    public ProdutoClient(){
        BaseClient.initConfig();
    }

    public Response cadastrarProduto(Produto produto) {
        return
                given()
                        .header("Authorization", token)
                        .contentType(ContentType.JSON)
                        .body(produto)
                .when()
                        .post(PRODUTO)
                ;
    }


    public Response atualizarProduto(String _id, Produto produto){
        return
                given()
                        .header("Authorization", token)
                        .contentType(ContentType.JSON)
                        .body(produto)
                        .pathParam("_id", _id)
                .when()
                        .put(PRODUTO + "/{_id}")
                ;
    }

    public Response excluirProduto(String _id){
        return
                given()
                        .header("Authorization", token)
                        .pathParam("_id", _id)
                .when()
                        .delete(PRODUTO + "/{_id}")
                ;
    }



    public Response excluirProdutoSemAutorizacao(String _id){
        return
                given()
                        .pathParam("_id", _id)
                .when()
                        .delete(PRODUTO + "/{_id}")
        ;
    }

    public Response listarProdutoPorId(String _id){
        return
                given()
                        .header("Authorization", token)
                        .pathParam("_id", _id)
                .when()
                        .get(PRODUTO + "/{_id}")
                ;

    }

    public Response listarProduto(String nome){
        return
                given()
                        .header("Authorization", token)
                        .queryParam("nome", nome)
                .when()
                        .get(PRODUTO)
                ;

    }

}
