package tests.produto;

import client.ProdutoClient;
import dataFactory.ProdutoDataFactory;
import model.Produto;
import model.ProdutoAPI;
import model.ProdutoResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class ProdutoAPITest {
    private ProdutoClient produtoClient = new ProdutoClient();


    @Test
    public void testDeveListarProdutoPorIdComSucesso(){
        Produto produto = ProdutoDataFactory.produtoValido();

            String idProduto = produtoClient.cadastrarProduto(produto)
                     .then()
                        .statusCode(HttpStatus.SC_CREATED)
                                .extract().path("_id")
                    ;

            ProdutoAPI produtoResultado = produtoClient.listarProdutoPorId(idProduto)
                    .then()
                        .statusCode(HttpStatus.SC_OK)
                            .extract()
                                    .as(ProdutoAPI.class)
                    ;

            Assertions.assertAll("Asserções agrupadas de buscarPorID de Produto",
                        () -> Assertions.assertEquals(produto.getNome(), produtoResultado.getNome()),
                        () -> Assertions.assertEquals(produto.getDescricao(), produtoResultado.getDescricao())
                    );

            produtoClient.excluirProduto(produtoResultado.get_id())
                    .then()
                        .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void testDeveListarProdutoPorIdInvalido(){
        ProdutoAPI produtoAPI = ProdutoDataFactory.produtoComIdInvalido();

        ProdutoResponse produtoResultado = produtoClient.listarProdutoPorId(produtoAPI.get_id())
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract()
                        .as(ProdutoResponse.class)
                ;

        Assertions.assertAll("Asserções agrupadas de buscarPorIDInvalido de Produto",
                () -> Assertions.assertEquals(null, produtoResultado.get_id())
        );

    }

    @Test
    public void testDeveListarProdutoPorIdVazio(){
        ProdutoAPI produtoAPI = ProdutoDataFactory.produtoComIdVazio();

        ProdutoResponse produtoResultado = produtoClient.listarProdutoPorId(produtoAPI.get_id())
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract()
                        .as(ProdutoResponse.class)
                ;

        Assertions.assertAll("Asserções agrupadas de buscarPorIDVazio de Produto",
                () -> Assertions.assertEquals(null, produtoResultado.get_id())
        );

    }

    @Test
    public void testBuscarProdutoComSucesso(){
        Produto produto = ProdutoDataFactory.produtoValido();

        String nomeProduto = produtoClient.cadastrarProduto(produto)
                .then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .extract().path("nome")
                ;

        ProdutoAPI produtoResponse = produtoClient.listarProduto(nomeProduto)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .as(ProdutoAPI.class)
                ;

        ProdutoAPI produtoListaResultado = produtoResponse.getProdutos().get(0);


        produtoClient.excluirProduto(produtoListaResultado.get_id())
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void testBuscarProdutoComIdJaExcluido() {
        Produto produto = ProdutoDataFactory.produtoValido();

        String idProduto = produtoClient.cadastrarProduto(produto)
                .then()
                 .statusCode(HttpStatus.SC_CREATED)
                    .extract().path("_id");

        produtoClient.excluirProduto(idProduto)
                .then()
                 .statusCode(HttpStatus.SC_OK);


        ProdutoResponse produtoResultado = produtoClient.listarProdutoPorId(idProduto)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract()
                        .as(ProdutoResponse.class)
                ;

        Assertions.assertAll("Asserções agrupadas de buscarProduto",
                () -> Assertions.assertEquals(produto.get_id(), produtoResultado.get_id())
        );
    }


    @Test
    public void testBuscarProdutoComNomeInvalido(){
        ProdutoAPI produtoAPI = ProdutoDataFactory.produtoComNomeInvalido();


        ProdutoAPI produtoResultado = produtoClient.listarProduto(produtoAPI.getNome())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract()
                        .as(ProdutoAPI.class)
                ;

        Assertions.assertAll("Asserções agrupadas de buscarProdutoPorNomeInvalido",
                () -> Assertions.assertEquals(null, produtoResultado.getNome())
        );

    }



    @Test
    public void testDeveCadastrarProdutoComSucesso(){
        Produto produto = ProdutoDataFactory.produtoValido();


            String idProduto = produtoClient.cadastrarProduto(produto)
                    .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .extract().path("_id")

                    ;

            ProdutoAPI produtoResultado = produtoClient.listarProdutoPorId(idProduto)
                    .then()
                        .extract()
                                .as(ProdutoAPI.class)
                    ;



        Assertions.assertAll("Asserções agrupadas de Produto",
                () -> Assertions.assertEquals(produto.getNome(), produtoResultado.getNome()),
                () -> Assertions.assertEquals(produto.getDescricao(), produtoResultado.getDescricao())

                );


        produtoClient.excluirProduto(produtoResultado.get_id())
                .then()
                    .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testDeveCadastrarProdutoInvalidoComNomeVazio(){
        Produto produto = ProdutoDataFactory.produtoInvalido();

        String idProduto = produtoClient.cadastrarProduto(produto)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("_id")
                ;

    }


    @Test
    public void testDeveCadastrarProdutoInvalidoComNomeJaExistente(){
        Produto produtoValido = ProdutoDataFactory.produtoValido();
        Produto produtoExistente = ProdutoDataFactory.produtoComNomeExistente(produtoValido.getNome());

        String idProdutoValido = produtoClient.cadastrarProduto(produtoValido)
                .then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .extract().path("_id")
                ;

        String idProdutoExistente = produtoClient.cadastrarProduto(produtoExistente)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("_id")
                ;

        produtoClient.excluirProduto(idProdutoValido)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                ;


    }



    @Test
    public void testDeveAtualizarProdutoComSucesso(){
        String produtoResponse = ProdutoDataFactory.produtoCadastrado();
        Produto produto = ProdutoDataFactory.produtoComDadosAtualizados(produtoResponse);

        produtoClient.atualizarProduto(produtoResponse, produto)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                ;

    }

    @Test
    public void testAtualizarProdutoPorIdComNomeExistente(){
        Produto produtoValido = ProdutoDataFactory.produtoValido();
        Produto produtoExistente = ProdutoDataFactory.produtoComNomeExistente(produtoValido.getNome());

        produtoClient.atualizarProduto(produtoValido.getNome(), produtoExistente)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }


    @Test
    public void testAtualizarProdutoPorIdInexistente(){
        String produtoResponse = ProdutoDataFactory.produtoCadastrado();
        Produto produto = ProdutoDataFactory.produtoAtualizadoComIdInvalido();


        produtoClient.atualizarProduto(produtoResponse, produto)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;

    }

    @Test
    public void testeDeveDeletarProdutoComSucesso(){
        Produto produto = ProdutoDataFactory.produtoValido();

        String idProduto = produtoClient.cadastrarProduto(produto)
                .then()
                        .statusCode(HttpStatus.SC_CREATED)
                                .extract().path("_id")
                ;

        ProdutoAPI produtoResultado = produtoClient.listarProdutoPorId(idProduto)
                .then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                            .as(ProdutoAPI.class)
                ;

            Assertions.assertAll("Asserções agrupadas de deletarPorID de Produto",
                    () -> Assertions.assertEquals(produto.getNome(), produtoResultado.getNome()),
                    () -> Assertions.assertEquals(produto.getDescricao(), produtoResultado.getDescricao())
                    );


        produtoClient.excluirProduto(produtoResultado.get_id())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("_id", not(hasItem(idProduto)))
                ;

    }

    @Test
    public void testExcluirPorIdInexistente(){
        ProdutoAPI produtoAPI = ProdutoDataFactory.produtoComIdInvalido();

        produtoClient.excluirProduto(produtoAPI.get_id())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("_id", not(hasItem(produtoAPI.get_id())))
                ;


    }

    @Test
    public void testDeveDeletarProdutoPorIdSemAutorizacao(){

        Produto produto = ProdutoDataFactory.produtoValido();

        String idProduto = produtoClient.cadastrarProduto(produto)
                .then()
                    .statusCode(HttpStatus.SC_CREATED)
                        .extract().path("_id")
                ;


        produtoClient.excluirProdutoSemAutorizacao(idProduto)
                .then()
                    .statusCode(HttpStatus.SC_UNAUTHORIZED)
                ;

    }

}
