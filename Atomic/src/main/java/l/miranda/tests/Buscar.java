package l.miranda.tests;

import org.junit.Assert;
import org.junit.Test;

import l.miranda.core.BaseTest;
import l.miranda.pages.Menu;
import l.miranda.pages.BuscarCEP;

public class Buscar extends BaseTest {

	BuscarCEP buscar = new BuscarCEP();
	Menu menu = new Menu();
	
	@Test
	public void buscarPorCEP()
	{
		menu.produtosEServicos();
		menu.buscaCEP();
		buscar.buscarCEP("15030-140");
		buscar.botaoBuscar();
		Assert.assertEquals("Rua Professor Alvaro Duarte de Almeida ", buscar.obterLogradouro());
	}
	
	@Test
	public void buscarPorLogradouro()
	{
		menu.produtosEServicos();
		menu.buscaCEP();
		buscar.buscarLogradouro("Garrafão");
		buscar.botaoBuscar();
		buscar.imprimirValorCelula("Logradouro/Nome:", "Garrafão", "Garrafão", ".//*[@class='tmptabela']");
	}
}