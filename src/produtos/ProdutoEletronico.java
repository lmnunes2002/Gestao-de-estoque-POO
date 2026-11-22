package produtos;

public class ProdutoEletronico {
	private int garantiaMeses;

	public ProdutoEletronico() {
	}

	public ProdutoEletronico(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}

	public int getGarantiaMeses() {
		return garantiaMeses;
	}

	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}

	public double calcularImposto() {
		return 0.0;
	}
}
