package loja;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import loja.controller.LojaController;
import loja.model.Suplemento;
import loja.util.Cores;

public class Menu {

	public static void main(String[] args) {
		LojaController produtos = new LojaController();
		
		Scanner leia = new Scanner(System.in);

		int opcao = 0, id;
		String nome;
		float preco;

		while (opcao != 6) {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                 POWER SUPLEMENTOS                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar produto                    ");
			System.out.println("            2 - Listar todas os produtos             ");
			System.out.println("            3 - Buscar produto por ID                ");
			System.out.println("            4 - Atualizar informações do produto     ");
			System.out.println("            5 - Excluir produto                      ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			try {				
				opcao = leia.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			

			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Cadastrar produto\n\n");
					
					System.out.println("Digite o nome do produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					System.out.println("Digite o preço do produto: ");
					preco = leia.nextFloat();
					
					produtos.cadastrar(new Suplemento(produtos.gerarId(), nome, preco));

					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas os produtos\n\n");
					
					produtos.listarTodos();					

					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Buscar produto por ID\n\n");
					
					System.out.println("Digite o id do produto: ");
					id = leia.nextInt();
					
					produtos.procurarPorID(id);

					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar informações do produto\n\n");
					
					System.out.println("Digite o id do produto: ");
					id = leia.nextInt();
					
					var buscarProduto = produtos.buscarNaCollection(id);
					
					if(buscarProduto != null) {
						System.out.println("Digite o nome do produto: ");
						leia.skip("\\R?");
						nome = leia.nextLine();
						System.out.println("Digite o preço do produto: ");
						preco = leia.nextFloat();
						
						produtos.atualizar(new Suplemento(id, nome, preco));
					} else System.out.println("O produto não foi encontrado!");

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Excluir produto\n\n");
					
					System.out.println("Digite o id do produto: ");
					id = leia.nextInt();
					
					produtos.deletar(id);
					
					keyPress();

					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nPOWER SUPLEMENTOS - O seu físico começa aqui!");
					
					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
		
		leia.close();
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}

	}
