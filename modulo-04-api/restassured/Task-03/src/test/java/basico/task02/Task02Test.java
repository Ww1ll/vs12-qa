package basico.task02;

import basico.pojo.ProdutoPojo;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Task02Test {

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
                .assertThat()
                .body("_id", equalTo("BeeJh5lz3k6kSIzA"))
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
                .assertThat()
                .body("_id", not(hasItem("-59n")))
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
                .assertThat()
                .body("_id", not(hasItem(" ")))
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
                .assertThat()
                .body("descricao", equalTo("Gamer"))
        ;
    }

    @Test
    public void testBuscarProdutoComIdJaExcluido(){
        String idProduto = "4shF5p0YzRe0MRGE";


        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("idProduto", idProduto)
        .when()
                .get("/produtos/{idProduto}")
        .then()
                .log().all()
                .statusCode(400)
                .assertThat()
                .body("_id", not(hasItem("4shF5p0YzRe0MRGE")))
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
                .assertThat()
                .body("nome", not(hasItem("")))
        ;
    }



    @Test
    public void testCadastrarProdutoComSucesso(){

        // pre-request
        ProdutoPojo produtoCadastrado = new ProdutoPojo();
        produtoCadastrado.setNome("Copo MLB500");
        produtoCadastrado.setPreco(58);
        produtoCadastrado.setDescricao("Copo Pittsburghw");
        produtoCadastrado.setQuantidade(12);


        //request
        String id =
        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produtoCadastrado)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .extract().jsonPath().get("_id").toString()
        ;


        // test
        ProdutoPojo produtoResultado =
        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("_id", id)
        .when()
                .get("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .extract()
                    .as(ProdutoPojo.class)
        ;

        Assertions.assertEquals(produtoCadastrado.getNome(), produtoResultado.getNome());
    }



    @Test
    public void testCadastrarProdutoInvalidoComNomeVazio(){
        ProdutoPojo produtoCadastrado = new ProdutoPojo();
        produtoCadastrado.setNome("");
        produtoCadastrado.setPreco(50);
        produtoCadastrado.setDescricao("Copo Dallas Cowboys");
        produtoCadastrado.setQuantidade(12);


        String nome =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoCadastrado)
                .when()
                        .post("/produtos")
                .then()
                        .log().all()
                        .statusCode(400)
                        .body("message", equalTo("nome não pode ficar em branco"))
                        .extract().jsonPath().get("nome").toString()
                ;

        ProdutoPojo produtoResultado =
        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("nome", nome)
        .when()
                .get("/produtos/{_id}")
        .then()
                .statusCode(400)
                .assertThat()
                .extract()
                    .as(ProdutoPojo.class)
        ;

        Assertions.assertNull(null, produtoResultado.getNome());

    }


    @Test
    public void testCadastrarProdutoInvalidoComNomeJaExistente(){
        // pre-request
        ProdutoPojo produtoCadastrado = new ProdutoPojo();
        produtoCadastrado.setNome("Copo MLB500");
        produtoCadastrado.setPreco(58);
        produtoCadastrado.setDescricao("Copo Pittsburghw");
        produtoCadastrado.setQuantidade(12);


        //request
        String nome =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoCadastrado)
                .when()
                        .post("/produtos")
                .then()
                        .log().all()
                        .statusCode(400)
                        .body("message", equalTo("Já existe produto com esse nome"))
                        .extract().jsonPath().get("nome").toString()
                ;


        // test
        ProdutoPojo produtoResultado =
                given()
                        .log().all()
                        .header("Authorization", this.token)
                        .pathParam("nome", nome)
                .when()
                        .get("/produtos/")
                .then()
                        .log().all()
                        .statusCode(400)
                        .assertThat()
                        .extract()
                            .as(ProdutoPojo.class)
                ;

        Assertions.assertEquals(produtoCadastrado.getNome(), produtoResultado.getNome());
    }


    @Test
    public void testEditarProdutoPorIdComSucesso(){
        String idProduto = "3lbkbpgkgTYDoKru";

        ProdutoPojo produtoCadastrado = new ProdutoPojo();
        produtoCadastrado.setNome("Copo NFL NYG");
        produtoCadastrado.setPreco(47);
        produtoCadastrado.setDescricao("Copo New Yor Giants");
        produtoCadastrado.setQuantidade(10);

        //request
        String id =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoCadastrado)
                .when()
                        .put("/produtos")
                .then()
                        .log().all()
                        .statusCode(400)
                        .body("message", equalTo("Editar produto com sucesso"))
                        .extract().jsonPath().get("nome").toString()
                ;


        // test
        ProdutoPojo produtoResultado =
                given()
                        .log().all()
                        .header("Authorization", this.token)
                        .pathParam("_id", id)
                .when()
                        .get("/produtos/")
                .then()
                        .log().all()
                        .statusCode(400)
                        .assertThat()
                        .extract()
                            .as(ProdutoPojo.class)
                ;

        Assertions.assertEquals(produtoCadastrado.getNome(), produtoResultado.getNome());


    }


    @Test
    public void testEditarProdutoPorIdComNomeExistente(){
        String idProduto = "2sHQLTOVmDWe1spG";

        ProdutoPojo produtoCadastrado = new ProdutoPojo();
        produtoCadastrado.setNome("Videocasset");
        produtoCadastrado.setPreco(1246);
        produtoCadastrado.setDescricao("Periferico");
        produtoCadastrado.setQuantidade(10);

        //request
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoCadastrado)
                        .pathParam("_id", idProduto )
                .when()
                        .put("/produtos/{_id}")
                .then()
                        .log().all()
                        .statusCode(400)
                        .body("message", equalTo("Já existe produto com esse nome"))
                ;


        // test
        ProdutoPojo produtoResultado =
                given()
                        .log().all()
                        .header("Authorization", this.token)
                        .pathParam("_id", idProduto)
                .when()
                        .get("/produtos/")
                .then()
                        .log().all()
                        .statusCode(400)
                        .assertThat()
                        .extract()
                            .as(ProdutoPojo.class)
                ;

        Assertions.assertEquals(produtoCadastrado.getNome(), produtoResultado.getNome());
    }

    @Test
    public void testEditarProdutoPorIdInexistente(){
        String idProduto = "-69a";

        ProdutoPojo produtoCadastrado = new ProdutoPojo();
        produtoCadastrado.setNome("Logitech Mouse novo");
        produtoCadastrado.setPreco(47);
        produtoCadastrado.setDescricao("Copo New Yor Giants");
        produtoCadastrado.setQuantidade(15);

        //request
        String id =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoCadastrado)
                .when()
                        .put("/produtos")
                .then()
                        .log().all()
                        .statusCode(400)
                        .body("message", equalTo("Não foi possível editar produto"))
                        .extract().jsonPath().get("nome").toString()
                ;


        // test
        ProdutoPojo produtoResultado =
                given()
                        .log().all()
                        .header("Authorization", this.token)
                        .pathParam("_id", id)
                .when()
                        .get("/produtos/")
                .then()
                        .log().all()
                        .statusCode(400)
                        .assertThat()
                        .extract()
                            .as(ProdutoPojo.class)
                ;

        Assertions.assertEquals(produtoCadastrado.getNome(), produtoResultado.getNome());

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
                .assertThat()
                .body("content._id", not(hasItem("4shF5p0YzRe0MRGE")))
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
                .assertThat()
                .body("content._id", not(hasItem("-0")))
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
                .assertThat()
                .body("_id", equalTo(null))
        ;
    }

}
