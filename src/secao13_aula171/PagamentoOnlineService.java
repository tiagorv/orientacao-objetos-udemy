package secao13_aula171;

public interface PagamentoOnlineService {
	
	double taxaDePagamento(double valor);
	double juroMensal(double valor, int meses);

}
