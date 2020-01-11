package l.miranda.core;

import static l.miranda.core.DriverFactory.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import l.miranda.pages.HomePage;

public class BaseTest {
	private HomePage page = new HomePage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa()
		{
			page.acessarTelaInicial();
		}
	
	@After
	public void finaliza() throws IOException{
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
