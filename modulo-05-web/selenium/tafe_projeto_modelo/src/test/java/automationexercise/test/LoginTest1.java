package automationexercise.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest1 {

    // 1 - Declarar as bibliotecas em variáveis
    public static WebDriver driver;
    public static WebDriverWait wait;


    public void deveRegistrarLoginComSucesso(){

        // 3 - Coloco o caminho do meu "ChromeDriver" em uma variável
        String caminhoDriver = "driver/chromedriver.exe";

        // 4 - Setar o recurso que vou utilizar passando o caminho do driver
        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        // 5 - instancio "ChromeDriver" na variável "driver"
        driver = new ChromeDriver();

        /* 6 - Instancio "WebDriverWait" na variável "wait",
        * passando o driver + um tempo de espera global */
        wait = new WebDriverWait(driver, 40);

        // 7 - Abrir o navegador
        driver.get("https://www.automationexercise.com/login");

        // 8 - Maximizar navegador
        driver.manage().window().maximize();

        // 1 - Esperar o campo carregar na tela
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"login-email\"]")));

        // 2 - Esperar o campo email
        driver.findElement(By.cssSelector("input[data-qa=\"login-email\"]")).sendKeys("vs@gmail.com");

        // 3 - Esperar o campo carregar na tela
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-qa=\"login-password\"]")));

        // 4 - Esperar o campo email
        driver.findElement(By.cssSelector("[data-qa=\"login-password\"]")).sendKeys("123456");

        // 5 - Esperar o botão login carregar na tela
        String btnLogin = "#form  div div div.col-sm-4.col-sm-offset-1 div  form > button";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnLogin)));

        // 6 - Clicar no botão login
        driver.findElement(By.cssSelector(btnLogin)).click();

        //




    }








}
