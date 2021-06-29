package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CustomersListPage extends BasePage {

	WebDriver driver;

	public CustomersListPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	WebElement DELETE_ALERT_OK_BUTTON;
	@FindBy(how = How.XPATH, using = "//div[@class = 'alert alert-success fade in']")
	WebElement DELETE_RESULT_TEXT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'foo_filter']")
	WebElement SEARCH_CUSTOMER_FIELD;
	
	By SEARCH_RESULT_ROW = By.xpath("//table/tbody/tr[not(contains(@style,'display: none;'))]");

	public void verifyEnteredNameAndDelete(String enteredName) {

		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if (name.contains(enteredName)) {
				System.out.println(name + " Entered name exist.");
				driver.findElement(By.xpath(before_xpath + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
				waitForElement(driver, 5, DELETE_ALERT_OK_BUTTON);
				DELETE_ALERT_OK_BUTTON.click();
				Assert.assertTrue(DELETE_RESULT_TEXT.getText().contains("Contact Deleted Successfully"),
						"delete of account failed");

			}

		}
	}

	public void verifyCustomerHasBeenDeleted(String enteredName) {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			Assert.assertTrue(!name.contains(enteredName), "failed to delete");
		}

	}

	public void searchDeletedCustomer(String enteredName) {
		SEARCH_CUSTOMER_FIELD.sendKeys(enteredName);
		waitForCompleteLoad(driver, 10, SEARCH_RESULT_ROW );
	}

}
