package exceptions;

public class PagamentoRecusadoException extends EstoqueException {

    private String motivo;

    public PagamentoRecusadoException() {
        super("Pagamento recusado");
    }

    public PagamentoRecusadoException(String motivo) {
        super("Pagamento recusado: " + motivo);
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}