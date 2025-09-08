package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Modulos.Data.DadosMovimentacao;

public class MovimentacaoPage extends WebBasePage {

	private WebDriver driver;
	@FindBy (css = "form[action='/salvarMovimentacao']")
	private WebElement formMovimentacao;
	@FindBy (id = "tipo")
	private WebElement tipoMovimentacao;
	@FindBy(id = "data_transacao")
	private WebElement inputDataTransacao;
	@FindBy(id = "data_pagamento")
	private WebElement inputDataPagamento;
	@FindBy(id = "descricao")
	private WebElement inputDescricao;
	@FindBy(id = "interessado")
	private WebElement inputInteressado;
	@FindBy(id = "valor")
	private WebElement inputValor;
	@FindBy (id = "conta")
	private WebElement conta;
    @FindBy(id = "status_pago")
    private WebElement radioPago;
    @FindBy(id = "status_pendente")
    private WebElement radioPendente;
    @FindBy(xpath = "//button[text()='Salvar']")
	private WebElement btnSalvar;
	
	public MovimentacaoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public MovimentacaoPage formMovimentacaoEstaVisivel() {
		formMovimentacao.isDisplayed();
		return this;
	}
	
	public MovimentacaoPage selectTipoMovimentacao(String value) {
		Select combo = new Select(tipoMovimentacao);
		combo.selectByValue(value);
		return this;
	}
	
	public MovimentacaoPage preencherDataTransacao(String data) {
		inputDataTransacao.sendKeys(data);
		return this;
	}
	
	public MovimentacaoPage preencherDataPagamento(String data) {
		inputDataPagamento.sendKeys(data);
		return this;
	}
	
	public MovimentacaoPage preencherDescricao(String descricao) {
		inputDescricao.sendKeys(descricao);
		return this;
	}
	
	public MovimentacaoPage preencherInteressado(String interessado) {
		inputInteressado.sendKeys(interessado);
		return this;
	}
	
	public MovimentacaoPage preencherValor(String valor) {
		inputValor.sendKeys(valor);
		return this;
	}
	
	public MovimentacaoPage selectContaPorIndice(int indice) {
		Select combo = new Select(conta);
		combo.selectByIndex(indice);
		return this;
	}
	
	public MovimentacaoPage selectContaPorNome(String nome) {
		Select combo = new Select(conta);
		combo.selectByVisibleText(nome);
		return this;
	}
	
	public MovimentacaoPage selectRadioPago() {
		radioPago.click();
		return this;
	}
	
	public MovimentacaoPage selectRadioPendente() {
		radioPendente.click();
		return this;
	}

	public SalvarMovimentacaoPage clicarBtnSalvar() {
		btnSalvar.click();
		return new SalvarMovimentacaoPage(this.driver);
	}
	
	public MovimentacaoPage inserirMovimentacaoBase(DadosMovimentacao dados) {
		return  formMovimentacaoEstaVisivel()
				.selectTipoMovimentacao(dados.getTipoMovimentacao())
				.preencherDataTransacao(dados.getDataTransacao())
				.preencherDataPagamento(dados.getDataPagamento())
				.preencherDescricao(dados.getDescricao())
				.preencherInteressado(dados.getInteressado())
				.preencherValor(dados.getValor())
				.selectRadioPago();
	}
	
	public SalvarMovimentacaoPage inserirMovimentacaoPorNome(String nomeConta, DadosMovimentacao dados) {
        return inserirMovimentacaoBase(dados)
                .selectContaPorNome(nomeConta)
                .clicarBtnSalvar();
    }
	
	 public SalvarMovimentacaoPage inserirMovimentacaoPorIndice(int indiceConta, DadosMovimentacao dados) {
	        return inserirMovimentacaoBase(dados)
	                .selectContaPorIndice(indiceConta)
	                .clicarBtnSalvar();
	    }
}
