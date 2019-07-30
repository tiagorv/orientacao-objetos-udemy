package secao11.xadrez.pecas;

import secao11.tabuleiro.Posicao;
import secao11.tabuleiro.Tabuleiro;
import secao11.xadrez.Cor;
import secao11.xadrez.PecaXadrez;

public class Rei extends PecaXadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	public boolean podeMover(Posicao posicao) {
		PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
		return p == null || p.getCor() != this.getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0,0);
		
		//Acima 
		p.setValues(posicao.getLinha() -1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[posicao.getLinha()][posicao.getColuna()] = true;
		}
		
		//Abaixo 
		p.setValues(posicao.getLinha() +1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[posicao.getLinha()][posicao.getColuna()] = true;
		}
		
		//Esquerda 
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[posicao.getLinha()][posicao.getColuna()] = true;
		}
		
		//Direita 
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[posicao.getLinha()][posicao.getColuna()] = true;
		}
		
		//Sudeste 
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[posicao.getLinha()][posicao.getColuna()] = true;
		}
		
		//Sudoeste 
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[posicao.getLinha()][posicao.getColuna()] = true;
		}
		
		//Nordeste 
		p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[posicao.getLinha()][posicao.getColuna()] = true;
		}								
		
		//Noroeste 
		p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[posicao.getLinha()][posicao.getColuna()] = true;
		}		
		
		return matriz;
	}

}
