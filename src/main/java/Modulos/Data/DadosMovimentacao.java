package Modulos.Data;

public class DadosMovimentacao {
	private String tipoMovimentacao;
    private String dataTransacao;
    private String dataPagamento;
    private String descricao;
    private String interessado;
    private String valor;
    private String conta;

    public DadosMovimentacao(String tipoMovimentacao, String dataTransacao, String dataPagamento,
                             String descricao, String interessado, String valor,
                             String conta) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataTransacao = dataTransacao;
        this.dataPagamento = dataPagamento;
        this.descricao = descricao;
        this.interessado = interessado;
        this.valor = valor;
        this.conta = conta;
    }
    
    // setters
    public void setDataTransacao(String data) {
    	this.dataTransacao = data;
    }

    // getters
    public String getTipoMovimentacao() { return tipoMovimentacao; }
    public String getDataTransacao() { return dataTransacao; }
    public String getDataPagamento() { return dataPagamento; }
    public String getDescricao() { return descricao; }
    public String getInteressado() { return interessado; }
    public String getValor() { return valor; }
    public String getConta() { return conta; }
}
