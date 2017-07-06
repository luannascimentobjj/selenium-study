package br.com.caelum.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestNomeObrigatorio {

	
    @Test
    public void naoDeveAdicionarUmUsuarioSemNome() {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nascimento\\Documents\\estudos\\selenium-study\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/usuarios/new");

        WebElement email = driver.findElement(By.name("usuario.email"));

        email.sendKeys("");
		email.submit();
		assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));
        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));

        driver.close();

    }
}
