package model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor extends Pessoa{
	private String cnpj;
    private int prazoEntregaDias;
    private List<Produto> produtosFornecidos;
    
	public Fornecedor() {
	}

	public Fornecedor(String id, String nome, String email, String cnpj, int prazoEntregaDias) {
		super(id, nome, email);
		this.cnpj = cnpj;
		this.prazoEntregaDias = prazoEntregaDias;
		this.produtosFornecidos = new ArrayList<>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getPrazoEntregaDias() {
		return prazoEntregaDias;
	}

	public void setPrazoEntregaDias(int prazoEntregaDias) {
		this.prazoEntregaDias = prazoEntregaDias;
	}

	public List<Produto> getProdutosFornecidos() {
		return produtosFornecidos;
	}

	public void adicionarProdutoFornecido(Produto produto) {
		this.produtosFornecidos.add(produto);
	}
	
	public void removerProdutoFornecido(Produto produto) {
		this.produtosFornecidos.remove(produto);
	}
	
	@Override
	public String getPapel() {
		return "Fornecedor: " + super.getNome() + " (CNPJ: " + getCnpj() + ")" + "\nE-mail: " + super.getEmail();
	}
}
