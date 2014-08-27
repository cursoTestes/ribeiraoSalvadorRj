package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaDAO dao = new VendaDAO();
	private CalculadoraComissao cc = new CalculadoraComissao();

	public VendaDAO getDao() {
		return dao;
	}

	public void setDao(VendaDAO dao) {
		this.dao = dao;
	}

	public CalculadoraComissao getCc() {
		return cc;
	}

	public void setCc(CalculadoraComissao cc) {
		this.cc = cc;
	}

	
	public Double calcular(int mes, int ano) {
		
		List<Venda> listaVendas = dao.obterVendasPorMesEAno(ano, mes);
		Double totalLiquidoVendas = 0.0;
		
		for (Venda venda : listaVendas) {
			Double vendaLiquida = venda.getValor() - cc.calcula(venda.getValor());
			totalLiquidoVendas = totalLiquidoVendas + vendaLiquida;
		}
		
		
		return totalLiquidoVendas * 0.2;
	}

}
