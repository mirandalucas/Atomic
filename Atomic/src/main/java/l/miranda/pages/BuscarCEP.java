package l.miranda.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static l.miranda.core.DriverFactory.getDriver;
import l.miranda.core.BasePage;
import java.util.List;

public class BuscarCEP extends BasePage {
	public void buscarCEP(String CEP)
	{
		escreverx("//*[@id=\"Geral\"]/div/div/span[2]/label/input", CEP);
	}
	
	public void buscarLogradouro(String Logradouro)
	{
		escreverx("//*[@id=\"Geral\"]/div/div/span[2]/label/input", Logradouro);
	}
	
	public void produtosEServicos(String id)
	{
		clicarBotao(id);
	}
	
	public void botaoBuscar()
	{
		clicarBotao(By.xpath("//*[@id=\'Geral\']/div/div/div[6]/input"));
	}
	
	public String obterLogradouro()
	{
		return obterTexto(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]"));
	}
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='" +idTabela+ "']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}
	
	public void imprimirValorCelula(String colunaBusca, String valor, String valorBusca, String idTabela){
		WebElement celula = obterCelula(colunaBusca, valor, valorBusca, idTabela);
		if(celula.toString() == valorBusca)
		{
			System.out.println(celula);
		}
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}
