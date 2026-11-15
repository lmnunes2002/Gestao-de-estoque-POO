package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.StatusPedido;
import exceptions.EstoqueException;

public class PedidoCompra {
	private String id;
	private LocalDate data;
	private StatusPedido status;
	private Fornecedor fornecedor;
	private Funcionario responsavel;
	private List<ItemPedido> itens;

	public PedidoCompra() {
	}

	public PedidoCompra(String id, Fornecedor fornecedor, Funcionario responsavel) {
		this.id = id;
		this.data = LocalDate.now();
		this.status = StatusPedido.PENDENTE;
		this.fornecedor = fornecedor;
		this.responsavel = responsavel;
		this.itens = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void adicionarItem(Produto produto, int quantidade) {
		if (this.status != StatusPedido.PENDENTE) {
			throw new EstoqueException("Só é possível adicionar itens em pedidos pendentes.");
		}
		this.itens.add(new ItemPedido(produto, quantidade, produto.getPreco()));
	}

	public double calcularTotal() {
		double soma = 0.0;
		for (ItemPedido item : itens) {
			soma += item.calcularSubtotal();
		}

		return soma;
	}
	
	public void receber() {
		if (this.status != StatusPedido.PENDENTE) {
			throw new EstoqueException("Apenas pedidos pendentes podem ser recebidos.");
		}
		if (this.itens.isEmpty()) {
			throw new EstoqueException("Não é possível receber um pedido sem itens.");
		}
		this.status = StatusPedido.RECEBIDO;
	}

	public void cancelar() {
		if (this.status == StatusPedido.RECEBIDO) {
			throw new EstoqueException("Não é possível cancelar um pedido já recebido.");
		}
		this.status = StatusPedido.CANCELADO;
	}
}
