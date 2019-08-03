package secao11.xadrez.pecas;

import secao11.tabuleiro.Posicao;
import secao11.tabuleiro.Tabuleiro;
import secao11.xadrez.Cor;
import secao11.xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez{
	
	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "C";
	}
	
	public boolean podeMover(Posicao posicao) {
		PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
		return p == null || p.getCor() != this.getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0,0);
		
		p.setValues(posicao.getLinha() -1, posicao.getColuna() -2);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha() -2, posicao.getColuna() -1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha() -2, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha() -1, posicao.getColuna() + 2);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 2);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha() + 2, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha() + 2, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}								
		
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 2);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}		
		
		return matriz;
	}	
}
