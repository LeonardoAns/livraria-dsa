package com.livraria.dsa;


import com.livraria.dsa.presentation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class DsaApplication {

	private final CreateAuthorPresentation createAutorPresentation;
	private final CreatePublisherPresentation createEditoraPresentation;
	private final CreateBookPresentation createLivroPresentation;
	private final CreatePeriodicalPresentation createPeriodicoPresentation;
	private final CreateStudentPresentation createAlunoPresentation;
	private final ReturnMaterialPresentation devolverMaterialPresentation;
	private final LendMaterialPresentation emprestarMaterialPresentation;
	private final ListActiveLoansPresentation listarEmprestimosPresentation;
	private final ListSpecificMaterialPresentation listarMateriaisEspecificosPresentations;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DsaApplication.class, args);

		DsaApplication application = context.getBean(DsaApplication.class);
		application.menu();
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);

		int escolha;
		do {
			System.out.println("Escolha uma opção:\n" +
					"-------------------\n"+
					"1. Criar Livro\n" +
					"2. Criar Periodico\n" +
					"3. Criar Autor\n" +
					"4. Criar Editora\n" +
					"5. Criar Aluno\n" +
					"6. Emprestar Livro\n" +
					"7. Devolver Livro\n" +
					"8. Listar Emprestimos Ativos\n" +
					"9. Listar materiais do tipo desejado\n" +
					"0. Sair\n"+
					"-------------------");
			while (!sc.hasNextInt()) {
				System.out.println("Por favor, insira um número válido.");
				sc.next();
			}
			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
				case 1 -> createLivroPresentation.criarLivro(sc);
				case 2 -> createPeriodicoPresentation.criarPeriodico(sc);
				case 3 -> createAutorPresentation.criarAutor(sc);
				case 4 -> createEditoraPresentation.criarEditora(sc);
				case 5 -> createAlunoPresentation.criarAluno(sc);
				case 6 -> emprestarMaterialPresentation.emprestarMaterial(sc);
				case 7 -> devolverMaterialPresentation.devolverMaterial(sc);
				case 8 -> listarEmprestimosPresentation.listarEmprestimosAtivos();
				case 9 -> listarMateriaisEspecificosPresentations.listarMateriais(sc);
				case 0 -> System.out.println("\033[0;32mSaindo...\033[0m");
				default -> System.out.println("\033[0;31mOpção inválida. Tente novamente.\033[0m");
			}
		} while (escolha != 0);
		sc.close();
	}
}
