package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ListarContaPage extends WebBasePage {
	private WebDriver driver;
	@FindBy(id = "tabelaContas")
	private WebElement tabelaContas;
	@FindBy(id = "nome")
	private WebElement inputNome;
	@FindBy(xpath = "//button[text()='Salvar']")
	private WebElement btnSalvar;

	public ListarContaPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public ListarContaPage tabelaContasEstaVisivel() {
		tabelaContas.isDisplayed();
		return this;
	}
		
	public EditarContaPage clicarBtnEditar(String nomeConta) {
		WebElement btnEditar = driver.findElement(
		        By.xpath("//tr[td/text()='" + nomeConta + "']//a[contains(@href,'editarConta')]")
		    );
	    btnEditar.click();
	    return new EditarContaPage(this.driver);
	}
	
	public RemoverContaPage clicarBtnRemover(String nomeConta) {
		WebElement btnRemover = driver.findElement(
		        By.xpath("//tr[td/text()='" + nomeConta + "']//a[contains(@href,'removerConta')]")
		    );
		btnRemover.click();
	    return new RemoverContaPage(this.driver);
	}
		
	public SalvarContaPage editarConta(String antigo, String novo) {
		return tabelaContasEstaVisivel()
		.clicarBtnEditar(antigo)
		.preencherNome(novo)
		.clicarBtnSalvar();
	}
	
	public RemoverContaPage removerConta(String nomeConta) {
		return  tabelaContasEstaVisivel()
				.clicarBtnRemover(nomeConta);
	}
}
