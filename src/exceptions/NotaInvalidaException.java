package exceptions;

public class NotaInvalidaException extends EstoqueException{
	private String motivo;
	
	public NotaInvalidaException(String motivo) {
		super("Notá Inválida: " + motivo);
	}
	
	public String motivo() {
		return motivo;
	}
}
