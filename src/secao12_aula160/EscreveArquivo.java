package secao12_aula160;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class EscreveArquivo {
	
	public static void main(String[] args) {
		String[] linhas = new String[] {"Tiago Valério", "Udemy Java", "Escrita de Arquivo"};
		String meuArquivo = "c:\\tiago\\arquivoEscrita.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(meuArquivo))){
			
			for (String linha : linhas) {
				bw.write(linha);
				bw.newLine();
			}
		} catch (Exception e) {
			System.out.println("Erro de Escrita de Arquivo: " + e.getMessage());
		}
	}
}
