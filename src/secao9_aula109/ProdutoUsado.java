package secao9_aula109;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto{
	
	private Date dataProduto;

	public ProdutoUsado(String nome, Double preco, Date dataProduto) {
		super(nome, preco);
		this.dataProduto = dataProduto;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		return this.getNome() + " (usado) R$: " + String.format("%.2f", this.precoEtiqueta()) + " Produzido em: " + sd.format(this.dataProduto); 
	}
}
