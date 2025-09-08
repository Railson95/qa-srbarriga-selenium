package Modulos.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalvarMovimentacaoPage extends WebBasePage {
	@FindBy(css = "div.alert.alert-danger ul li")
    private List<WebElement> mensagensErro;

	public SalvarMovimentacaoPage(WebDriver driver) {
		super(driver);
	}
	
	public List<String> obterMsgsErro() {
		List<String> textos = new ArrayList<>();
	    for (WebElement e : mensagensErro) {
	        textos.add(e.getText());
	    }
	    return textos;
	}
	
}
