package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditarContaPage extends WebBasePage {

	private WebDriver driver;
	@FindBy(id = "tabelaContas")
	private WebElement tabelaContas;
	@FindBy(id = "nome")
	private WebElement inputNome;
	@FindBy(xpath = "//button[text()='Salvar']")
	private WebElement btnSalvar;

	public EditarContaPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public EditarContaPage preencherNome(String nome) {
		inputNome.clear();
		inputNome.sendKeys(nome);
		return this;
	}
	
	public SalvarContaPage clicarBtnSalvar() {
		btnSalvar.click();
		return new SalvarContaPage(this.driver);
	}
}
