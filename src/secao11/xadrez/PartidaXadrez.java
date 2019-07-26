package secao11.xadrez;

import secao11.tabuleiro.Posicao;
import secao11.tabuleiro.Tabuleiro;
import secao11.xadrez.pecas.Rei;
import secao11.xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,  8);
		setupInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		
		for(int i =0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}
	
	public void setupInicial() {
		tabuleiro.colocaPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));
		tabuleiro.colocaPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
		tabuleiro.colocaPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));		
	}

}
