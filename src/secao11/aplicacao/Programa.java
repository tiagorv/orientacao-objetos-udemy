package secao11.aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import secao11.xadrez.PartidaXadrez;
import secao11.xadrez.PecaXadrez;
import secao11.xadrez.PosicaoXadrez;
import secao11.xadrez.XadrezException;

public class Programa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PecaXadrez> capturadas = new ArrayList();
		
		while(true) {
			try {
				UserInterface.limpaTela();
				UserInterface.imprimePartida(partidaXadrez, capturadas);
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UserInterface.lePosicaoXadrez(sc);
				
				boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
				UserInterface.limpaTela();
				UserInterface.imprimeTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UserInterface.lePosicaoXadrez(sc);
				
				PecaXadrez pecaCapturada = partidaXadrez.realizaMovimentoXadrez(origem, destino);
				
				if (pecaCapturada != null) {
					capturadas.add(pecaCapturada);
				}
				
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
