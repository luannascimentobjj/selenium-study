package br.com.caelum.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlterarUsuarioPage {

	private WebDriver driver;

	public AlterarUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public UsuariosPage para(String nome, String email) {
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));
		
		txtEmail.clear();
		txtNome.clear();
		
		txtEmail.sendKeys(email);
		txtNome.sendKeys(nome);
		
		txtEmail.submit();
		
		return new UsuariosPage(driver);
		
	}
	
	
}
