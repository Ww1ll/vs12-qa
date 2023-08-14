package task03;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.ProdutoPojo;

import static io.restassured.RestAssured.*;

public class ServeRestTest {

    private String token;

    @BeforeEach
    public void setupToken(){

        baseURI = "http://localhost:3000/";

        this.token =
                given()
                        .contentType(ContentType.JSON)
                        .body("{\"email\": \"fulano@qa.com\",  \"password\": \"teste\"}")
                .when()
                    .post("/login")
                .then()
                    .extract().response().jsonPath().getString("authorization");
                ;
    }



    @Test
    public void testBuscarProdutoPorIdComSucesso(){
        String idProduto = "BeeJh5lz3k6kSIzA";

        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("idProduto", idProduto)
        .when()
                .get("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    public void testBuscarProdutoPorIdInvalido(){
        String idProduto = "-59n";

        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("idProduto", idProduto)
        .when()
                .get("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void testBuscarProdutoPorIdVazio(){
        String idProduto = " ";

        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("idProduto", idProduto)
        .when()
                .get("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void testBuscarProdutoComSucesso(){

        given()
                .log().all()
                .header("Authorization", this.token)
        .when()
                .get("/produtos")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    public void testBuscarProdutoComIdJaExcluido(){
        String idProduto = "4shF5p0YzRe0MRGE";;


        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("idProduto", idProduto)
        .when()
                .get("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void testBuscarProdutoComNomeInvalido(){

        ProdutoPojo produto = new ProdutoPojo();

        produto.setNome("");


        given()
                .log().all()
                .header("Authorization", this.token)
                .queryParam("produto", produto.getNome())
        .when()
                .get("/produtos/")
        .then()
                .log().all()
                .statusCode(400)
        ;
    }




    @Test
    public void testCadastrarProdutoComSucesso(){

        ProdutoPojo produto = new ProdutoPojo();
        produto.setNome("Copo NFL");
        produto.setPreco(47);
        produto.setDescricao("Copo New Yor Giants");
        produto.setQuantidade(10);


        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produto)
        .when()
                .post("/produtos")
        .then()
                .statusCode(201)
        ;
    }

    @Test
    public void testCadastrarProdutoInvalidoComNomeVazio(){
        ProdutoPojo produto = new ProdutoPojo();
        produto.setNome("");
        produto.setPreco(50);
        produto.setDescricao("Copo Dallas Cowboys");
        produto.setQuantidade(12);


        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produto)
        .when()
                .post("/produtos")
        .then()
                .statusCode(400)
        ;
    }

    @Test
    public void testCadstrarProdutoInvalidoComNomeJaExistente(){
        ProdutoPojo produto = new ProdutoPojo();
        produto.setNome("Copo NFL");
        produto.setPreco(47);
        produto.setDescricao("Copo New Yor Giants");
        produto.setQuantidade(10);

        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produto)
        .when()
                .post("/produtos")
        .then()
                .statusCode(400)
        ;
    }


    @Test
    public void testEditarProdutoPorIdComSucesso(){
        String idProduto = "3lbkbpgkgTYDoKru";

        ProdutoPojo produto = new ProdutoPojo();
        produto.setNome("Copo NFL NYG");
        produto.setPreco(47);
        produto.setDescricao("Copo New Yor Giants");
        produto.setQuantidade(10);

        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produto)
                .pathParam("idProduto", idProduto)
        .when()
                .put("/produtos/{idProduto}")
        .then()
                .statusCode(200)
        ;
    }


    @Test
    public void testEditarProdutoPorIdComNomeExistente(){
        String idProduto = "2sHQLTOVmDWe1spG";

        ProdutoPojo produto = new ProdutoPojo();
        produto.setNome("Videocasset");
        produto.setPreco(1246);
        produto.setDescricao("Periferico");
        produto.setQuantidade(10);

        given()
                .log().all()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produto)
                .pathParam("idProduto", idProduto)
        .when()
                .put("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void testEditarProdutoPorIdInexistente(){
        String idProduto = "-69a";

        ProdutoPojo produto = new ProdutoPojo();
        produto.setNome("Logitech Mouse novo");
        produto.setPreco(47);
        produto.setDescricao("Copo New Yor Giants");
        produto.setQuantidade(15);

        given()
                .log().all()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produto)
                .pathParam("idProduto", idProduto)
        .when()
                .put("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(400)
        ;
    }



    @Test
    public void testExcluirProdutoPorIdComSucesso(){
        String idProduto = "4shF5p0YzRe0MRGE";

        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("idProduto", idProduto)
        .when()
                .delete("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(200)
        ;

    }

    @Test
    public void testExcluirPorIdInexistente(){
        String idProduto = "-0";

        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("idProduto", idProduto)
        .when()
                .delete("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(200)
        ;

    }

    @Test
    public void testExcluirProdutoPorIdSemAutorizacao(){
        String idProduto = "9zxie2Kv16S7wvU2";

        given()
                .log().all()
                .pathParam("idProduto", idProduto)
        .when()
                .delete("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(401)
        ;
    }


}
