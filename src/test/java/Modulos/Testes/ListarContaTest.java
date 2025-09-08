package Modulos.Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modulos.Base.BaseTest;
import Modulos.Base.TestData;
import Modulos.Data.DadosMovimentacao;

public class ListarContaTest extends BaseTest{
	private DadosMovimentacao dados = new DadosMovimentacao(
	        "REC",
	        "25/08/2025",
	        "26/08/2025",
	        "Venda de celular",
	        "Pedro",
	        "2500",
	        "Conta Corrente"
	    );
	
	@Test
	public void realizarEdicaoContaComSucesso() {
		menuPage.acessarPaginaAddConta();
		addContaPage.addConta(TestData.nomeConta4);
		menuPage.acessarPaginaListarContas();
		String msgSucesso = listarContaPage.editarConta(TestData.nomeConta4, TestData.nomeConta3).obterMsgSucesso();
		assertEquals("Conta alterada com sucesso!", msgSucesso);
	}
	
	@Test
	public void deveNaoRemoverContaComMovimentacao() {
		menuPage.acessarPaginaAddConta();
		addContaPage.addConta(TestData.nomeConta5);
		menuPage.clicarLinkCriarMovimentacao();
		movimentacaoPage.inserirMovimentacaoPorNome(TestData.nomeConta5, dados);
		menuPage.acessarPaginaListarContas();
		String msgErro = listarContaPage.removerConta(TestData.nomeConta5).obterMsgErro();
		assertEquals("Conta em uso na movimentações", msgErro);
	}
	
}
