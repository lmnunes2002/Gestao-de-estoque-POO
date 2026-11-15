package model;

import java.time.LocalDateTime;

import enums.TipoMovimentacao;

public class MovimentacaoEstoque {
	private LocalDateTime data;
	private Integer quantidade;
	private TipoMovimentacao tipo;
	private Produto produto;
	private Funcionario responsavel;

	public MovimentacaoEstoque() {
	}

	public MovimentacaoEstoque(LocalDateTime data, Integer quantidade, TipoMovimentacao tipo, Produto produto,
			Funcionario responsavel) {
		this.data = data;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.produto = produto;
		this.responsavel = responsavel;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

}
