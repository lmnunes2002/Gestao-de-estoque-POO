package pagamento;

import java.time.LocalDate;

import exceptions.PagamentoRecusadoException;

public class PagamentoBoleto implements FormaPagamento {

    private String codigoBarras;
    private LocalDate vencimento;

    public PagamentoBoleto() {
    }

    public PagamentoBoleto(String codigoBarras, LocalDate vencimento) {
        this.codigoBarras = codigoBarras;
        this.vencimento = vencimento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public Boolean estaVencido() {
        return vencimento != null && LocalDate.now().isAfter(vencimento);
    }

    @Override
    public void pagar(Double valor) {
        if (codigoBarras == null || codigoBarras.trim().isEmpty()) {
            throw new PagamentoRecusadoException("Código de barras não informado");
        }
        if (estaVencido()) {
            throw new PagamentoRecusadoException("Boleto vencido");
        }
        if (valor == null || valor <= 0) {
            throw new PagamentoRecusadoException("Valor inválido para pagamento");
        }
        System.out.println("Boleto pago: R$ " + String.format("%.2f", valor));
    }

    @Override
    public String getDescricao() {
        return "Boleto (vencimento: " + vencimento + ")";
    }
}
