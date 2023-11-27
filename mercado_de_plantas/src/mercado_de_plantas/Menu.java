package mercado_de_plantas;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Optional;

import mercado_de_plantas.controller.PlantaController;
import mercado_de_plantas.model.Planta;
import mercado_de_plantas.model.PlantaExterna;
import mercado_de_plantas.model.PlantaInterna;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		String nome;
		int opcao, tipo, internas, externas, id = 0;
		float preco;
		
		PlantaController plantas = new PlantaController();

		while (true) {
			System.out
					.println("Boas vindas! Este é o sistema para o lojista do mercado de plantas nativas brasileiras!");
			System.out.println("Espaços enfeitados com plantas que fazem bem ao nosso ecossistema.");
			System.out.println(" ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ");
			System.out.println("                  Menu inicial:               ");
			System.out.println(" 1 - Cadastrar nova planta                    ");
			System.out.println(" 2 - Listar todas as plantas disponíveis      ");
			System.out.println(" 3 - Buscar planta por ID                     ");
			System.out.println(" 4 - Atualizar cadastro de uma planta         ");
			System.out.println(" 5 - Apagar uma planta do sistema             ");
			System.out.println(" 10 - Fechar o sistema                        ");
			System.out.println(" ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ");
			System.out.println(" Digite a opção desejada:                     ");
			System.out.println("                                              ");

			try {
				opcao = leia.nextInt();

			} catch (InputMismatchException e) {
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 10 -> {
				System.out.println("Sistema encerrado!");
				System.exit(0);
			}
			case 1 -> {
				System.out.println("Cadastro de nova planta selecionado.");
				System.out.println("Digite o nome da planta: ");
				leia.skip("\\R");
				nome = leia.nextLine();

				System.out.println("Digite o tipo de ambiente da planta (1 - interna ou 2 - externa): ");
				tipo = leia.nextInt();

				System.out.println("Digite o preço de venda da planta: ");
				preco = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o tipo de planta (1 - flores ou 2 - samambaias): ");
					internas = leia.nextInt();
					plantas.cadastrar(new PlantaInterna(plantas.gerarId(), nome, tipo, preco, internas));
					break;
				}
				case 2 -> {
					System.out.println("Digite o tipo de planta (1 - frutíferas ou 2 - hortaliças): ");
					externas = leia.nextInt();
					plantas.cadastrar(new PlantaExterna(plantas.gerarId(), nome, tipo, preco, externas));
					break;
				}
				}
			}
			case 2 -> {
				System.out.println("As plantas atualmente listadas em nosso sistema são:.");
				plantas.listarTodas();
				break;
			}
			case 3 -> {
				System.out.println("Localizador de plantas. Por favor, informe o ID da planta: ");
				id = leia.nextInt();
				plantas.buscarNaCollection(id);
				break;
			}
			case 4 -> {
				System.out.println("Atualizar informações de uma planta. Prossiga com as informações solicitadas:");
				System.out.println();
				
				Optional<Planta> planta = plantas.buscarNaCollection(id);
				
				if (planta.isPresent()) {

					System.out.println("Digite o nome da planta: ");
					leia.skip("\\R");
					nome = leia.nextLine();

					System.out.println("Digite o tipo de ambiente da planta (1 - interna ou 2 - externa): ");
					tipo = leia.nextInt();

					System.out.println("Digite o preço de venda da planta: ");
					preco = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o tipo de planta (1 - flores ou 2 - samambaias): ");
						internas = leia.nextInt();
						plantas.cadastrar(new PlantaInterna(plantas.gerarId(), nome, tipo, preco, internas));
						break;
					}
					case 2 -> {
						System.out.println("Digite o tipo de planta (1 - frutíferas ou 2 - hortaliças): ");
						externas = leia.nextInt();
						plantas.cadastrar(new PlantaExterna(plantas.gerarId(), nome, tipo, preco, externas));
						break;
					}
					}

				} else
					System.out.println(" Nenhuma planta com id " + id + " foi encontrada.");
			}
			case 5 -> {
				System.out.println("Apagar uma planta do sistema. Prossiga com as informações solicitadas:");
				System.out.println("Informe o id da conta a ser deletada.");
				id = leia.nextInt();
				plantas.deletar(id);
			}
			}
		}

	}
}
