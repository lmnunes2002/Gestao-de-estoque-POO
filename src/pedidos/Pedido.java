package pedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.StatusPedido;

public class Pedido {
	private String numero;
	private LocalDate dataPedido;
	private StatusPedido status;
	
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(String numero, LocalDate dataPedido, StatusPedido status, List<ItemPedido> itens) {
		this.numero = numero;
		this.dataPedido = dataPedido;
		this.status = status;
		this.itens = itens;
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

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
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
	
}
