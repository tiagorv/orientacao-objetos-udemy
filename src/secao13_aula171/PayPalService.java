package secao13_aula171;

public class PayPalService implements PagamentoOnlineService {
	
	private static final Double PERCENTUAL_TAXA = 0.02;
	private static final Double JURO_MENSAL = 0.01;

	@Override
	public double taxaDePagamento(double valor) {
		return valor * PERCENTUAL_TAXA;
	}

	@Override
	public double juroMensal(double valor, int meses) {
		return valor * JURO_MENSAL * meses;
	}
}
