package secao14_aula178;

import java.util.ArrayList;
import java.util.List;

public class ImpressoraService<T> {
	
	List<T> minhaLista = new ArrayList();
	
	public void adiciona(T novoValor) {
		minhaLista.add(novoValor);
	}
	
	public void mostraLista() {
		for (T t : minhaLista) {
			System.out.println(" T " + t );
		}
	}

}
