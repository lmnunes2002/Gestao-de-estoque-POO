package notasfiscais;

import produtos.Produto;

public class ItemNota {

    private Produto produto;
    private Integer quantidade;
    private Double precoUnitario;

    public ItemNota() {
    }

    public ItemNota(Produto produto, Integer quantidade, Double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double calcularSubtotal() {
        return quantidade * precoUnitario;
    }
}
