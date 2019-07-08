package secao9_aula106;

public class Pessoa {
	
	private String nome;
	private final String pais = "Brasil";
	
	//Utilizando final n�o permite utilizar a variavel no construtor ou 
	//alterar o seu conteudo em qualquer metodo
	//Esta palavra reservada em metodo e classe serve para seguran�a n�o permitindo
	//heran�a ou sobreposi��o do metodo como  final
	public Pessoa(String nome, String novoPais ) {
		this.nome = nome;
	}
}
