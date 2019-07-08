package secao9_aula104;

public class Pessoas {
	
	private String nome;
	private String cpf;
	private int idade;
	
	public Pessoas(String nome, String cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public boolean maiorDeIdade(){
		return this.idade >= 18 ? true : false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + this.nome + "\nCPF: " + this.cpf + "\nIdade: " + this.idade);
		return sb.toString();
	}
}
