package secao9_aula109;

public class Produto {
	
	private String nome;
	private Double preco;
	
	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public double precoEtiqueta() {
		return this.preco;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString() {
		return this.nome + " R$: " + String.format("%.2f", this.preco);
	}
}
