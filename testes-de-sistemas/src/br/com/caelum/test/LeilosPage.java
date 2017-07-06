package br.com.caelum.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeilosPage {
	
	private WebDriver driver;

	public LeilosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
		driver.get("http://localhost:8080/leiloes");
	}

	public NovoLeilaoPage novo() {
		driver.findElement(By.linkText("Novo Leil�o")).click();
		return new NovoLeilaoPage(driver);
	}
	 
	public boolean existe(String produto, double valor, String usuario, boolean usado) {
		return driver.getPageSource().contains(produto) &&
				driver.getPageSource().contains(String.valueOf(valor)) &&
				driver.getPageSource().contains(usado ? "Sim" : "N�o");
	}
	
}
