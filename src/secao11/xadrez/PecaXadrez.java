package secao11.xadrez;

import secao11.tabuleiro.Peca;
import secao11.tabuleiro.Posicao;
import secao11.tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	
	private Cor cor;
	private int quantidadeMovimento;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getQuantidadeMovimento() {
		return quantidadeMovimento;
	}

	public void incrementaQuantidadeMovimento() {
		this.quantidadeMovimento++;
	}
	
	public void decrementaQuantidadeMovimento() {
		this.quantidadeMovimento--;
	}	
	
	public PosicaoXadrez getPosicaoXadrez() {
		return PosicaoXadrez.daPosicao(posicao);
	}
	
	protected boolean ehPecaOponente(Posicao posicao) {
		PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
		return p != null && p.getCor() != this.cor;
	}
}
