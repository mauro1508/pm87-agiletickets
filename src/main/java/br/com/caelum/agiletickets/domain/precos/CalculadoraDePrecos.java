package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculadoraDePrecos {
	
	private static final double DESCONTO_10_PORCENTO = 0.10; 

	private static final int TEMPO_60_MINUTOS = 60;

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		
		BigDecimal preco = calculaPreco(sessao, sessao.getEspetaculo().getTipo().getParametroPrimeiro(), sessao.getEspetaculo().getTipo().getParametroSegundo());

		if ( sessao.getEspetaculo().getTipo().isAdicina10PorCentoQuandoSessaoMaior60Minutos() ) {
			
			if (sessao.getDuracaoEmMinutos() > TEMPO_60_MINUTOS) {
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(DESCONTO_10_PORCENTO)));
			}
			
		}
		
		return preco.multiply(BigDecimal.valueOf(quantidade));
		
	}

	private static BigDecimal calculaPreco(Sessao sessao, double primeiroPercentual, double segundoPercentual) {

		BigDecimal preco;
		
		if ((sessao.getTotalIngressos() - sessao.getIngressosReservados())/ sessao.getTotalIngressos().doubleValue() <= primeiroPercentual) {
			
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(segundoPercentual)));
			
		} else {
			
			preco = sessao.getPreco();
			
		}
		
		return preco;
	}
	
	

}