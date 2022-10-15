package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
WebDriver driver;

public CategoryPage(WebDriver driver) {
	this.driver = driver;
}
// Web Elements
@FindBy(how = How.XPATH, using = "//input[@name='categorydata']")
	WebElement CategoryTextBox;

@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
WebElement CategoryButton;

@FindBy(how = How.XPATH, using = "//*[contains(text(),'The category you want to add already exists')]")
WebElement ReapeatItCategory;




//Interacting with the Web Elements



public void clickCategoryCheckBox(String Skylark) throws InterruptedException {
	CategoryTextBox.sendKeys(Skylark);
	Thread.sleep(2000);
	CategoryButton.click();
}


public void waitTime() {
	waitForElement(ReapeatItCategory, driver);
}

public void waitForElement(WebElement element, WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(element));
}

public boolean isDuplicateMessageDisplayed() {
	try {
		waitTime();
		return true;
	} catch (Exception e) {

	}
	return false;
}


	
}
