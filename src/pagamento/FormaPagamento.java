package pagamento;

public interface FormaPagamento {

    void pagar(Double valor);

    String getDescricao();
}
