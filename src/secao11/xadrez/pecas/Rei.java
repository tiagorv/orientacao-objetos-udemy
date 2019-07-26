package secao11.xadrez.pecas;

import secao11.tabuleiro.Tabuleiro;
import secao11.xadrez.Cor;
import secao11.xadrez.PecaXadrez;

public class Rei extends PecaXadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "K";
	}

}
