package br.com.k21;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void testeValorVendaMenorQue10000Valor100Comissao5() {
		Double valorVenda = 100.0;
		Double esperado = 5.0;
		
		Double comissao = new CalculadoraComissao().calcula(valorVenda);
		
		assertEquals(esperado, comissao);
		assertEquals(esperado, valorVenda);
	}
	
	@Test
	public void testeValorVendaMenorQue10000Valor10000Comissao500() {
		Double valorVenda = 10000.0;
		Double esperado = 500.0;
		
		Double comissao = new CalculadoraComissao().calcula(valorVenda);
		
		assertEquals(esperado, comissao);
	}
	
	@Test
	public void testeValorVendaMenorQue10000Valor1RealComissao5Centavos() {
		Double valorVenda = 1.0;
		Double esperado = 0.05;
		
		Double comissao = new CalculadoraComissao().calcula(valorVenda);
		
		assertEquals(esperado, comissao);
	}
	
	@Test
	public void testeValorVendaMaiorQue10000Valor55Reais59CentavosComissao2Reais77Centavos() {
		Double valorVenda = 55.59;
		Double esperado = 2.77;
		
		Double comissao = new CalculadoraComissao().calcula(valorVenda);
		
		assertEquals(esperado, comissao);
	}

}
