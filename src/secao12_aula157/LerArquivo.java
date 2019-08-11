package secao12_aula157;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivo {
	public static void main(String[] args) {
		
		File meuArquivo = new File("c:\\tiago\\arquivo.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(meuArquivo);
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro leitura de arquivo: " + e.getMessage());
		}finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
