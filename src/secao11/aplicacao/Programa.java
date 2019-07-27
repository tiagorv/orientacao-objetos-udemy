package secao11.aplicacao;

import java.util.Scanner;

import secao11.xadrez.PartidaXadrez;
import secao11.xadrez.PecaXadrez;
import secao11.xadrez.PosicaoXadrez;

public class Programa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while(true) {
			UserInterface.imprimeTabuleiro(partidaXadrez.getPecas());
			System.out.println();
			System.out.print("Posição Origem: ");
			PosicaoXadrez origem = UserInterface.lePosicaoXadrez(sc);
			
			System.out.println();
			System.out.print("Posição Destino: ");
			PosicaoXadrez destino = UserInterface.lePosicaoXadrez(sc);
			
			PecaXadrez pecaCapturada = partidaXadrez.realizaMovimentoXadrez(origem, destino);
		}
	}
}
