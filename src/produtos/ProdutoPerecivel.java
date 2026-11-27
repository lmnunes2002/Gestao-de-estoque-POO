package produtos;

import java.time.LocalDate;

public class ProdutoPerecivel extends Produto implements Tributavel{
	private LocalDate dataValidade;

	public ProdutoPerecivel() {
	}

	public ProdutoPerecivel(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public boolean estaVencido() {
		if (LocalDate.now().isAfter(dataValidade)) {
			return true;
		}

		return false;
	}

	public double calcularImposto() {
		return this.getPreco() * 0.05;
	}
	
	@Override
	public String getDescricao() {
		return "";
	}
}
