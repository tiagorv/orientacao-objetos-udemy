package secao9_aula112;

public class PessoaJuridica extends Pessoa {
	
	private Integer numeroFuncionarios;

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	@Override
	public double calculaImposto() {
		return this.getRendaAnual() * (this.numeroFuncionarios > 10 ? .14 : .16);  
	}
}
