package secao11.aplicacao;

import secao11.xadrez.PartidaXadrez;

public class Programa {
	public static void main(String[] args) {
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		UserInterface.imprimeTabuleiro(partidaXadrez.getPecas());
	}

}
