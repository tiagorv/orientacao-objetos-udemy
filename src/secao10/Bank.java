package secao10;

import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Informe o nome do dono da conta: ");
			String nomeDaPessoa = sc.nextLine();
			System.out.print("Informe o número da conta: ");
			int numeroConta = sc.nextInt();
			System.out.print("Informe o saldo inicial da conta R$: ");
			double saldoConta = sc.nextDouble();
			System.out.print("Informe o valor de limite de saque da conta R$: ");
			double limiteSaque = sc.nextDouble();
			ContaBancaria conta = new ContaBancaria(numeroConta, nomeDaPessoa, saldoConta, limiteSaque);
			System.out.println("Conta Criado com sucesso...");
			System.out.println(conta);
			
			int operacao = 0;
			do {
				System.out.println("---Operações Bancárias Disponíveis---");
				System.out.print("1-Depósito, 2-Saque e 3-Encerra Atendimento:");
				operacao = sc.nextInt();
				
				if (operacao == 1) {
					System.out.print("Informe o valor a ser depositado R$: ");
					double valor = sc.nextDouble();
					conta.depositar(valor);
				}else if(operacao == 2) {
					System.out.print("Informe o valor a ser sacado R$: ");
					double valor = sc.nextDouble();
					conta.sacar(valor);
				}else if (operacao == 3) {
					System.out.println("Atendimento Encerrado...");
					System.out.println(conta);
				}else {
					throw new IllegalArgumentException("Operação Financeira inválida : " + operacao);
				}
			}while(operacao != 3);
		}catch (IllegalArgumentException e) {
			System.out.println("Erro na operações bancárias: " + e.getMessage());
		}finally {
			sc.close();			
		}
	}

}
