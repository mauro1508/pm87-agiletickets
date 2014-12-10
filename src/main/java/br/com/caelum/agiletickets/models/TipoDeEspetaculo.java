package br.com.caelum.agiletickets.models;

public enum TipoDeEspetaculo {

	CINEMA(0.05, 0.10, false), SHOW(0.05, 0.10, false), TEATRO(0, 0, false), BALLET(0.50, 0.20, true), ORQUESTRA(0.50, 0.20, true);

	private double minimoDeIngressosDisponivelParaAumentarPreco;
	private double adicionaAMaisNosUltimosIngressos;
	private boolean adicina10PorCentoQuandoSessaoMaior60Minutos;
	
	private TipoDeEspetaculo(
			double minimoDeIngressosDisponivelParaAumentarPreco,
			double adicionaAMaisNosUltimosIngressos,
			boolean adicina10PorCentoQuandoSessaoMaior60Minutos) {
		this.minimoDeIngressosDisponivelParaAumentarPreco = minimoDeIngressosDisponivelParaAumentarPreco;
		this.adicionaAMaisNosUltimosIngressos = adicionaAMaisNosUltimosIngressos;
		this.adicina10PorCentoQuandoSessaoMaior60Minutos = adicina10PorCentoQuandoSessaoMaior60Minutos;
	}

	public double getMinimoDeIngressosDisponivelParaAumentarPreco() {
		return minimoDeIngressosDisponivelParaAumentarPreco;
	}

	public double getAdicionaAMaisNosUltimosIngressos() {
		return adicionaAMaisNosUltimosIngressos;
	}

	public boolean isAdicina10PorCentoQuandoSessaoMaior60Minutos() {
		return adicina10PorCentoQuandoSessaoMaior60Minutos;
	}

	

}
