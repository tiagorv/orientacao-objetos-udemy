package secao12_aula161;

import java.io.File;
import java.util.Scanner;

public class LePastas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o diretório: ");
		String dir = sc.nextLine();
		
		File pasta = new File(dir);
		
		System.out.println("---PASTAS---");
		File[] pastas = pasta.listFiles(File::isDirectory);
		for (File file : pastas) {
			System.out.println(file);
		}
		
		System.out.println("----ARQUIVOS----");
		File[] arquivos = pasta.listFiles(File::isFile);
		for (File file : arquivos) {
			System.out.println(file);
		}
		
		boolean sucesso = new File(dir + "\\novoDir").mkdir();
		System.out.println("Pasta criada com sucesso: " + sucesso );
		
		sc.close();
		
	}

}
