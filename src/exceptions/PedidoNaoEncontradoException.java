package exceptions;

public class PedidoNaoEncontradoException extends EstoqueException{
	String numero;
	
	public PedidoNaoEncontradoException(String numero) {
		super("Pedido do numero " + numero + "não encontrado.");
	}
	
	public String numero() {
		return numero;
	}
}
