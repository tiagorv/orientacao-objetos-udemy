package secao19.aula207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExercicioMap {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> listaVotos = new TreeMap<String, Integer>();
		System.out.print("Arquivo com os votos:");
		String arquivo = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			String linha = br.readLine();
			while(linha != null) {
				String[] dados = linha.split(",");
				
				int votos = Integer.parseInt(dados[1]);
				if (listaVotos.containsKey(dados[0])) {
					votos += listaVotos.get(dados[0]);
				}
				listaVotos.put(dados[0], votos);
				linha = br.readLine();
			}			
		} catch (Exception e) {
			System.out.println("Não foi possível ler o arquivo: " + e.getMessage());
		}
 		sc.close();
 		
 		for (String chave : listaVotos.keySet()) {
 			System.out.println("Candidato: " + chave + " recebeu " + listaVotos.get(chave) + " votos.");
 		}
 		
	}

}
