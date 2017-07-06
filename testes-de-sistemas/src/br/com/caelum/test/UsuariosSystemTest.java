package br.com.caelum.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {

	private FirefoxDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nascimento\\Documents\\estudos\\selenium-study\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(new URLDaAplicacao().getUrlBase() + "/apenas-teste/limpa");
		this.usuarios = new UsuariosPage(driver);
		usuarios.visita();
	}
	@Test
	public void deveAlterarUmUsuario() throws InterruptedException {
		usuarios.novo().cadastra("Romilda Nascimento", "mildinha.nascimento@gmail.com");
		Thread.sleep(1000);
		usuarios.altera(1).para("Tania Sousa", "tanias.souza@gmail.com");
		Thread.sleep(1000);
		assertFalse(usuarios.existeNaListagem("Romilda Nascimento", "mildinha.nascimento@gmail.com"));
		Thread.sleep(1000);
		assertTrue(usuarios.existeNaListagem("Tania Sousa", "tanias.souza@gmail.com"));
	}
	
	@Test
	public void deveAdicionarUmUsuario() throws InterruptedException {
		
		usuarios.novo().cadastra("Luan Nascimento Oliveira", "nascimento.hate@gmail.com");
		Thread.sleep(1000);
		assertTrue(usuarios.existeNaListagem("Luan Nascimento Oliveira", "nascimento.hate@gmail.com"));
		
	}
	
	@Test
    public void deveDeletarUmUsuario() throws InterruptedException {

        usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
        Thread.sleep(1000);
        assertTrue(usuarios.existeNaListagem ("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
        usuarios.deletaUsuarioNaPosicao(1);
        Thread.sleep(1000);
        assertFalse(usuarios.existeNaListagem("Luan Nascimento Oliveira", "nascimento.hate@gmail.com"));
    }


	@After
	public void finaliza() {
		driver.close();
	}
}
