package br.com.k21;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private CalculadoraComissao mockCalcComissao;
	private VendaDAO mockDao;

	@Before
	public void inicializaMocks() {
		mockCalcComissao = mock(CalculadoraComissao.class);
		mockDao = mock(VendaDAO.class);
	}
	
	@Test
	public void mesSemVendas() {
		Double royaltiesEsperado = 0.0;
		int mes = 1;
		int ano = 2014;
		when(mockDao.obterVendasPorMesEAno(ano, mes)).thenReturn(new ArrayList<Venda>());
		
		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties();
		calcRoyalties.setCc(mockCalcComissao);
		calcRoyalties.setDao(mockDao);
		Double totalRoyalties = calcRoyalties.calcular(mes, ano);
		
		assertEquals(royaltiesEsperado, totalRoyalties);
	}

	@Test
	public void mesComUmaVenda() {
		Double royaltiesEsperado = 19.0;
		int mes = 2;
		int ano = 2014;
		List<Venda> listaComUmaVenda = Arrays.asList(new Venda(1, 1, mes, ano, 100.0));

		when(mockDao.obterVendasPorMesEAno(ano, mes)).thenReturn(listaComUmaVenda);
		
		when(mockCalcComissao.calcula(anyDouble())).thenReturn(5.0);
		
		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties();
		calcRoyalties.setCc(mockCalcComissao);
		calcRoyalties.setDao(mockDao);
		Double totalRoyalties = calcRoyalties.calcular(mes, ano);
		
		assertEquals(royaltiesEsperado, totalRoyalties);
		verify(mockCalcComissao,times(1)).calcula(anyDouble());
		
	}
	
	@Test
	public void mesComDuasVendas() {
		Double royaltiesEsperado = 38.0;
		int mes = 3;
		int ano = 2014;

		List<Venda> listaComDuasVendas = new ArrayList<Venda>();
		listaComDuasVendas.add(new Venda(1, 1, mes, ano, 100.0));
		listaComDuasVendas.add(new Venda(2, 2, mes, ano, 100.0));
		
		when(mockDao.obterVendasPorMesEAno(ano, mes)).thenReturn(listaComDuasVendas);
		when(mockCalcComissao.calcula(100.0)).thenReturn(5.0);
		
		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties();
		calcRoyalties.setCc(mockCalcComissao);
		calcRoyalties.setDao(mockDao);
		Double totalRoyalties = calcRoyalties.calcular(mes, ano);
		
		assertEquals(royaltiesEsperado, totalRoyalties);
	}
	
		
}
