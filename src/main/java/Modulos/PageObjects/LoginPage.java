package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WebBasePage {

	private WebDriver driver;
	@FindBy (css = "form[action='/logar']")
	private WebElement formLogin;
	@FindBy(id = "email")
	private WebElement inputEmail;
	@FindBy(id = "senha")
	private WebElement inputSenha;
	@FindBy(xpath = "//button[text()='Entrar']")
	private WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public LoginPage formularioLoginEstaVisivel() {
		formLogin.isDisplayed();
		return this;
	}
	
	public LoginPage preencherEmail(String email) {
		inputEmail.sendKeys(email);
		return this;
	}
	
	public LoginPage preencherSenha(String senha) {
		inputSenha.sendKeys(senha);
		return this;
	}
	
	public MenuPage clicarBtnLogin() {
		btnLogin.click();
		return new MenuPage(this.driver);
	}

}
