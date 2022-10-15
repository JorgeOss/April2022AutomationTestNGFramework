package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
WebDriver driver;

public void DropDownPage(WebDriver Driver) {
	this.driver = driver;
}
	
//	Web Elements
	
	@FindBy(how = How.NAME, using = "due_month")
	WebElement MonthDropDown;
	
	public List<String> getListOfDropDown() {
		List<String> actualDropdownValues = new ArrayList<String>();
		Select dropdown = new Select(MonthDropDown);
		List<WebElement> dropdownValues = dropdown.getOptions();
		for (int i = 0; i < dropdownValues.size(); i++) {
			actualDropdownValues.add(i, dropdownValues.get(i).getText());
		}
		return actualDropdownValues;
	}


}
