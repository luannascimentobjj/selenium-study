package br.com.caelum.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {

	private FirefoxDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Nascimento\\Documents\\estudos\\selenium-study\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void deveAdicionarUmUsuario() {

		driver.get("http://localhost:8080/usuarios/new");

		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		nome.sendKeys("Luan Nascimento Oliveira");
		email.sendKeys("nascimento.hate@gmail.com");

		// 1 opção
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();

		boolean achouNome = driver.getPageSource().contains("Luan Nascimento Oliveira");
		boolean achouEmail = driver.getPageSource().contains("nascimento.hate@gmail.com");

		assertTrue(achouNome);
		assertTrue(achouEmail);

	}

	@After
	public void finaliza() {
		driver.close();
	}
}
