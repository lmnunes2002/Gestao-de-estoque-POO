package exceptions;

public class EstoqueInsuficienteException extends EstoqueException{
	private int disponivel;
	private int solicitado;
	
	public EstoqueInsuficienteException(int disponivel, int solicitado) {
		super("Estoque insuficiente: disponível" + disponivel + ", solicitado: " + solicitado);
		this.disponivel = disponivel;
		this.solicitado = solicitado;
	}
	
	public int getDisponivel() {
		return disponivel;
	}
	
	public int getSolicitado() {
		return solicitado;
	}
}
