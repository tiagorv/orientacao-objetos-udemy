package secao9_aula109;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		List<Produto> produtos = new ArrayList();
		
		
		System.out.print("Informe a quantidade de Produtos: ");
		int numeroProdutos = sc.nextInt();
		sc.nextLine();
		for(int posicao = 1; posicao <= numeroProdutos; posicao++) {
			System.out.println("Item " + posicao + ":");
			System.out.print("Produto Novo, Importado ou Usado (N,I,U)");
			char tipoProduto = sc.nextLine().charAt(0);
			
			System.out.print("Nome do Produto: ");
			String nomeProduto = sc.nextLine();
			
			System.out.print("Preço do Produto: ");
			Double valorProduto = sc.nextDouble();
			
			if (tipoProduto == 'N') {
				sc.nextLine();
				produtos.add(new Produto(nomeProduto, valorProduto));
			}else if (tipoProduto == 'I') {
				System.out.print("Taxa da Alfândega: ");
				Double taxa = sc.nextDouble();
				sc.nextLine();
				produtos.add(new ProdutoImportado(nomeProduto, valorProduto, taxa));
			}else if (tipoProduto == 'U') {
				sc.nextLine();
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				System.out.print("Data do Produto (DD/MM/YYYY): ");
				Date dataProduto = sd.parse(sc.nextLine());
				produtos.add(new ProdutoUsado(nomeProduto, valorProduto, dataProduto));
			}
		}
		
		System.out.println("PRICE TAGS");
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		sc.close();
	}

}
