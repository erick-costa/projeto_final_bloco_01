package loja;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import loja.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		int opcao = 0;

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

					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas os produtos\n\n");

					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Buscar produto por ID\n\n");

					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar informações do produto\n\n");

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Excluir produto\n\n");
					
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
