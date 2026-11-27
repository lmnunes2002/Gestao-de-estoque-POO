package relatorio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import produtos.Produto;
import service.Estoque;

public class RelatorioInventario implements Relatorio {

    private Estoque estoque;

    public RelatorioInventario() {
    }

    public RelatorioInventario(Estoque estoque) {
        this.estoque = estoque;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public String gerar() {
        if (estoque == null) {
            throw new IllegalStateException("Estoque não informado para o relatório");
        }

        String linha = "--------------------------------------------------------------------------------";
        StringBuilder sb = new StringBuilder();
        sb.append("RELATÓRIO DE INVENTÁRIO").append(System.lineSeparator());
        sb.append("Gerado em: ")
          .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
          .append(System.lineSeparator());
        sb.append(linha).append(System.lineSeparator());
        sb.append(String.format("%-8s %-24s %6s %-10s %12s %14s%n",
                "ID", "PRODUTO", "QTD", "UNIDADE", "PREÇO (R$)", "TOTAL (R$)"));
        sb.append(linha).append(System.lineSeparator());

        for (Produto p : estoque.getProdutos()) {
            sb.append(String.format("%-8s %-24s %6d %-10s %12.2f %14.2f%n",
                    p.getId(), p.getNome(), p.getQuantidade(), p.getUnidade(),
                    p.getPreco(), p.calcularValorTotal()));
        }

        sb.append(linha).append(System.lineSeparator());
        sb.append("Total de produtos: ").append(estoque.getProdutos().size())
          .append(System.lineSeparator());
        sb.append(String.format("Valor total do estoque: R$ %.2f%n", estoque.calcularValorTotal()));
        return sb.toString();
    }
}
