package loja.controller;

import java.util.ArrayList;
import loja.model.Produto;
import loja.repository.LojaRepository;

public class LojaController implements LojaRepository {
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void procurarPorID(int id) {
		var produto = buscarNaCollection(id);
		
		if(produto != null) produto.visualizar();
		else System.out.println("\nO produto número: " + id + " não foi encontrada!");
	}

	@Override
	public void listarTodos() {
		for(var produto : listaProdutos) {
			produto.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto número: " + produto.getId() + " foi cadastrado com sucesso!");		
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());
		
		if(buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO produto número: " + produto.getId() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO produto número: " + produto.getId() + " não foi encontrado!");
		}
		
	}

	@Override
	public void deletar(int numero) {
		var produto = buscarNaCollection(numero);
		
		if(produto != null) {
			if(listaProdutos.remove(produto) == true) System.out.println("\nO produto número: " + numero + " foi excluído com sucesso!");
		} else {
			System.out.println("\nO produto número: " + numero + " não foi encontrado!");
		}
		
	}
	
	public int gerarId() {
		return ++ id;
	}
	
	public Produto buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if(produto.getId() == id) return produto;
		}
		
		return null;
	}
	
}
