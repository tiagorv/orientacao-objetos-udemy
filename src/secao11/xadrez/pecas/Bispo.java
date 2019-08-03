package secao11.xadrez.pecas;

import secao11.tabuleiro.Posicao;
import secao11.tabuleiro.Tabuleiro;
import secao11.xadrez.Cor;
import secao11.xadrez.PecaXadrez;

public class Bispo extends PecaXadrez{
	
	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao pAux = new Posicao(0, 0);
		
		//NW
		pAux.setValues(posicao.getLinha() - 1, posicao.getColuna() -1);
		while(getTabuleiro().posicaoExiste(pAux) && !getTabuleiro().istoEhUmaPeca(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;
			pAux.setValues(pAux.getLinha() - 1, pAux.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(pAux) && ehPecaOponente(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;			
		}
		
		//NE
		pAux.setValues(posicao.getLinha() - 1, posicao.getColuna() +1);
		while(getTabuleiro().posicaoExiste(pAux) && !getTabuleiro().istoEhUmaPeca(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;
			pAux.setValues(pAux.getLinha() - 1, pAux.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(pAux) && ehPecaOponente(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;			
		}		
		
		//SE
		pAux.setValues(posicao.getLinha() + 1, posicao.getColuna() +1);
		while(getTabuleiro().posicaoExiste(pAux) && !getTabuleiro().istoEhUmaPeca(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;
			pAux.setValues(pAux.getLinha() + 1, pAux.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(pAux) && ehPecaOponente(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;			
		}
		
		//SW
		pAux.setValues(posicao.getLinha() + 1, posicao.getColuna() -1);
		while(getTabuleiro().posicaoExiste(pAux) && !getTabuleiro().istoEhUmaPeca(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;
			pAux.setValues(pAux.getLinha() + 1, pAux.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(pAux) && ehPecaOponente(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;			
		}
		
		return matriz;
	}		
	
	

}
