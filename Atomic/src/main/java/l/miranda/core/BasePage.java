package l.miranda.core;

import static l.miranda.core.DriverFactory.getDriver;
import org.openqa.selenium.By;

public class BasePage {

/********* TextField e TextArea ************/
	
	public void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	public void escreverx(String id_campo, String texto){
		escrever(By.xpath(id_campo), texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
		
	/********* Botao ************/
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}
	
	public void clicarBotaox(String id) {
		clicarBotao(By.xpath(id));
	}
	
	public void clicarBotaoName(String id) {
		clicarBotao(By.name(id));
	}
	
	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
		
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
}
