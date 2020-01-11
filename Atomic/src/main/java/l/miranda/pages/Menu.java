package l.miranda.pages;

import l.miranda.core.BasePage;

public class Menu extends BasePage {
	
	public void produtosEServicos()
	{
		clicarBotaox("//*[@id=\'products_services\']");
	}
	
	public void buscaCEP()
	{
		clicarBotaox("//*[@id=\'menu\']/div/div/div/div[1]/ul[2]/li[5]/div/ul/li[2]/a");
	}
}
