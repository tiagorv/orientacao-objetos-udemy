package secao13_aula171;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	
	private Integer numero;
	private Date dataContrato;
	private Double valorTotal;
	private List<Parcela> parcelas = new ArrayList();
	
	public Contrato() {
		// TODO Auto-generated constructor stub
	}
	
	public Contrato(Integer numero, Date dataContrato, Double valorTotal) {
		this.numero = numero;
		this.dataContrato = dataContrato;
		this.valorTotal = valorTotal;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Date getDataContrato() {
		return dataContrato;
	}
	
	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public List<Parcela> getParcelas() {
		return parcelas;
	}
	
	public void adicionaParcela(Parcela parcela) {
		this.parcelas.add(parcela);
	}
}
