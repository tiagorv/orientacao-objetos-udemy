package secao9_aula112;

public abstract class Pessoa {
	
	private String nome;
	private Double rendaAnual;
	
	public Pessoa(String nome, Double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}
	
	public double getRendaAnual() {
		return this.rendaAnual;
	}
	
	public abstract double calculaImposto();
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " Renda Anual R$: " +	String.format("%.2f", this.rendaAnual);
	}
}
