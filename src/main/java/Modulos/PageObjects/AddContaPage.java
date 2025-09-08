package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddContaPage extends WebBasePage {

	private WebDriver driver;
	@FindBy (css = "form[action='/salvarConta']")
	private WebElement formAddConta;
	@FindBy(id = "nome")
	private WebElement inputNome;
	@FindBy(xpath = "//button[text()='Salvar']")
	private WebElement btnSalvar;

	public AddContaPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public AddContaPage formularioAddContaEstaVisivel() {
		formAddConta.isDisplayed();
		return this;
	}
	
	public AddContaPage preencherNome(String nome) {
		inputNome.sendKeys(nome);
		return this;
	}
	
	public SalvarContaPage clicarBtnSalvar() {
		btnSalvar.click();
		return new SalvarContaPage(this.driver);
	}
	
	public SalvarContaPage addConta(String nome) {
		return preencherNome(nome).clicarBtnSalvar();
	}
	
}
