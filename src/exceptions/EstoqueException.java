package exceptions;

public class EstoqueException extends Exception {
	public EstoqueException(String mensagem) {
		super(mensagem);
	}
	
	@Override
    public String getMessage() {
        return super.getMessage();
    }
}
