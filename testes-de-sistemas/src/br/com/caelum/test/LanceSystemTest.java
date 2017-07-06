package br.com.caelum.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanceSystemTest {
	
	private FirefoxDriver driver;
	private LeiloesPage leiloes;
	private DetalhesLeilaoPage lances;
	private CriadorDeCenarios criacenarios;
	
	@Before
	public void inicializa() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nascimento\\Documents\\estudos\\selenium-study\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(new URLDaAplicacao().getUrlBase() + "/apenas-teste/limpa");
		leiloes = new LeiloesPage(driver);
		
		new CriadorDeCenarios(driver)
		.umUsuario("PauNoHenrique Sousa", "pnh@gmail.com")
		.umUsuario("Luan Oliveira", "lno@gmail.com")
		.umLeilao("Geladeira", "Luan Oliveira", 100, false);

		
	}
	@Test
	public void deveFazerUmLance() {
		DetalhesLeilaoPage lances = leiloes.detalhes(1);
		lances.lance("Luan Oliveira", 150);
		
	}
	
	@After
	public void destroi() {
		driver.close();
	}

}
