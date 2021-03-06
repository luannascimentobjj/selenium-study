package br.com.caelum.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {

	private final WebDriver driver;
	
	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	};
	
	public void visita() {
		 driver.get(new URLDaAplicacao().getUrlBase() + "/usuarios");
	};
	
	public AlterarUsuarioPage altera(int posicao) {
		driver.findElements(By.linkText("editar")).get(posicao-1).click();
		return new AlterarUsuarioPage(driver);
	}
	
	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usu�rio")).click();
		return new NovoUsuarioPage(driver);
	};
	
	public boolean existeNaListagem(String nome, String email) {
		return driver.getPageSource().contains(nome) &&
				driver.getPageSource().contains(email);
	}

    public void deletaUsuarioNaPosicao(int posicao) {
        driver.findElements(By.tagName("button")).get(posicao-1).click();
        // pega o alert que est� aberto
        Alert alert = driver.switchTo().alert();
        // confirma
        alert.accept();
     }
}
