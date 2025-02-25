package com.igor.goal.model;

public class Instrumento extends Model{

	private String item;
	
	public Instrumento(int id, String tipo, String nome, float preco, String item) {
		super(id, tipo, nome, preco);
		this.item = item;
		
		
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public void visualisar() {
		super.visualisar();
		System.out.println("\nItem usando para tocar: " + this.item);
		
		
	}
}
