package secao14_aula178;

public class Program {
	
	public static void main(String[] args) {
		
		ImpressoraService<String> impressora = new ImpressoraService<String>();
		
		impressora.adiciona("Tiago Val�rio");
		impressora.adiciona("Jo�o da Silva");
		
		impressora.mostraLista();
		
	}

}
