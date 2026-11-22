package pessoas;

import java.util.ArrayList;
import java.util.List;

import pedidos.Pedido;

public class Cliente {
	private String cpf;
	
	private List<Pedido> pedidos = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(String cpf, List<Pedido> pedidos) {
		this.cpf = cpf;
		this.pedidos = pedidos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
}
