package secao11.tabuleiro;

public abstract class Peca {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}
	
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] movimentosPossiveis();
	
	public boolean movimentoPossivel(Posicao posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean existeMovimentoPossivel() {
		boolean[][] matrizAux = movimentosPossiveis();
		for (int i = 0; i < matrizAux.length; i++) {
			for (int j = 0; j < matrizAux.length; j++) {
				if (matrizAux[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}