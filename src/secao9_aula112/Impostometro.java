package secao9_aula112;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Impostometro {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o número de contribuintes: ");
		int numeroContribuintes = sc.nextInt();
		sc.nextLine();
		
		List<Pessoa> listaPessoa = new ArrayList();
		for (int i = 0; i < numeroContribuintes; i++) {
			System.out.println("Pessoa " + i + " : ");
			System.out.print("Nome da Pessoa: ");
			String nomePessoa = sc.nextLine();

			System.out.print("Renda Anual R$: ");
			double rendaPessoa = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Física ou Jurídica(f/j):");
			char tipoPessoa = sc.nextLine().charAt(0);
			
			if(tipoPessoa == 'f') {
				System.out.print("Valor com Gastos Médicos R$: ");
				double valorMedico = sc.nextDouble();
				listaPessoa.add(new PessoaFisica(nomePessoa, rendaPessoa, valorMedico));
			}else {
				System.out.print("Número de Funcionários: ");
				int numeroDeFuncionarios = sc.nextInt();
				listaPessoa.add(new PessoaJuridica(nomePessoa, rendaPessoa, numeroDeFuncionarios));
			}
			sc.nextLine();
		}
		
		for (Pessoa pessoas : listaPessoa) {
			System.out.println(pessoas + " Imposto R$: " + String.format("%.2f", pessoas.calculaImposto()));
		}
		
		sc.close();
	}

}
