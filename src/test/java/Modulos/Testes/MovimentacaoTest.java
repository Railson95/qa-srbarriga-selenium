package Modulos.Testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Modulos.Base.BaseTest;
import Modulos.Data.DadosMovimentacao;
import Modulos.PageObjects.MenuPage;

public class MovimentacaoTest extends BaseTest{
	private DadosMovimentacao dados = new DadosMovimentacao(
	        "REC",
	        "25/08/2025",
	        "26/08/2025",
	        "Venda de celular",
	        "Pedro",
	        "2500",
	        "Conta Corrente"
	    );
	private String mesRemover = "Agosto";
	private String anoRemover = "2025";
	private String msgRemover = "Venda de celular";
	private int posSelectParaRemover = 0;
	
	@Test
	public void inserirMovimentacaoComSucesso() {
		menuPage.clicarLinkCriarMovimentacao();
		String msgSucesso = movimentacaoPage.inserirMovimentacaoPorIndice(posSelectParaRemover, dados).obterMsgSucesso();
		assertEquals("Movimentação adicionada com sucesso!", msgSucesso);
	}
	
	@Test
	public void verificarCamposObrigatoriosMovimentacao() {
		List<String> esperadas = Arrays.asList(
			    "Data da Movimentação é obrigatório",
			    "Data do pagamento é obrigatório",
			    "Descrição é obrigatório",
			    "Interessado é obrigatório",
			    "Valor é obrigatório",
			    "Valor deve ser um número"
			);
		
		List<String> msgsErro = new MenuPage(driver)
				.clicarLinkCriarMovimentacao()
				.formMovimentacaoEstaVisivel()
				.clicarBtnSalvar()
				.obterMsgsErro();
		assertEquals(esperadas, msgsErro);
	}
	
	@Test
	public void dataMovimentacaoDeveSerMenorOuIgualDataPagamento() {
		dados.setDataTransacao("25/08/2030");
		menuPage.clicarLinkCriarMovimentacao();
		String msgErro = movimentacaoPage.inserirMovimentacaoPorIndice(posSelectParaRemover, dados).obterMsgErro();
		assertEquals("Data da Movimentação deve ser menor ou igual à data atual", msgErro);
	}
	
	@Test
	public void deveRemoverMovimentacaoComSucesso() {
		// insere movimentacao para ser removida
		menuPage.clicarLinkCriarMovimentacao();
		movimentacaoPage.inserirMovimentacaoPorIndice(posSelectParaRemover, dados);
		
		// remove movimentacao
		menuPage.clicarLinkResumoMensal();
		String msgSucesso = extratoPage.removerMovimentacao(mesRemover, anoRemover, msgRemover).obterMsgSucesso();
		assertEquals("Movimentação removida com sucesso!", msgSucesso);
	}
}
