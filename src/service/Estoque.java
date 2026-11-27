package service;

import java.util.ArrayList;
import java.util.List;

import enums.StatusNota;
import enums.TipoMovimentacao;
import exceptions.EstoqueInsuficienteException;
import exceptions.NotaInvalidaException;
import exceptions.ProdutoNaoEncontradoException;
import notasfiscais.ItemNota;
import notasfiscais.MovimentacaoEstoque;
import notasfiscais.NotaFiscal;
import produtos.Produto;

public class Estoque {

	private List<Produto> produtos;
	private List<NotaFiscal> notas;
	private List<MovimentacaoEstoque> historico;

	public Estoque() {
		this.produtos = new ArrayList<>();
		this.notas = new ArrayList<>();
		this.historico = new ArrayList<>();
	}

	public Estoque(List<Produto> produtos, List<NotaFiscal> notas, List<MovimentacaoEstoque> historico) {
		this.produtos = produtos;
		this.notas = notas;
		this.historico = historico;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<NotaFiscal> getNotas() {
		return notas;
	}

	public List<MovimentacaoEstoque> getHistorico() {
		return historico;
	}

	public void cadastrarProduto(Produto p) {
		if (p == null) {
			throw new IllegalArgumentException("Produto não informado");
		}
		for (Produto existente : produtos) {
			if (existente.getId().equals(p.getId())) {
				throw new IllegalArgumentException("Já existe produto com o id " + p.getId());
			}
		}
		produtos.add(p);
	}

	public Produto buscarPorId(String id) {
		for (Produto p : produtos) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		throw new ProdutoNaoEncontradoException(id);
	}

	public void processarNota(NotaFiscal nota) {
		if (nota == null) {
			throw new NotaInvalidaException("Nota não informada");
		}
		if (notas.contains(nota)) {
			throw new NotaInvalidaException("Nota já foi processada pelo estoque");
		}
		if (nota.getStatus() == StatusNota.RASCUNHO) {
			nota.emitir();
		}
		if (nota.getStatus() != StatusNota.EMITIDA) {
			throw new NotaInvalidaException("Apenas notas emitidas podem ser processadas");
		}

		TipoMovimentacao tipo = nota.getTipoMovimentacao();

		for (ItemNota item : nota.getItens()) {
			Produto p = buscarPorId(item.getProduto().getId());
			if (tipo == TipoMovimentacao.SAIDA && p.getQuantidade() < item.getQuantidade()) {
				throw new EstoqueInsuficienteException(p.getQuantidade(), item.getQuantidade());
			}
		}

		for (ItemNota item : nota.getItens()) {
			Produto p = buscarPorId(item.getProduto().getId());
			if (tipo == TipoMovimentacao.ENTRADA) {
				p.adicionarQuantidade(item.getQuantidade());
			} else {
				p.removerQuantidade(item.getQuantidade());
			}
			historico.add(new MovimentacaoEstoque(p, item.getQuantidade(), tipo, nota));
		}

		notas.add(nota);
	}

	public List<NotaFiscal> listarNotas(TipoMovimentacao tipo) {
		List<NotaFiscal> resultado = new ArrayList<>();
		for (NotaFiscal nota : notas) {
			if (nota.getTipoMovimentacao() == tipo) {
				resultado.add(nota);
			}
		}
		return resultado;
	}

	public List<Produto> listarAbaixoDoMinimo() {
		List<Produto> resultado = new ArrayList<>();
		for (Produto p : produtos) {
			if (p.abaixoDoMinimo()) {
				resultado.add(p);
			}
		}
		return resultado;
	}

	public Double calcularValorTotal() {
		double total = 0;
		for (Produto p : produtos) {
			total += p.calcularValorTotal();
		}
		return total;
	}
}
