package automationexercise.test;

import automationexercise.factory.seleniumfactory.SeleniumFactory;
import org.testng.annotations.*;

public class BaseTest {

    SeleniumFactory seleniumFactory = new SeleniumFactory();

    @BeforeMethod
    public void abrirNavegador(){
        seleniumFactory.initBrowser("https://www.automationexercise.com/login");
    }


    @AfterMethod
    public void fecharNavegador(){
        seleniumFactory.tearDown();
    }

}
