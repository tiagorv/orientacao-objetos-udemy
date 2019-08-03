package secao11.xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import secao11.tabuleiro.Peca;
import secao11.tabuleiro.Posicao;
import secao11.tabuleiro.Tabuleiro;
import secao11.xadrez.pecas.Bispo;
import secao11.xadrez.pecas.Cavalo;
import secao11.xadrez.pecas.Peao;
import secao11.xadrez.pecas.Rei;
import secao11.xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	private int jogada;
	private Cor jogadorAtual;
	private boolean xeque;
	private boolean xequeMate;
	
	private List<Peca> pecasNoTabuleiro = new ArrayList();
	private List<Peca> pecasCapturadas = new ArrayList();
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,  8);
		this.jogada = 1;
		this.jogadorAtual = Cor.BRANCO;
		this.xeque = false;
		setupInicial();
	}
	
	public int getJogada() {
		return jogada;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}
	
	public boolean isXeque() {
		return xeque;
	}
	
	public boolean isXequeMate() {
		return xequeMate;
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
	
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem){
		Posicao posicao = posicaoOrigem.paraPosicao();
		validaPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}
	
	public PecaXadrez realizaMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		validaPosicaoOrigem(origem);
		validaPosicaoDestino(origem, destino);
		Peca pecaCapturada = realizaMovimento(origem, destino);
		
		if (testaXeque(jogadorAtual)) {
			desfazerMovimento(origem, destino, pecaCapturada);
			throw new XadrezException("Você não pode se colocar em xeque-mate!");
		}
		
		this.xeque = (testaXeque(oponente(jogadorAtual))) ? true : false;
		
		if (testaXequeMate(oponente(jogadorAtual))) {
			xequeMate = true;
		}else {
			proximaJogada();			
		}
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca realizaMovimento(Posicao origem, Posicao destino) {
		PecaXadrez p = (PecaXadrez)tabuleiro.removePeca(origem);
		p.incrementaQuantidadeMovimento();
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		tabuleiro.colocaPeca(p, destino);
		
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		return pecaCapturada;
	}
	
	private void desfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
		PecaXadrez p = (PecaXadrez)tabuleiro.removePeca(destino);
		p.decrementaQuantidadeMovimento();
		tabuleiro.colocaPeca(pecaCapturada, origem);
		
		if (pecaCapturada != null) {
			tabuleiro.colocaPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}
	}
	
	private void validaPosicaoOrigem(Posicao posicao) {
		if(!tabuleiro.istoEhUmaPeca(posicao)) {
			throw new XadrezException("Não existe uma peça nesta posição!");
		}
		
		if (jogadorAtual != ((PecaXadrez) this.tabuleiro.peca(posicao)).getCor()) {
			throw new XadrezException("Está peça não é sua!!!");
		}
		
		if(!tabuleiro.peca(posicao).existeMovimentoPossivel()) {
			throw new XadrezException("Não existe movimento possível para a peça!!!");
		}
	}
	
	private void validaPosicaoDestino(Posicao origem, Posicao destino) {
		if(!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new XadrezException("A peça não pode ser movida para a posição de destino!");
		}
	}
	
	private void proximaJogada() {
		this.jogada++;
		this.jogadorAtual = (this.jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private Cor oponente(Cor cor) {
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private PecaXadrez rei(Cor cor) {
		List<Peca> lista = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peca pp : lista) {
			if (pp instanceof Rei) {
				return (PecaXadrez)pp;
			}
		}
		throw new IllegalArgumentException("Não no tabuleiro a peça rei da cor: " + cor);
	}
	
	private boolean testaXeque(Cor cor) {
		Posicao posicaoRei = rei(cor).getPosicaoXadrez().paraPosicao();
		List<Peca> pecasOponente = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
		
		for (Peca pp : pecasOponente) {
			boolean[][] matriz = pp.movimentosPossiveis();
			if (matriz[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean testaXequeMate(Cor cor) {
		if (!testaXeque(cor)) {
			return false;
		}
		
		List<Peca> lista = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peca p : lista) {
			boolean[][] matriz = p.movimentosPossiveis();
			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getColunas(); j++) {
					if (matriz[i][j]) {
						Posicao origem = ((PecaXadrez)p).getPosicaoXadrez().paraPosicao();
						Posicao destino = new Posicao(i, j);
						Peca pecaCapturada = realizaMovimento(origem, destino);
						boolean testaXeque = testaXeque(cor);
						desfazerMovimento(origem, destino, pecaCapturada);
						if (!testaXeque) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	private void lugarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocaPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
		pecasNoTabuleiro.add(peca);
	}
	
	public void setupInicial() {
		lugarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.BRANCO));		
		lugarNovaPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCO));		
		lugarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
		lugarNovaPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCO));		
		lugarNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.BRANCO));		
		lugarNovaPeca('h', 7, new Torre(tabuleiro, Cor.BRANCO));		
		lugarNovaPeca('a', 2, new Peao(tabuleiro, Cor.BRANCO));		
		lugarNovaPeca('b', 2, new Peao(tabuleiro, Cor.BRANCO));
		lugarNovaPeca('c', 2, new Peao(tabuleiro, Cor.BRANCO));
		lugarNovaPeca('d', 2, new Peao(tabuleiro, Cor.BRANCO));
		lugarNovaPeca('e', 2, new Peao(tabuleiro, Cor.BRANCO));
		lugarNovaPeca('f', 2, new Peao(tabuleiro, Cor.BRANCO));
		lugarNovaPeca('g', 2, new Peao(tabuleiro, Cor.BRANCO));
		lugarNovaPeca('h', 2, new Peao(tabuleiro, Cor.BRANCO));
		
		lugarNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETO));
		lugarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.PRETO));		
		lugarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.PRETO));		
		lugarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		lugarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.PRETO));
		lugarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.PRETO));		
		lugarNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETO));
		lugarNovaPeca('a', 7, new Peao(tabuleiro, Cor.PRETO));		
		lugarNovaPeca('b', 7, new Peao(tabuleiro, Cor.PRETO));
		lugarNovaPeca('c', 7, new Peao(tabuleiro, Cor.PRETO));
		lugarNovaPeca('d', 7, new Peao(tabuleiro, Cor.PRETO));
		lugarNovaPeca('e', 7, new Peao(tabuleiro, Cor.PRETO));
		lugarNovaPeca('f', 7, new Peao(tabuleiro, Cor.PRETO));
		lugarNovaPeca('g', 7, new Peao(tabuleiro, Cor.PRETO));
		lugarNovaPeca('h', 7, new Peao(tabuleiro, Cor.PRETO));
	}
}