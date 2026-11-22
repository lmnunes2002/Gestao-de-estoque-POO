package pessoas;

import java.util.ArrayList;
import java.util.List;

import exceptions.PedidoInvalidoException;
import exceptions.PedidoNaoEncontradoException;
import pedidos.Pedido;
import produtos.Produto;

public class Cliente extends Pessoa {
	private String cpf;

	private List<Pedido> pedidos = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(String cpf) {
		this.cpf = cpf;
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

	public Pedido realizarPedido(Produto produto, int quantidade) {
		Pedido pedido = new Pedido("Pedido" + (pedidos.size() + 1));
		pedido.adicionarItem(produto, quantidade);
		pedidos.add(pedido);
		return pedido;
	}

	public Pedido verificarPedido(String numero) {
		for (Pedido pedido : pedidos) {
			if (pedido.getNumero().equals(numero)) {
				return pedido;
			}
		}

		throw new PedidoNaoEncontradoException("Número do pedido não encontrado.");
	}
	
	public List<Pedido> listarPedidos() {
		if(pedidos.size() > 0) {
			for(Pedido pedido: pedidos) {
				System.out.println(pedido);
			}	
		} else {
			throw new PedidoInvalidoException("Você não realizaou pedidos");
		}
		
		return pedidos;
	}
	
	public void atualizarPedido(String numero, Produto produto, int quantidade) {
		verificarPedido(numero).atualizarItem(produto, quantidade);
	}
	
	public void cancelarPedido(String numero) {
		verificarPedido(numero).cancelar();
	}

	@Override
	public String getDocumento() {
		return "Cliente: " + super.getNome() + "(CPF: " + this.getCpf() + ")" + "\nE-mail: " + super.getEmail();
	}
}
