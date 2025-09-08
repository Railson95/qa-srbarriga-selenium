package Modulos.Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.AddContaPage;
import Modulos.PageObjects.ExtratoPage;
import Modulos.PageObjects.ListarContaPage;
import Modulos.PageObjects.LoginPage;
import Modulos.PageObjects.MenuPage;
import Modulos.PageObjects.MovimentacaoPage;

public class BaseTest {
	protected WebDriver driver;
	protected MenuPage menuPage;
	protected AddContaPage addContaPage;
	protected ListarContaPage listarContaPage;
	protected MovimentacaoPage movimentacaoPage;
	protected ExtratoPage extratoPage;

	static {
		// Executa apenas UMA vez durante toda a execução da suíte
		// Para deixar os testes independentes
		TestData.nomeConta1 = "Abacaxi_" + System.currentTimeMillis();
		TestData.nomeConta2 = "Morango_" + System.currentTimeMillis();
		TestData.nomeConta3 = "Pera_" + System.currentTimeMillis();
		TestData.nomeConta4 = "Uva_" + System.currentTimeMillis();
		TestData.nomeConta5 = "Maca_" + System.currentTimeMillis();
		TestData.email = "railson@railson";
		TestData.senha = "123";
	}

	@Before
	public void setUp() {
		this.driver = DriverFactory.getDriverFromString("firefox");
		this.driver.get("https://seubarriga.wcaquino.me/login");
		new LoginPage(driver).formularioLoginEstaVisivel().preencherEmail(TestData.email).preencherSenha(TestData.senha)
				.clicarBtnLogin();
		
		// Foi instanciado aqui para acessar os nomes corretos das contas
		// Add conta e depois remove a mesma conta, instância única para tudo (workaround - por não ter acesso ao banco e poder limpar os dados de teste)
		menuPage = new MenuPage(driver);
		addContaPage = new AddContaPage(driver);
	    listarContaPage = new ListarContaPage(driver);
	    movimentacaoPage = new MovimentacaoPage(driver);
	    extratoPage = new ExtratoPage(driver);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
