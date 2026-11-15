package exceptions;

public class ProdutoNaoEncontradoException extends EstoqueException{
	private String id;
	
	public ProdutoNaoEncontradoException(String id) {
		super("Produto não encontrado, id procurado: " + id);
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

}
