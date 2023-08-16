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

        String email = System.getenv("EMAIL");
        String password = System.getenv("PASSWORD");

        this.token =
                given()
                        .contentType(ContentType.JSON)
                        .body("{\"email\": \"" + email + "\",  \"password\": \"" + password + "\"}")
                .when()
                        .post("/login")
                .then()
                        .extract().response().jsonPath().getString("authorization")
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
                .body("produtos.nome", hasItems("Playstation 5"))
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

        ProdutoPojo produtoCadastrado = new ProdutoPojo();
        produtoCadastrado.setNome("Copo MLB500");
        produtoCadastrado.setPreco(58);
        produtoCadastrado.setDescricao("Copo Pittsburghw");
        produtoCadastrado.setQuantidade(12);


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


//////////////////////////////////////////voltar aqui pra baixo
    @Test
    public void testCadastrarProdutoInvalidoComNomeVazio(){
        ProdutoPojo produtoCadastradoInvalido = new ProdutoPojo();
        produtoCadastradoInvalido.setNome("");
        produtoCadastradoInvalido.setPreco(50);
        produtoCadastradoInvalido.setDescricao("Copo Dallas Cowboys");
        produtoCadastradoInvalido.setQuantidade(12);


        String id =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoCadastradoInvalido)
                .when()
                        .post("/produtos")
                .then()
                        .log().all()
                        .statusCode(400)
                        .body("message", equalTo(null))
                        .extract().jsonPath().get("_id").toString()
                ;

        ProdutoPojo produtoResultado =
        given()
                .log().all()
                .header("Authorization", this.token)
                .pathParam("_id", id)
        .when()
                .get("/produtos/{_id}")
        .then()
                .statusCode(400)
                .assertThat()
                .extract()
                    .as(ProdutoPojo.class)
        ;

        Assertions.assertNull(produtoResultado.getNome());


    }


    @Test
    public void testCadastrarProdutoInvalidoComNomeJaExistente(){

        ProdutoPojo produtoCadastrado = new ProdutoPojo();
        produtoCadastrado.setNome("Copo MLB500");
        produtoCadastrado.setPreco(58);
        produtoCadastrado.setDescricao("Copo Pittsburghw");
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
                        .body("message", equalTo("Já existe produto com esse nome"))
                        .extract().jsonPath().get("nome")
                ;


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

        String idProduto = "6QDbS2TIM9viRF16";

        ProdutoPojo produtoEditado = new ProdutoPojo();
        produtoEditado.setNome("Novo Copo NHLS");
        produtoEditado.setPreco(47);
        produtoEditado.setDescricao("Novo copo");
        produtoEditado.setQuantidade(10);

        String id =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoEditado)
                .when()
                        .put("/produtos/{_id}", idProduto)
                .then()
                        .log().all()
                        .statusCode(200)
                        .body("message", equalTo("Registro alterado com sucesso"))
                        .extract().jsonPath().get("_id").toString()
                ;


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


        Assertions.assertEquals(produtoEditado.getNome(), produtoResultado.getNome());


    }


    @Test
    public void testEditarProdutoPorIdComNomeExistente(){
        String idProduto = "BeeJh5lz3k6kSIzA";

        ProdutoPojo produtoEditado = new ProdutoPojo();
        produtoEditado.setNome("Logitech MX Vertical");
        produtoEditado.setPreco(238);
        produtoEditado.setDescricao("Gamer");
        produtoEditado.setQuantidade(197);

        String id =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoEditado)
                .when()
                        .put("/produtos/{_id}", idProduto)
                .then()
                        .log().all()
                        .statusCode(400)
                        .body("message", equalTo("Já existe produto com esse nome"))
                        .extract().jsonPath().get("_id").toString()
                ;


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

        Assertions.assertEquals(produtoEditado.getNome(), produtoResultado.getNome());
    }

    @Test
    public void testEditarProdutoPorIdInexistente(){
        String idProduto = "-69a";

        ProdutoPojo produtoEditado = new ProdutoPojo();
        produtoEditado.setNome("Logitech Mouse novo");
        produtoEditado.setPreco(47);
        produtoEditado.setDescricao("Copo New Yor Giants");
        produtoEditado.setQuantidade(15);


        String id =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .pathParam("_id", idProduto )
                        .body(produtoEditado)
                .when()
                        .put("/produtos/{_id}")
                .then()
                        .log().all()
                        .statusCode(400)
                        .body("message", equalTo("Já existe produto com esse nome"))
                        .extract().jsonPath().get("_id").toString()

                ;


        ProdutoPojo produtoResultado =
                given()
                        .log().all()
                        .header("Authorization", this.token)
                        .pathParam("_id", id)
                .when()
                        .get("/produtos/{_id}")
                .then()
                        .log().all()
                        .statusCode(400)
                        .assertThat()
                        .extract()
                            .as(ProdutoPojo.class)
                ;

        Assertions.assertEquals(produtoEditado.getNome(), produtoResultado.getNome());

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
