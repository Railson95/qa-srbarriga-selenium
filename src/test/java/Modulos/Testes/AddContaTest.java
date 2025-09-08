package Modulos.Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modulos.Base.BaseTest;
import Modulos.Base.TestData;

public class AddContaTest extends BaseTest{
	@Test
	public void realizarCadastroContaComSucesso() {
		menuPage.acessarPaginaAddConta();
		String msgSucesso = addContaPage.addConta(TestData.nomeConta1).obterMsgSucesso();
		assertEquals("Conta adicionada com sucesso!", msgSucesso);
	}
	
	@Test
	public void naoDeveRealizarCadastroContaExistente() {
		// Adiciona conta caso não exista
		menuPage.acessarPaginaAddConta();
		addContaPage.addConta(TestData.nomeConta2);
		// Tenta cadastrar com a conta já existente
		menuPage.acessarPaginaAddConta();
		String msgErro = addContaPage.addConta(TestData.nomeConta2).obterMsgErro();
		assertEquals("Já existe uma conta com esse nome!", msgErro);
	}
}
