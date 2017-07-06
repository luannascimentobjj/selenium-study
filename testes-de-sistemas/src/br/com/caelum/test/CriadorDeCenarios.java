package br.com.caelum.test;
import org.openqa.selenium.WebDriver;

import br.com.caelum.test.LeiloesPage;
import br.com.caelum.test.UsuariosPage;

class CriadorDeCenarios {

    private WebDriver driver;

    public CriadorDeCenarios(WebDriver driver) {
        this.driver = driver;
    }

    public CriadorDeCenarios umUsuario(String nome, String email) {
        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra(nome, email);

        return this;
    }

    public CriadorDeCenarios umLeilao(String produto, 
                String valor, 
                double usuario, 
                boolean usado) {
        LeiloesPage leiloes = new LeiloesPage(driver);
        leiloes.visita();
        leiloes.novo().preenche(produto, usuario, valor, usado);

        return this;
    }

}