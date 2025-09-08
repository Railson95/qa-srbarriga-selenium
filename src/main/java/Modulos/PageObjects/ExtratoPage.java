package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ExtratoPage extends WebBasePage {

	private WebDriver driver;
    @FindBy(id = "mes")
    private WebElement mes;
    @FindBy(id = "ano")
    private WebElement ano;
    @FindBy(xpath = "//input[@type='submit' and @value='Buscar']")
	private WebElement btnBuscar;

	public ExtratoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public ExtratoPage selecionarMes(String value) {
		Select combo = new Select(mes);
		combo.selectByVisibleText(value);
		return this;
	}
	
	public ExtratoPage selecionarAno(String value) {
		Select combo = new Select(ano);
		combo.selectByValue(value);
		return this;
	}
	
	public ExtratoPage clicarBtnBuscar() {
		btnBuscar.click();
		return this;
	}

	public RemoverMovimentacaoPage clicarBtnRemover(String descricao) {
	    WebElement remover = driver.findElement(
	        By.xpath("//table[@id='tabelaExtrato']//tr[td[contains(text(),'" + descricao + "')]]/td[last()]/a")
	    );
	    remover.click();
	    return new RemoverMovimentacaoPage(this.driver);
	}
	
	public RemoverMovimentacaoPage removerMovimentacao(String mes, String ano, String descricao) {
		return selecionarMes(mes)
				.selecionarAno(ano)
				.clicarBtnBuscar()
				.clicarBtnRemover(descricao);
	}
}
