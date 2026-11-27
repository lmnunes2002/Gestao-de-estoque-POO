package pagamento;

import exceptions.PagamentoRecusadoException;

public class PagamentoCartao implements FormaPagamento {

    private String bandeira;
    private Integer parcelas;

    public PagamentoCartao() {
    }

    public PagamentoCartao(String bandeira, Integer parcelas) {
        this.bandeira = bandeira;
        this.parcelas = parcelas;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Double calcularParcela(Double valor) {
        if (parcelas == null || parcelas <= 0) {
            return valor;
        }
        return valor / parcelas;
    }

    @Override
    public void pagar(Double valor) {
        if (bandeira == null || bandeira.trim().isEmpty()) {
            throw new PagamentoRecusadoException("Bandeira do cartão não informada");
        }
        if (parcelas == null || parcelas <= 0) {
            throw new PagamentoRecusadoException("Número de parcelas inválido");
        }
        if (valor == null || valor <= 0) {
            throw new PagamentoRecusadoException("Valor inválido para pagamento");
        }
        System.out.println("Cartão " + bandeira + " aprovado: " + parcelas + "x de R$ "
                + String.format("%.2f", calcularParcela(valor)));
    }

    @Override
    public String getDescricao() {
        return "Cartão " + bandeira + " em " + parcelas + "x";
    }
}
