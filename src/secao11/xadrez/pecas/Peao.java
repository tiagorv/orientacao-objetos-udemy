package secao11.xadrez.pecas;

import java.awt.MultipleGradientPaint.ColorSpaceType;

import secao11.tabuleiro.Posicao;
import secao11.tabuleiro.Tabuleiro;
import secao11.xadrez.Cor;
import secao11.xadrez.PecaXadrez;

public class Peao extends PecaXadrez{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean [][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		if (getCor() == Cor.BRANCO) {
			p.setValues(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().istoEhUmaPeca(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValues(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().istoEhUmaPeca(p) && getTabuleiro().posicaoExiste(p2) 
					&& !getTabuleiro().istoEhUmaPeca(p2) && getQuantidadeMovimento() == 0) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValues(posicao.getLinha() - 1, posicao.getColuna() -1);
			if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}			
			
			p.setValues(posicao.getLinha() - 1, posicao.getColuna() +1);
			if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}			
		}else {
			p.setValues(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().istoEhUmaPeca(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValues(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().istoEhUmaPeca(p) && getTabuleiro().posicaoExiste(p2) 
					&& !getTabuleiro().istoEhUmaPeca(p2) && getQuantidadeMovimento() == 0) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValues(posicao.getLinha() + 1, posicao.getColuna() -1);
			if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}			
			
			p.setValues(posicao.getLinha() + 1, posicao.getColuna() +1);
			if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}						
		}
		return matriz;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
