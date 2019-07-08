package secao9_aula104;

public class Pacientes extends Pessoas{
	
	private String numeroSus;

	public Pacientes(String nome, String cpf, int idade, String numeroSus) {
		super(nome, cpf, idade);
		this.numeroSus = numeroSus;
	}
	
	public String mostraCartaoSus() {
		return "Cart�o do SUS N: " + this.numeroSus;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\nN�mero SUS: " + this.numeroSus);
		return sb.toString();
	}
	
}
