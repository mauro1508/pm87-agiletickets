package br.com.caelum.agiletickets.models;

public enum TipoDeEspetaculo {
	
	CINEMA (0.05, 0.10, false), SHOW (0.05, 0.10, false), TEATRO (0, 0, false), BALLET (0.50, 0.20, true), ORQUESTRA (0.50, 0.20, true);
	
	private double parametroPrimeiro;
	private double parametroSegundo;
	private boolean adicina10PorCentoQuandoSessaoMaior60Minutos;
	
	private TipoDeEspetaculo(double parametroPrimeiro, double parametroSegundo, boolean adicina10PorCentoQuandoSessaoMaior60Minutos) {
		this.parametroPrimeiro = parametroPrimeiro;
		this.parametroSegundo = parametroSegundo;
		this.adicina10PorCentoQuandoSessaoMaior60Minutos = adicina10PorCentoQuandoSessaoMaior60Minutos;
	}

	public double getParametroPrimeiro() {
		return parametroPrimeiro;
	}

	public double getParametroSegundo() {
		return parametroSegundo;
	}

	public boolean isAdicina10PorCentoQuandoSessaoMaior60Minutos() {
		return adicina10PorCentoQuandoSessaoMaior60Minutos;
	}
			
}
