package secao13_aula171;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataVcto;
	private Double valorParcela;
	
	public Parcela() {
		// TODO Auto-generated constructor stub
	}

	public Parcela(Date dataVcto, Double valorParcela) {
		this.dataVcto = dataVcto;
		this.valorParcela = valorParcela;
	}

	public Date getDataVcto() {
		return dataVcto;
	}

	public void setDataVcto(Date dataVcto) {
		this.dataVcto = dataVcto;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	@Override
	public String toString() {
		return sdf.format(this.dataVcto) + " - " + String.format("%.2f", this.valorParcela);
	}
}
