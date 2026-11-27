package notasfiscais;

import java.time.LocalDateTime;

import enums.TipoMovimentacao;
import produtos.Produto;

public class MovimentacaoEstoque {

    private LocalDateTime data;
    private Integer quantidade;
    private TipoMovimentacao tipo;
    private Produto produto;
    private NotaFiscal notaOrigem;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(Produto produto, Integer quantidade,
                               TipoMovimentacao tipo, NotaFiscal notaOrigem) {
        this.data = LocalDateTime.now();
        this.produto = produto;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.notaOrigem = notaOrigem;
    }

    public MovimentacaoEstoque(LocalDateTime data, Integer quantidade, TipoMovimentacao tipo,
                               Produto produto, NotaFiscal notaOrigem) {
        this.data = data;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.produto = produto;
        this.notaOrigem = notaOrigem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NotaFiscal getNotaOrigem() {
        return notaOrigem;
    }

    public void setNotaOrigem(NotaFiscal notaOrigem) {
        this.notaOrigem = notaOrigem;
    }
}
