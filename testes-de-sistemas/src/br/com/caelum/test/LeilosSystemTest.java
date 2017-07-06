package br.com.caelum.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeilosSystemTest {
	
	private WebDriver driver;
	private LeilosPage leiloes;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nascimento\\Documents\\estudos\\selenium-study\\geckodriver.exe");
		driver = new FirefoxDriver();
		leiloes = new LeilosPage(driver);
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Luan Oliveira", "luan.oliveira@gmail.com");
	}
	
	@Test
	public void deveCadastrarUmLeilao() throws InterruptedException {
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Computador", 123, "Luan Oliveira", true);
		Thread.sleep(1000);
		assertTrue(leiloes.existe("Computador", 123, "Luan Oliveira", true));
	}
	
	@After
	public void destroi() {
		driver.close();
	}

}
