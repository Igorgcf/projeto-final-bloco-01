package com.igor.goal.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.igor.goal.controller.Controller;
import com.igor.goal.model.Instrumento;
import com.igor.goal.util.Cores;

public class Menu {

	public static void main(String[] args) {

		int opcao;
		int id =0;
		String nome;
		String tipo;
		float preco;
		String item ;
		
		Scanner scan = new 	Scanner(System.in);
		
		Controller controller = new Controller();
		
		Instrumento inst = new Instrumento(controller.gerarNumero(), "Cordas", "Guitarra", 1000.0f, "palheta");
		controller.criarProduto(inst);
		controller.listarProduto();
		
		
		
		while(true) {
		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLUE_BACKGROUND
				 + "*****************************************************");
		System.out.println("                                                     ");
		System.out.println("                Musica & Vida                        ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
		System.out.println("                                                     ");
		System.out.println("            1 - Cadastrar produto                    ");
		System.out.println("            2 - Listar todos os produtos             ");
		System.out.println("            3 - Atualizar Dados do produto           ");
		System.out.println("            4 - Apagar produto                       ");
		System.out.println("            5 - Sair                                 ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
		System.out.println("Entre com a opção desejada:                          ");
		System.out.println("                                                     ");
		System.out.println("                                                     " + Cores.TEXT_RESET);
		
		
		try {
			opcao = scan.nextInt();
		}catch(InputMismatchException e){
			System.out.println("\nDigite valores inteiros!");
			scan.nextLine();
			opcao=0;
		}
	
		
		if(opcao == 5) {
			sobre();
			scan.close();
			System.exit(0);
		}
	
		switch(opcao) {
		case 1 :
			System.out.println("\nCadastrar produto");
			
			System.out.println("\nEntre com tipo do instrumento: ");
			tipo = scan.next();
			
			System.out.println("\nEntre com o nome do instrumento: ");
			scan.skip("\\R");
			nome = scan.nextLine();
			
			System.out.println("\nEntre com o valor do produto: ");
			preco = scan.nextFloat();
			
			System.out.println("\nEntre com o item usasdo para tocar: ");
			scan.skip("\\R");
			item = scan.nextLine();
			
			controller.criarProduto(new Instrumento(controller.gerarNumero(), tipo, nome, preco, item));
			break;
		
		case 2 : 
			System.out.println("\nListar produtos");
			controller.listarProduto();
			break;
		
		case 3: 
			System.out.println("\nAtualizar produto");
			
			System.out.println("\nEntre com o id do produto: ");
			id = scan.nextInt();
			var buscaProduto = controller.buscarNaCollection(id);
			
			if(buscaProduto != null) {
				tipo = buscaProduto.getTipo();
			
			
			
			System.out.println("\nEntre com tipo do instrumento: ");
			tipo = scan.next();
			
			System.out.println("\nEntre com o nome do instrumento: ");
			scan.skip("\\R");
			nome = scan.nextLine();
			
			System.out.println("\nEntre com o valor do produto: ");
			preco = scan.nextFloat();
			
			System.out.println("\nEntre com o item usasdo para tocar: ");
			scan.skip("\\R");
			item = scan.nextLine();
			
			controller.atualizarProduto( new Instrumento(id, tipo, nome, preco, item));
			}
			
			break;
		
		case 4: 
			System.out.println("\nDeletar produto");
			
			System.out.println("\nDigite o id do produto: ");
			id = scan.nextInt();
			
			controller.apagarProduto(id);
			break;
	}
		}
		}
	
	public static void sobre() {
		System.out.println("Musica e Vida finalizado!!!");
		System.out.println("E-mail: igorgcf@outlook.com.br");
		System.out.println("Link GitHub: https://github.com/IgorTecnologia/-projeto_final_bloco_01");
	}
}
	
