package secao11.aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import secao11.xadrez.PartidaXadrez;
import secao11.xadrez.PecaXadrez;
import secao11.xadrez.PosicaoXadrez;
import secao11.xadrez.XadrezException;

public class Programa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while(true) {
			try {
				UserInterface.limpaTela();
				UserInterface.imprimeTabuleiro(partidaXadrez.getPecas());
				System.out.println();
				System.out.print("Posição Origem: ");
				PosicaoXadrez origem = UserInterface.lePosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("Posição Destino: ");
				PosicaoXadrez destino = UserInterface.lePosicaoXadrez(sc);
				
				PecaXadrez pecaCapturada = partidaXadrez.realizaMovimentoXadrez(origem, destino);
			}catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
