package secao12_aula159;

import java.io.BufferedReader;
import java.io.FileReader;

public class LerArquivo {
	
	public static void main(String[] args) {
		
		String arquivo = "c:\\tiago\\arquivo.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			
			String linha = br.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Erro de leitura do arquivo: " + e.getMessage());
		}
	}
}
