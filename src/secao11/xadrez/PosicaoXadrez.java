package secao11.xadrez;

import secao11.tabuleiro.Posicao;

public class PosicaoXadrez {
	
	private char coluna;
	private int linha;
	
	public PosicaoXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("No tabuleiro s�o validas as coluna de a at� g e as lina de 1 at� 9!!");
		}
		this.coluna = coluna;
		this.linha = linha;
	}
	
	protected Posicao paraPosicao() {
		return new Posicao(8 - this.linha, this.coluna - 'a');
	}
	
	protected PosicaoXadrez daPosicao(Posicao posicao) {
		return new PosicaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
			return "" + this.coluna + this.linha;
	}
}
