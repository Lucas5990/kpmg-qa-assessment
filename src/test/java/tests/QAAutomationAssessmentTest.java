package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.DriverFactory;
import core.TestBase;
import pages.QAAutomationAssessmentPage;

public class QAAutomationAssessmentTest extends TestBase {

	private QAAutomationAssessmentPage page;

	@Before
	public void accessLocalPage() {
		String currentDirectory = System.getProperty("user.dir");
		driver.get("file://" + currentDirectory + "/src/test/resources/app/QAAssessment.html");
		this.page = new QAAutomationAssessmentPage();
	}

	@After
	public void closeBrowser() {
		DriverFactory.killDriver();
	}

	@Test
	// CT001 - Validar mensagem de campo "Nome".
	public void CT001() {
		// Preenche os campos com a massa de dados
		page.typeLastName("Andrade");
		page.clickMale();
		page.markChicken();
		page.selectScholarship("2o grau incompleto");
		page.selectSport("Corrida");
		page.typeComment("Este é um comentário teste.");
		page.clickSignup();
		// Valida a mensagem de erro informando que o campo nome é obrigatório
		String actualMsg = driver.switchTo().alert().getText();
		String expectedMsg = "Nome é obrigatorio";
		Assert.assertEquals(expectedMsg, actualMsg);
		// Valida fechamento do pop-up e status
		driver.switchTo().alert().accept();
		String actualStatus = page.getStatus();
		String expectedStatus = "Status: Não cadastrado";
		Assert.assertEquals(expectedStatus, actualStatus);
	}

	@Test
	// CT002 - Validar mensagem de campo "Sexo Obrigatório".
	public void CT002() {
		// Preenche os campos com a massa de dados
		page.typeFirstName("Lucas");
		page.typeLastName("Andrade");
		page.markChicken();
		page.selectScholarship("2o grau incompleto");
		page.selectSport("Corrida");
		page.typeComment("Este é um comentário teste.");
		page.clickSignup();
		// Valida a mensagem de erro informando que o campo sexo é obrigatório
		String actualMsg = driver.switchTo().alert().getText();
		String expectedMsg = "Sexo é obrigatorio";
		Assert.assertEquals(expectedMsg, actualMsg);
		// Valida fechamento do pop-up e status
		driver.switchTo().alert().accept();
		String actualStatus = page.getStatus();
		String expectedStatus = "Status: Não cadastrado";
		Assert.assertEquals(expectedStatus, actualStatus);
	}

	@Test
	// CT003 - Cadastrar novos dados.
	public void CT003(){
		// Inicializando variáveis para a massa de dados
		String nome = "Lucas";
		String sobrenome = "Andrade";
		String escolaridade = "2o grau incompleto";
		String esporte = "Corrida";
		String comentario = "Este é um comentário teste.";
		
		// Preenche os campos com a massa de dados
		page.typeFirstName(nome);
		page.typeLastName(sobrenome);
		page.clickMale();
		page.markChicken();
		page.selectScholarship(escolaridade);
		page.selectSport(esporte);
		page.typeComment(comentario);
		page.clickSignup();
		// Valida a mensagem "OK" no pop-up
		String actualMsg = driver.switchTo().alert().getText();
		Assert.assertEquals("OK", actualMsg);
		// Valida mensagem "Cadastrado com sucesso"
		driver.switchTo().alert().accept();
		String actualSuccessMsg = page.getSuccessMessage();
		String expectedSuccessMsg = "Cadastrado com sucesso!";
		Assert.assertEquals(expectedSuccessMsg, actualSuccessMsg);
		// Valida informações conforme preenchimento
		Assert.assertEquals(nome, page.getFirstName());
		Assert.assertEquals(sobrenome, page.getLastName());
		Assert.assertEquals("Masculino", page.getGender());
		Assert.assertEquals("Frango", page.getFoods());
		Assert.assertEquals("2grauincomp", page.getScholarship());
		Assert.assertEquals(esporte, page.getSports());
		Assert.assertEquals(comentario, page.getComments());		
	}
	
	@Test
	// CT004 - Validar o nome do botão "Clique aqui" quando ele for clicado.
	public void CT004(){	
		page.clickClickHereButton();
		String expectedBtnValue = "Obrigado!";
		String actualBtnValue = page.getClickHereBtnValue();
		Assert.assertEquals(expectedBtnValue, actualBtnValue);	
	}
	
	@Test
	// CT005 - Rejeitar confirmação de mensagem de alerta
	public void CT005(){	
		page.clickConfirmButton();
		driver.switchTo().alert().dismiss();
		// Validar mensagem no pop-up ao clicar no botão cancelar
		String actualCancelMsg = driver.switchTo().alert().getText();
		String expectedCancelMsg = "Negado";
		Assert.assertEquals(expectedCancelMsg, actualCancelMsg);
		// Validar fechamento do pop-up e status
		driver.switchTo().alert().accept();
		String actualStatus = page.getStatus();
		String expectedStatus = "Status: Não cadastrado";
		Assert.assertEquals(expectedStatus, actualStatus);
	}
}
