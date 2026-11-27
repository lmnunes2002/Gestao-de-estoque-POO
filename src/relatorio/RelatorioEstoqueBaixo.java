package relatorio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import produtos.Produto;
import service.Estoque;

public class RelatorioEstoqueBaixo implements Relatorio {

    private Estoque estoque;
    private Integer limite;

    public RelatorioEstoqueBaixo() {
    }

    public RelatorioEstoqueBaixo(Estoque estoque, Integer limite) {
        this.estoque = estoque;
        this.limite = limite;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    @Override
    public String gerar() {
        if (estoque == null || limite == null) {
            throw new IllegalStateException("Estoque e limite devem ser informados para o relatório");
        }

        String linha = "--------------------------------------------------------------------";
        StringBuilder sb = new StringBuilder();
        sb.append("RELATÓRIO DE ESTOQUE BAIXO").append(System.lineSeparator());
        sb.append("Gerado em: ")
          .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
          .append(System.lineSeparator());
        sb.append("Limite considerado: até ").append(limite).append(" unidade(s)")
          .append(System.lineSeparator());
        sb.append(linha).append(System.lineSeparator());
        sb.append(String.format("%-8s %-24s %6s %8s  %s%n",
                "ID", "PRODUTO", "QTD", "MÍNIMO", "SITUAÇÃO"));
        sb.append(linha).append(System.lineSeparator());

        int encontrados = 0;
        for (Produto p : estoque.getProdutos()) {
            if (p.getQuantidade() <= limite) {
                String situacao = p.abaixoDoMinimo() ? "ABAIXO DO MÍNIMO" : "ATENÇÃO";
                sb.append(String.format("%-8s %-24s %6d %8d  %s%n",
                        p.getId(), p.getNome(), p.getQuantidade(), p.getEstoqueMinimo(), situacao));
                encontrados++;
            }
        }

        if (encontrados == 0) {
            sb.append("Nenhum produto com estoque baixo.").append(System.lineSeparator());
        }
        sb.append(linha).append(System.lineSeparator());
        sb.append("Produtos listados: ").append(encontrados).append(System.lineSeparator());
        return sb.toString();
    }
}
