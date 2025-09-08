package Modulos.Testes;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Modulos.Base.BaseTest;
import Modulos.Base.TestData;
import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.LoginPage;

public class LoginTest extends BaseTest{
	@Before
	public void setUp(){
		driver = DriverFactory.getDriverFromString("firefox");
		driver.get("https://seubarriga.wcaquino.me/login");
	}
	
	@Test
	public void logarComSucesso() {
		String msgSucesso = new LoginPage(driver)
		.formularioLoginEstaVisivel()
		.preencherEmail(TestData.email)
		.preencherSenha(TestData.senha)
		.clicarBtnLogin()
		.obterMsgSucesso();
		
		assertTrue(msgSucesso.contains("Bem vindo"));
	}
}
