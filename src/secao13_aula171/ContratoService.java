package secao13_aula171;

import java.util.Calendar;
import java.util.Date;

public class ContratoService {
	
	private PagamentoOnlineService pagamentoOnlineService;

	public ContratoService(PagamentoOnlineService pagamentoOnlineService) {
		this.pagamentoOnlineService = pagamentoOnlineService;
	}
	
	public void processaContrato(Contrato contrato, int meses) {
		
		double quotaBasica = contrato.getValorTotal() / meses;
		for (int i = 1; i <= meses; i++) {
			Date novaData = adicionaMeses(contrato.getDataContrato(), i);
			double quotaAtualizada = quotaBasica + pagamentoOnlineService.juroMensal(quotaBasica, i);
			double quota = quotaAtualizada + pagamentoOnlineService.taxaDePagamento(quotaAtualizada);
			contrato.adicionaParcela(new Parcela(novaData, quota));
		}
	}
	
	private Date adicionaMeses(Date novaData, int numero) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(novaData);
		calendar.add(Calendar.MONTH, numero);
		return calendar.getTime();
	}
	
	

}
