package com.igor.goal.repositoryl;

import com.igor.goal.model.Model;

public interface Repository {

	public void criarProduto(Model model);
	public void procurarPorId(int numero);
	public void listarProduto();
	public void atualizarProduto(Model model);
	public void apagarProduto(int numero);
}
