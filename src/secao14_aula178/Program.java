package secao14_aula178;

public class Program {
	
	public static void main(String[] args) {
		
		ImpressoraService<String> impressora = new ImpressoraService<String>();
		
		impressora.adiciona("Tiago Valério");
		impressora.adiciona("João da Silva");
		
		impressora.mostraLista();
		
	}

}
