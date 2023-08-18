package automationexercise.test;

import automationexercise.data.LoginDto;
import automationexercise.factory.data.LoginData;
import automationexercise.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    // Fluxo positivo - Cenário automatizado com execução de passo a passo
    @Test
    public void validarLoginDadosValidosTest1(){
        LoginDto usu =  loginData.loginDadosValidos();      // Criando a massa
        loginPage.preencherCampoEmail(usu.getEmail());      // Preenhce campo email
        loginPage.preencherCampoSenha(usu.getSenha());      // Preenhce campo senha
        loginPage.clicarBtnAcessar();                       // Clicar em botao
        String msgm = loginPage.validarTextoBtnAposLogin(); // Ler o texto no elemento
        Assert.assertEquals(msgm,"Logout");         // Validando os resultados
    }

    // Fluxo positivo - Cenário automatizado com execução de passo a passo
    @Test
    public void validarLoginDadosInvalidosTest2(){
        LoginDto usu =  loginData.LoginDadoDinamicos();     // Criando a massa
        loginPage.preencherCampoEmail(usu.getEmail());      // Preenhce campo email
        loginPage.preencherCampoSenha(usu.getSenha());      // Preenhce campo senha
        loginPage.clicarBtnAcessar();                       // Clicar em botao
        String msgm = loginPage.validarMsgmEmailIncorreto(); // Ler o texto no elemento
        Assert.assertEquals(msgm,"Your email or password is incorrect!"); // Validando o resultado
    }

    // Fluxo alternativo - Cenário automatizado com execução de fluxo
    @Test
    public void validarLoginComDadosValidosTest3(){

        LoginDto usu =  loginData.loginDadosValidos();                      // Criando a massa
        String msgm = loginPage.fazerLogin(usu.getEmail(),usu.getSenha());  // Executando fluxo
        Assert.assertEquals(msgm,"Logout");                         // Validando o resultado

    }

    // Fluxo alternativo - Cenário automatizado com execução de fluxo
    @Test
    public void validarLoginDadosInvalidosTest4(){

        LoginDto usu =  loginData.LoginDadoDinamicos();                              // Criando a massa
        String msgm = loginPage.loginEmailIncorreto(usu.getEmail(), usu.getSenha()); // Executando fluxo
        Assert.assertEquals(msgm,"Your email or password is incorrect!");    // Validando o resultado

    }

}
