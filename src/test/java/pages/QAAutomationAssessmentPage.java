package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import core.TestBase;

public class QAAutomationAssessmentPage extends TestBase{
	
	@FindBy(id="elementosForm:nome")
	WebElement firstNameInput;
	
	@FindBy(id="elementosForm:sobrenome")
	WebElement lastNameInput;
	
	@FindBy(id="elementosForm:sexo:0")
	WebElement maleRadio;
	
	@FindBy(id="elementosForm:sexo:1")
	WebElement femaleRadio;
	
	@FindBy(id="elementosForm:comidaFavorita:0")
	WebElement meatCheckbox;
	
	@FindBy(id="elementosForm:comidaFavorita:1")
	WebElement chickenCheckbox;
	
	@FindBy(id="elementosForm:comidaFavorita:2")
	WebElement pizzaCheckbox;
	
	@FindBy(id="elementosForm:comidaFavorita:3")
	WebElement veganCheckbox;
	
	@FindBy(id="elementosForm:escolaridade")
	WebElement scholarshipCombo;
	
	@FindBy(id="elementosForm:esportes")
	WebElement sportsCombo;
	
	@FindBy(id="elementosForm:sugestoes")
	WebElement commentsTextarea;
	
	@FindBy(id="elementosForm:cadastrar")
	WebElement signupButton;
	
	@FindBy(id="alert")
	WebElement alertButton;
	
	@FindBy(id="confirm")
	WebElement confirmButton;
	
	@FindBy(id="resultado")
	WebElement statusDiv;
	
	@FindBy(xpath="//div[@id=\"resultado\"]/span")
	WebElement successMessageSpan;
	
	@FindBy(xpath="//div[@id=\"descNome\"]/span")
	WebElement firstNameSpan;
	
	@FindBy(xpath="//div[@id=\"descSobrenome\"]/span")
	WebElement lastNameSpan;
	
	@FindBy(xpath="//div[@id=\"descSexo\"]/span")
	WebElement genderSpan;
	
	@FindBy(xpath="//div[@id=\"descComida\"]/span")
	WebElement foodSpan;

	@FindBy(xpath="//div[@id=\"descEscolaridade\"]/span")
	WebElement scholarshipSpan;
	
	@FindBy(xpath="//div[@id=\"descEsportes\"]/span")
	WebElement sportsSpan;
	
	@FindBy(xpath="//div[@id=\"descSugestoes\"]/span")
	WebElement commentsSpan;
	
	@FindBy(id="buttonSimple")
	WebElement clickHereButton;
	
	
	
	public QAAutomationAssessmentPage() {
		PageFactory.initElements(this.driver, this);
	}
	
	public void typeFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}
	
	public void typeLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	
	public void clickMale() {
		maleRadio.click();
	}
	
	public void markChicken() {
		chickenCheckbox.click();
	}
	
	public void selectSport(String opt) {
		Select sportsSelect = new Select(sportsCombo);
		sportsSelect.selectByValue(opt);
	}
	
	public void selectScholarship(String opt) {
		Select scholarshipSelect = new Select(scholarshipCombo);
		scholarshipSelect.selectByVisibleText(opt);
	}
	
	public void typeComment(String commentMsg) {
		commentsTextarea.sendKeys(commentMsg);
	}
	
	public void clickSignup() {
		signupButton.click();
	}
	
	public String getStatus() {
		return statusDiv.getText();
	}
	
	public String getSuccessMessage() {
		return successMessageSpan.getText();
	}
	
	public String getFirstName() {
		return firstNameSpan.getText();
	}
	
	public String getLastName() {
		return lastNameSpan.getText();
	}
	
	public String getGender() {
		return genderSpan.getText();
	}
	
	public String getScholarship() {
		return scholarshipSpan.getText();
	}
	
	public String getFoods() {
		return foodSpan.getText();
	}
	
	public String getSports() {
		return sportsSpan.getText();
	}
	
	public String getComments() {
		return commentsSpan.getText();
	}
	
	public void clickClickHereButton() {
		clickHereButton.click();
	}
	
	public String getClickHereBtnValue() {
		return clickHereButton.getAttribute("value");
	}
	
	public void clickConfirmButton() {
		confirmButton.click();
	}
	
}
