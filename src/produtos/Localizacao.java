package produtos;

public class Localizacao {
	private String corredor;
	private String prateleira;

	public Localizacao() {
	}

	public Localizacao(String corredor, String prateleira) {
		this.corredor = corredor;
		this.prateleira = prateleira;
	}

	public String getCorredor() {
		return corredor;
	}

	public void setCorredor(String corredor) {
		this.corredor = corredor;
	}

	public String getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}

	@Override
	public String toString() {
		return "Corredor " + corredor + ", Prateleira " + prateleira;
	}

}
