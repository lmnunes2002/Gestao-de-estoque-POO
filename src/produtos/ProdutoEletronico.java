package produtos;

public class ProdutoEletronico extends Produto implements Tributavel {
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
		return this.getPreco() * 0.15;
	}

	@Override
	public String getDescricao() {
		return "";
	}
}
