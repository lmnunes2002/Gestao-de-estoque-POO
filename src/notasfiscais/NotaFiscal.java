package notasfiscais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.StatusNota;
import enums.StatusPagamento;
import enums.TipoMovimentacao;
import exceptions.NotaInvalidaException;
import exceptions.PagamentoRecusadoException;
import pagamento.FormaPagamento;
import pessoas.Pessoa;
import produtos.Produto;

public abstract class NotaFiscal {

    private String numero;
    private LocalDate dataEmissao;
    private StatusNota status;
    private List<ItemNota> itens;
    private StatusPagamento statusPagamento;
    private FormaPagamento formaPagamento;

    public NotaFiscal() {
        this.itens = new ArrayList<>();
        this.status = StatusNota.RASCUNHO;
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    public NotaFiscal(String numero) {
        this();
        this.numero = numero;
    }

    public NotaFiscal(String numero, LocalDate dataEmissao, StatusNota status,
                      List<ItemNota> itens, StatusPagamento statusPagamento) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.status = status;
        this.itens = itens;
        this.statusPagamento = statusPagamento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public StatusNota getStatus() {
        return status;
    }

    public void setStatus(StatusNota status) {
        this.status = status;
    }

    public List<ItemNota> getItens() {
        return itens;
    }

    public void setItens(List<ItemNota> itens) {
        this.itens = itens;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void adicionarItem(Produto p, Integer qtd, Double preco) {
        if (status != StatusNota.RASCUNHO) {
            throw new NotaInvalidaException("Só é possível adicionar itens em nota em rascunho");
        }
        if (p == null) {
            throw new NotaInvalidaException("Produto não informado");
        }
        if (qtd == null || qtd <= 0) {
            throw new NotaInvalidaException("Quantidade deve ser maior que zero");
        }
        if (preco == null || preco < 0) {
            throw new NotaInvalidaException("Preço inválido");
        }
        itens.add(new ItemNota(p, qtd, preco));
    }

    public Double calcularTotal() {
        double total = 0;
        for (ItemNota item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void emitir() {
        if (status != StatusNota.RASCUNHO) {
            throw new NotaInvalidaException("Apenas notas em rascunho podem ser emitidas");
        }
        if (itens.isEmpty()) {
            throw new NotaInvalidaException("Nota sem itens não pode ser emitida");
        }
        this.status = StatusNota.EMITIDA;
        this.dataEmissao = LocalDate.now();
    }

    public void cancelar() {
        if (status == StatusNota.CANCELADA) {
            throw new NotaInvalidaException("Nota já está cancelada");
        }
        if (status == StatusNota.EMITIDA) {
            throw new NotaInvalidaException(
                    "Nota emitida já movimentou o estoque e não pode ser cancelada");
        }
        this.status = StatusNota.CANCELADA;
    }

    public void pagar(FormaPagamento forma) {
        if (status != StatusNota.EMITIDA) {
            throw new NotaInvalidaException("Apenas notas emitidas podem ser pagas");
        }
        if (statusPagamento == StatusPagamento.PAGO) {
            throw new NotaInvalidaException("Nota já está paga");
        }
        try {
            forma.pagar(calcularTotal());
            this.formaPagamento = forma;
            this.statusPagamento = StatusPagamento.PAGO;
        } catch (PagamentoRecusadoException e) {
            this.statusPagamento = StatusPagamento.RECUSADO;
            throw e;
        }
    }

    public abstract TipoMovimentacao getTipoMovimentacao();

    public abstract Pessoa getParceiro();
}
