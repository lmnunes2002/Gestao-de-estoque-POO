package model;

import enums.StatusProduto;
import enums.UnidadeMedida;
import exceptions.EstoqueInsuficienteException;

public abstract class Produto {
	private String id;
	private String nome;
	private Double preco;
	private Integer quantidade;
	private Integer estoqueMinimo;
	private UnidadeMedida unidade;
	private StatusProduto status;

	private Localizacao localizacao;

	public Produto() {
	}

	public Produto(String id, String nome, Double preco, Integer quantidade, Integer estoqueMinimo,
			UnidadeMedida unidade, StatusProduto status, String corredor, String prateleira) {

		if (preco <= 0 || quantidade < 0 || estoqueMinimo < 0) {
			throw new IllegalArgumentException("Os valores númericos do produto não estão corretos.");
		}

		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.estoqueMinimo = estoqueMinimo;
		this.unidade = unidade;
		this.status = status;
		this.localizacao = new Localizacao(corredor, prateleira);
		atualizarStatus();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public UnidadeMedida getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeMedida unidade) {
		this.unidade = unidade;
	}

	public StatusProduto getStatus() {
		return status;
	}

	public void setStatus(StatusProduto status) {
		this.status = status;
	}

	public abstract String getDescricao();

	public double calcularValorTotal() {
		return this.quantidade * this.preco;
	}

	public void adicionarQuantidade(int quantidade) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("Adicione uma quantidade válida do produto.");
		}

		this.quantidade += quantidade;
		atualizarStatus();
	}

	public void removerQuantidade(int quantidade) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("Remova uma quantidade válida do produto");
		}

		if (quantidade > this.quantidade) {
			throw new EstoqueInsuficienteException(this.quantidade, quantidade);
		}

		this.quantidade -= quantidade;
		atualizarStatus();
	}
	
	public Localizacao getLocalizacao() {
        return localizacao;
    }

	private void atualizarStatus() {
		if (this.quantidade == 0) {
			this.status = StatusProduto.ESGOTADO;
		} else if (this.quantidade <= this.estoqueMinimo) {
			this.status = StatusProduto.ESTOQUE_BAIXO;
		} else {
			this.status = StatusProduto.DISPONIVEL;
		}
	}
}
