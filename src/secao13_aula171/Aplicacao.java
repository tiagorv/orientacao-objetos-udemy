package secao13_aula171;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("informe os dados de seu contrato");
		System.out.print("Número: ");
		int numeroContrato = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		Date dataContrato = sdf.parse(sc.next());
		
		System.out.print("Valor do Contrato R$: ");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numeroContrato, dataContrato, valorTotal);
		
		System.out.print("Informe o número de parcela(s): ");
		int parcelas = sc.nextInt();
		
		ContratoService contratoService = new ContratoService(new PayPalService());
		contratoService.processaContrato(contrato, parcelas);
		
		System.out.println("Parcelas:");
		for (Parcela x : contrato.getParcelas()) {
			System.out.println(x);
		}
		
		sc.close();		
	}
}
