package secao9_aula109;

public class ProdutoImportado extends Produto{
	
	private Double valorAlfandega;

	public ProdutoImportado(String nome, Double preco, Double valorAlfandega) {
		super(nome, preco);
		this.valorAlfandega = valorAlfandega;
	}
	
	@Override
	public double precoEtiqueta() {
		return super.precoEtiqueta() + this.valorAlfandega;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Taxa alfandega R$: " + String.format("%.2f",this.valorAlfandega);
	}
}
