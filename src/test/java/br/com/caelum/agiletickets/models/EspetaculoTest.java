package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

public class EspetaculoTest {
	
	
	@Test
	public void deveCriar3sessoesparaIntervaloDe2DiasPeriodicidadeDiaria() {
		
		LocalDate dtInicio = new LocalDate(2014, 1, 1);
		LocalDate dtFIm = new LocalDate(2014, 1, 3);
		LocalTime horario =  new LocalTime(22, 0);
				
		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(dtInicio, dtFIm, horario, Periodicidade.DIARIA);
		
		for (Sessao sessao : sessoes) {
			Assert.assertTrue(sessao.getInicio().equals(dtInicio.toLocalDateTime(horario).toDateTime()));
			dtInicio = dtInicio.plusDays(1);
		}
		
		Assert.assertEquals(sessoes.size(), 3);
		
	}
	
	@Test
	public void deveCriar5sesaoParaMesJaneiroPeriodicidadeSemanal() {
		
		LocalDate dtInicio = new LocalDate(2014, 1, 1);
		LocalDate dtFIm = new LocalDate(2014, 1, 31);
		LocalTime horario =  new LocalTime(22, 0);
				
		Espetaculo espetaculo = new Espetaculo();
		
		List<Sessao> sessoes = espetaculo.criaSessoes(dtInicio, dtFIm, horario, Periodicidade.SEMANAL);
		
		for (Sessao sessao : sessoes) {
			Assert.assertTrue(sessao.getInicio().equals(dtInicio.toLocalDateTime(horario).toDateTime()));
			dtInicio = dtInicio.plusWeeks(1);
		}
		
		Assert.assertEquals(sessoes.size(), 5);
		
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
}
