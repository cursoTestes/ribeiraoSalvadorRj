package br.com.k21;

public class CalculadoraComissao {

	public Double calcula(Double valorVenda) {
		
		double comissao = valorVenda*5/100;
		comissao = trataArredondamento(comissao);
		return comissao;

	}

	private static double trataArredondamento(double comissao) {
		return Math.floor((comissao)*100)/100;
	}
	
}
