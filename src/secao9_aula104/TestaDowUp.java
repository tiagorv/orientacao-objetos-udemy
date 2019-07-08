package secao9_aula104;

public class TestaDowUp {

	public static void main(String[] args) {
		Pessoas pessoa01 = new Pessoas("Jo�o", "12345678", 19);

		//DowCasting - Classe para classe filha, obrigat�rio casting
	    Pacientes pac01 = (Pacientes)pessoa01;
	    //Teremos acesso aos metodos da classe pai e da classe filha
	    System.out.println(pac01.maiorDeIdade());
	    System.out.println(pac01.mostraCartaoSus());
	    
	    //UpCasting da classe filha para a classe pai, sem casting
	    Pessoas pessoa02 = pac01;
	    //Informa��es especificas da classe filha n�o podem ser acessadas por pessoa02
	    //neste caso as informa��es do SUS podem ser utilizadas apenas por objetos de pacientes
	    System.out.println(pessoa02.maiorDeIdade());
	    
	    //Aqui temos nossos cuidados e base para o polimorfismo
	}
}
