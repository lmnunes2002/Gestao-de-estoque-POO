package exceptions;

public class ProdutoNaoEncontradoException extends EstoqueException{
	private int id;
	
	public ProdutoNaoEncontradoException(int id) {
		super("Produto não encontrado, id procurado: " + id);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

}
