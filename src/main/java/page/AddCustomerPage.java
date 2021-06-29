package page;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id=\"country\"]")
	WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ON_ADD_CONTACT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_BUTTON_ON_SUMMARY_PAGE;
	/*@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	WebElement DELETE_ALERT_OK_BUTTON;
	@FindBy(how = How.XPATH, using = "//div[@class = 'alert alert-success fade in']")
	WebElement DELETE_RESULT_TEXT;*/

	String enteredName;

	public void enterFullName(String fullName) {
		waitForElement(driver, 5, FULL_NAME_FIELD);
		enteredName = fullName + generateNumber(999);
		FULL_NAME_FIELD.sendKeys(enteredName);
	}

	public void enterCompany(String company) {
		selectDropdown(COMPANY_FIELD, company);
	}

	public void enterEmail(String email) {
		EMAIL_FIELD.sendKeys(generateNumber(9999) + email);
	}

	public void enterPhone(String phone) {
		PHONE_FIELD.sendKeys(phone + generateNumber(999));
	}

	public void enterAddress(String address) {
		ADDRESS_FIELD.sendKeys(address);
	}

	public void enterCity(String city) {
		CITY_FIELD.sendKeys(city);
	}

	public void enterState(String state) {
		STATE_FIELD.sendKeys(state);
	}

	public void enterZip(String zip) {
		ZIP_FIELD.sendKeys(zip);
	}

	public void enterCountry(String country) {
		COUNTRY_FIELD.sendKeys(country);
	}

	public void ClickSaveButtonOnAddContact() {
		SAVE_BUTTON_ON_ADD_CONTACT.click();
	}

	public void verifySummaryPage() {
		waitForElement(driver, 5, SUMMARY_BUTTON_ON_SUMMARY_PAGE);
		Assert.assertEquals(SUMMARY_BUTTON_ON_SUMMARY_PAGE.getText(), "Summary", "Wrong page!!");
	}

	public String getUserName() {
		return enteredName;
	}
}
