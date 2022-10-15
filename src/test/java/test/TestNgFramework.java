package test;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.CategoryListPage;
import page.CategoryPage;
import page.DropDownPage;
import util.BrowserFactory;

public class TestNgFramework {
WebDriver driver;
CategoryListPage categoryListPage;
DropDownPage dropDownPage;
CategoryPage categoryPage;
Random rand = new Random();
String CategoryAddName = "Skylark" + rand.nextInt(88);
String CategoryDuplicatedName = "Plus One" + rand.nextInt(888);
 
@BeforeMethod
public void runEverything() {
	driver = BrowserFactory.browserInit();
	categoryListPage = PageFactory.initElements(driver, CategoryListPage.class);
	dropDownPage = PageFactory.initElements(driver, DropDownPage.class);
	categoryPage = PageFactory.initElements(driver, CategoryPage.class);
}

@Test(priority = 1)
public void userShouldBeAbleToAddCategory() throws InterruptedException {
	categoryPage.clickCategoryCheckBox(CategoryAddName);
	List<String> actualList = categoryListPage.getListOf();
	Assert.assertTrue(isDataExist(CategoryAddName, actualList), "New Category Does Not Exist!");
	Thread.sleep(5000);
}
@Test(priority = 2)
public void userShouldNotBeAbleToDuplicateCategory() throws InterruptedException {
	categoryPage.clickCategoryCheckBox(CategoryDuplicatedName);
	categoryPage.clickCategoryCheckBox(CategoryDuplicatedName);
	categoryPage.isDuplicateMessageDisplayed();
	categoryPage.waitTime();
}

@Test(priority = 3)
public void dropDownShouldHaveAllMonths() throws InterruptedException {
	String[] months = {"None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	List<String> dropDownList = dropDownPage.getListOfDropDown();
	Assert.assertTrue(isDataMatch(months, dropDownList), "Values Does not Match");
	Thread.sleep(2000);
}


public static boolean isDataMatch(String[] months, List<String> dropdownList) {
	boolean dataMatch=true;
	for (int i = 0; i < dropdownList.size(); i++) {
		if (dropdownList.get(i).equalsIgnoreCase(months.toString())) {
			dataMatch = false;
		}
	}
	
	
	return dataMatch;
}




public static boolean isDataExist(String categoryName, List<String> actualList) {
	for (int i = 0; i < actualList.size(); i++) {
		if (categoryName.equalsIgnoreCase(actualList.get(i)))
			;
	}
	return true;
}

@AfterMethod
public void tearDown() {
	driver.close();
	driver.quit();
}


}
