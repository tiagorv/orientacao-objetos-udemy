package secao19.aula205;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Programa {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> meusAlunos = new HashSet();
		
		System.out.print("Quantos alunos na turma A:");
		int numero = sc.nextInt();
		for (int i = 0; i < numero; i++) {
			System.out.print("Código do Aluno (" + (i+1) + ") : ");
			meusAlunos.add(sc.nextInt());
		}
		
		System.out.print("Quantos alunos na turma B:");
		numero = sc.nextInt();
		for (int i = 0; i < numero; i++) {
			System.out.print("Código do Aluno (" + (i+1) + ") : ");
			meusAlunos.add(sc.nextInt());
		}		
		
		System.out.println("Quantidade de Alunos: " + meusAlunos.size());
		for (Integer codAluno : meusAlunos) {
			System.out.println("Aluno: " + codAluno);
		}
	}

}
