package secao10;

public class ContaBancaria {
	
	private Integer numero;
	private String nome;
	private Double saldo;
	private Double limiteSaque;
	
	public ContaBancaria(Integer numero, String nome, Double saldo, Double limiteSaque) {
		
		if (saldo < 0) {
			throw new IllegalArgumentException("O valor do saldo não pode ser negativo!");
		}
		
		if (limiteSaque < 0) {
			throw new IllegalArgumentException("O valor do limite de saque não pode ser negativo!");
		}
		
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}
	
	public void depositar(double valorDeposito) {
		if (valorDeposito < 0) {
			throw new IllegalArgumentException("Não pode depositar um valor negativo!!!");
		}
		this.saldo = this.saldo + valorDeposito;
		System.out.println("Depósito realizado com sucesso: " + this);
	}
	
	public void sacar(double valorDoSaque) {
		if (valorDoSaque < 0) {
			throw new IllegalArgumentException("Não pode sacar um valor negativo!!!");
		}
		
		if (valorDoSaque > this.limiteSaque) {
			throw new IllegalArgumentException("Valor do saque é superior ao limite de saque de sua conta!!!");			
		}
		
		if (valorDoSaque > this.saldo) {
			throw new IllegalArgumentException("Não têm saldo suficiente para efetuar o saque!!!");			
		}
		this.saldo = this.saldo - valorDoSaque;
		System.out.println("Saque realizado com sucesso: " + this);		
	}
	
	@Override
	public String toString() {
		return "Conta: " + 
				this.numero + 
				" Pessoa: " +
				this.nome +
				" Saldo da Conta R$: " +
				String.format("%.2f", this.saldo);
	}
}
