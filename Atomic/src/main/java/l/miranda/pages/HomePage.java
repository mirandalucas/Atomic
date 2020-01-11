package l.miranda.pages;

import l.miranda.core.BasePage;
import l.miranda.core.DriverFactory;

public class HomePage extends BasePage 
	{
		public void acessarTelaInicial()
			{
				DriverFactory.getDriver().get("http://www.correios.com.br/");
			}
	}
