package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenuPage extends WebBasePage {

	private WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Contas')]")
	private WebElement menuContas;
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement home;
	@FindBy(xpath = "//a[text()='Adicionar']")
	private WebElement linkAdicionar;
	@FindBy(xpath = "//a[text()='Listar']")
	private WebElement linkListar;
	@FindBy(css = "a[href='/movimentacao']")
    private WebElement linkCriarMovimentacao;
	@FindBy(css = "a[href='/extrato']")
    private WebElement linkResumoMensal;

	public MenuPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public MenuPage clicarMenuConta() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(menuContas));
		menuContas.click();
		return this;
	}
	
	public HomePage clicarHome() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(home));
		home.click();
		return new HomePage(driver);
	}
	
	public AddContaPage clicarLinkAdicionar () {
		linkAdicionar.click();
		return new AddContaPage(this.driver);
	}
	
	public ListarContaPage clicarLinkListar () {
		linkListar.click();
		return new ListarContaPage(this.driver);
	}
	
	public MovimentacaoPage clicarLinkCriarMovimentacao() {
		linkCriarMovimentacao.click();
		return new MovimentacaoPage(this.driver);
	}
	
	public ExtratoPage clicarLinkResumoMensal() {
		linkResumoMensal.click();
		return new ExtratoPage(this.driver);
	}
	
	public AddContaPage acessarPaginaAddConta() {
		return clicarMenuConta().clicarLinkAdicionar();
		
	}
	
	public ListarContaPage acessarPaginaListarContas() {
		return clicarMenuConta().clicarLinkListar();
		
	}
					
}
