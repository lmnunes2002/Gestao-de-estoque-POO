package notasfiscais;

import java.time.LocalDate;
import java.util.List;

import enums.StatusNota;
import enums.StatusPagamento;
import enums.TipoMovimentacao;
import pessoas.Cliente;
import pessoas.Pessoa;

public class NotaVenda extends NotaFiscal {

    private Cliente cliente;

    public NotaVenda() {
        super();
    }

    public NotaVenda(String numero, Cliente cliente) {
        super(numero);
        this.cliente = cliente;
    }

    public NotaVenda(String numero, LocalDate dataEmissao, StatusNota status,
                     List<ItemNota> itens, StatusPagamento statusPagamento, Cliente cliente) {
        super(numero, dataEmissao, status, itens, statusPagamento);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public TipoMovimentacao getTipoMovimentacao() {
        return TipoMovimentacao.SAIDA;
    }

    @Override
    public Pessoa getParceiro() {
        return cliente;
    }
}
