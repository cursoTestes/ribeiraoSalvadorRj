package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CadastroDeUmaVendaInterfaceTest extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		return new FirefoxDriver();
	}
	
	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("");
		fill("#DataVenda").with("");
		fill("#Valor").with("");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor é obrigatório.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("O campo Valor é obrigatório.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("O campo Data Venda é obrigatório.", findFirst("#validacaoDataVenda").getText());					
	}
	
	@Test
	public void teste_cadastra_uma_venda_com_sucesso() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("1");
		fill("#DataVenda").with("27/08/2014");
		fill("#Valor").with("120,10");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Venda Cadastrada com sucesso ;)", findFirst("#msgSucesso").getText());
		Assert.assertEquals("", findFirst("#Vendedor").getText());
	}
	
	@Test
	public void teste_cadastra_uma_venda_com_vendedor_nao_numerico() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("a");
		fill("#DataVenda").with("27/08/2014");
		fill("#Valor").with("120,10");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor é obrigatório.", findFirst("#validacaoVendedor").getText()); 
	}
}
