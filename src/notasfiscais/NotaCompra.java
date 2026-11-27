package notasfiscais;

import java.time.LocalDate;
import java.util.List;

import enums.StatusNota;
import enums.StatusPagamento;
import enums.TipoMovimentacao;
import pessoas.Fornecedor;
import pessoas.Pessoa;

public class NotaCompra extends NotaFiscal {

	private Fornecedor fornecedor;

	public NotaCompra() {
		super();
	}

	public NotaCompra(String numero, Fornecedor fornecedor) {
		super(numero);
		this.fornecedor = fornecedor;
	}

	public NotaCompra(String numero, LocalDate dataEmissao, StatusNota status, List<ItemNota> itens,
			StatusPagamento statusPagamento, Fornecedor fornecedor) {
		super(numero, dataEmissao, status, itens, statusPagamento);
		this.fornecedor = fornecedor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public TipoMovimentacao getTipoMovimentacao() {
		return TipoMovimentacao.ENTRADA;
	}

	@Override
	public Pessoa getParceiro() {
		return fornecedor;
	}
}
