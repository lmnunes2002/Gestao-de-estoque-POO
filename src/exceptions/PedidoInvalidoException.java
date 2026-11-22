package exceptions;

public class PedidoInvalidoException extends EstoqueException{
	String motivo;
	
	public PedidoInvalidoException(String motivo) {
		super("Pedido inválido: " + motivo);
	}
	
	public String motivo() {
		return motivo;
	}
}
