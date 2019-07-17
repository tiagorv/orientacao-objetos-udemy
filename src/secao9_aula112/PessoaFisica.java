package secao9_aula112;

public class PessoaFisica extends Pessoa{
	
	private Double gastosMedicos;

	public PessoaFisica(String nome, Double rendaAnual, Double gastosMedicos) {
		super(nome, rendaAnual);
		this.gastosMedicos = gastosMedicos;
	}
	
	@Override
	public double calculaImposto() {
		double valorImposto = 0;
		
		valorImposto = this.getRendaAnual() * (this.getRendaAnual() < 20000 ? .15 : .25);
		
		if (this.gastosMedicos > 0) valorImposto = valorImposto - (this.gastosMedicos * .5);

		if (valorImposto < 0) valorImposto = 0;
		
		return valorImposto;
	}
}
