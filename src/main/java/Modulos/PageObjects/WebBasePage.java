package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class WebBasePage {
    protected WebDriver driver;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement msgSucesso;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	private WebElement msgErro;
    public WebBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    public String obterMsgSucesso () {
		return msgSucesso.getText();
	}

	public String obterMsgErro () {
		return msgErro.getText();
	}
}
