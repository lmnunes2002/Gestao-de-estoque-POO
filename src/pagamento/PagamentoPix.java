package pagamento;

import exceptions.PagamentoRecusadoException;

public class PagamentoPix implements FormaPagamento {

    private String chave;

    public PagamentoPix() {
    }

    public PagamentoPix(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @Override
    public void pagar(Double valor) {
        if (chave == null || chave.trim().isEmpty()) {
            throw new PagamentoRecusadoException("Chave Pix não informada");
        }
        if (valor == null || valor <= 0) {
            throw new PagamentoRecusadoException("Valor inválido para pagamento");
        }
        System.out.println("Pix aprovado: R$ " + String.format("%.2f", valor));
    }

    @Override
    public String getDescricao() {
        return "Pix (chave: " + chave + ")";
    }
}
