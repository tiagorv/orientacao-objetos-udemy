package secao20_aula213;

import java.util.ArrayList;
import java.util.List;

public class Programa {
	
	public static void main(String[] args) {
		
		List<Produto> lista = new ArrayList();
		
		lista.add(new Produto("TV", 1800.0));
		lista.add(new Produto("Cama", 800.0));
		lista.add(new Produto("Sapato", 120.0));
		lista.add(new Produto("Bermuda", 80.0));
		
		//predicate - Exclui produto com valor menor que 100
		lista.removeIf(produto -> produto.getPreco() <= 100);
		
		//consumer - Aumentando 10%
		lista.forEach(produto -> produto.setPreco(produto.getPreco() * 1.1));
		
		//Consumer 
		lista.forEach(System.out::println);
	}

}
