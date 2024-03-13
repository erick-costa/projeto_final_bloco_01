package loja.repository;

import loja.model.Produto;

public interface LojaRepository {
	public void procurarPorID(int id);
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
}
