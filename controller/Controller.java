package com.igor.goal.controller;

import java.util.ArrayList;

import com.igor.goal.model.Model;
import com.igor.goal.repositoryl.Repository;

public class Controller implements Repository {
	
	private ArrayList<Model> listaProdutos = new ArrayList<Model>();
	int numero =0;
	
	
	@Override
	public void criarProduto(Model model)  {
		listaProdutos.add(model);
		System.out.println("\nO produto " + model.getId() + " foi criado com sucesso");
	}
	
	@Override
	public void listarProduto() {
		for(var model : listaProdutos) {
			model.visualisar();
			
			}
		}
		
	
	@Override
	public void atualizarProduto(Model model) {
		var buscaProduto = buscarNaCollection(model.getId());
		
		if(buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), model);
			System.out.println("\nO produto número " + model.getId() + " foi atualizado com sucesso");
		}else {
			System.out.println("\nO produto número " + model.getId() + " não foi encontrado!");
		}
		
		
	}

	@Override
	public void apagarProduto(int numero) {
		
		var model = buscarNaCollection(numero);
		
		if(model != null) {
			if (listaProdutos.remove(model) == true) {
				System.out.println("\nO produto número " + model.getId() + " foi deletado com sucesso!");
			}else {
				System.out.println("\nO produto número " + model.getId() + " não foi encontrado!");
			}
				
		}
		
	}

	public int gerarNumero() {
		return ++ numero;
	}

	@Override
	public void procurarPorId(int numero) {
		var model = buscarNaCollection(numero);
		
		if (model != null) {
			model.visualisar();
		}else {
			System.out.println("\nO produto número: " + numero + " não foi encontrado!");
		}
		
	}

	public Model buscarNaCollection (int numero) {
		for (var model : listaProdutos) {
			if(model.getId() == numero) {
				return model;
			}
		}
		return null;
	}

}

