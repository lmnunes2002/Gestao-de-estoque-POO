package produtos;

import java.time.LocalDate;

public class ProdutoPerecivel {
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
		return 0.0;
	}
}
