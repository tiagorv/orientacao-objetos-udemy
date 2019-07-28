package secao11.xadrez.pecas;

import secao11.tabuleiro.Posicao;
import secao11.tabuleiro.Tabuleiro;
import secao11.xadrez.Cor;
import secao11.xadrez.PecaXadrez;

public class Torre extends PecaXadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao pAux = new Posicao(0, 0);
		
		//Casas para cima
		pAux.setValues(posicao.getLinha() - 1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(pAux) && !getTabuleiro().istoEhUmaPeca(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;
			pAux.setLinha(pAux.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExiste(pAux) && ehPecaOponente(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;			
		}
		
		//Casas para esquerda
		pAux.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		while(getTabuleiro().posicaoExiste(pAux) && !getTabuleiro().istoEhUmaPeca(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;
			pAux.setColuna(pAux.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(pAux) && ehPecaOponente(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;			
		}		
		
		//Casas para direita
		pAux.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		while(getTabuleiro().posicaoExiste(pAux) && !getTabuleiro().istoEhUmaPeca(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;
			pAux.setColuna(pAux.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(pAux) && ehPecaOponente(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;			
		}	
		
		//Casas para cima
		pAux.setValues(posicao.getLinha() + 1, posicao.getColuna());
		while(getTabuleiro().posicaoExiste(pAux) && !getTabuleiro().istoEhUmaPeca(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;
			pAux.setLinha(pAux.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExiste(pAux) && ehPecaOponente(pAux)) {
			matriz[pAux.getLinha()][pAux.getColuna()] = true;			
		}		
		
		return matriz;
	}	
}
