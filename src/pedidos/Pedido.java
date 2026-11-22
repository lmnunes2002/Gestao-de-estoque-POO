package pedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.StatusPedido;
import exceptions.PedidoInvalidoException;
import produtos.Produto;

public class Pedido {
	private String numero;
	private LocalDate dataPedido;
	private StatusPedido status;

	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(String numero) {
		this.numero = numero;
		this.dataPedido = LocalDate.now();
		this.status = StatusPedido.PENDENTE;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void adicionarItem(Produto produto, int quantidade) {
		exigirPendente();
		itens.add(new ItemPedido(produto, quantidade, produto.getPreco()));
	}

	public void atualizarItem(Produto produto, int quantidade) {
		exigirPendente();
		for (ItemPedido item : itens) {
			if (item.getProduto().getId().equals(produto.getId())) {
				if (quantidade <= 0) {
					itens.remove(item);
				} else {
					item.setQuantidade(quantidade);
				}

				return;
			}
		}

		throw new PedidoInvalidoException("O produto não está no pedido.");
	}

	public double calcularTotal() {
		double total = 0;
		for (ItemPedido item : itens) {
			total += item.calcularSubtotal();
		}
		return total;
	}

	public void cancelar() {
		exigirPendente();
		this.status = StatusPedido.CANCELADO;
	}

	private void exigirPendente() {
		if (this.status != StatusPedido.PENDENTE) {
			throw new PedidoInvalidoException("Só pedidos pendentes podem ser alterados.");
		}
	}

	@Override
	public String toString() {
		int cont = 1;
		String texto = "Número do pedido:" + numero + "\nData do pedido: " + dataPedido + "\nStatus=" + status + "\nItens do pedido: ";
		
		for(ItemPedido item: itens) {
			texto += "-Item " + cont + ": " + item;
			cont++;
		}
		
		return texto;
	}

}