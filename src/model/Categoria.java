package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private String nome;

	private List<Produto> produtos;

	public Categoria() {
	}

	public Categoria(String nome) {
		this.nome = nome;
		this.produtos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setParcelas(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public void removerProduto(Produto produto) {
		this.produtos.remove(produto);
	}
}
