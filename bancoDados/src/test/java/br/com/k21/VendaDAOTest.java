package br.com.k21;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.com.k21.Vendedor;
import br.com.k21.dao.VendaDAO;
import br.com.k21.dao.VendedorDAO;
import br.com.k21.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void test_total_para_inexistente() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 99;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2001;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void test_total_para_vendedor_sem_vendas() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 1;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2001;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void test_total_para_vendedor_com_uma_venda_no_ano() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}

	@Test
	public void test_total_para_vendedor_com_mais_de_uma_venda_no_ano() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}

	@Test
	public void test_total_para_vendedor_com_vendas_em_anos_diferentes() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 8;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2002;
		double resultado;
		double esperado = 15000.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}

	@Test
	public void test_total_venda_compartilhada() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 9;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2012;
		double resultado;
		double esperado = 50.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}
}
