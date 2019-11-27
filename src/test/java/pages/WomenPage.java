package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WomenPage {
	private By selectProductSort;
	private By colorSelection;
	private WebDriver driver;
	
	private By category;
	
	public WomenPage(WebDriver driver) {
		this.driver = driver;
		selectProductSort = By.id("selectProductSort");
		colorSelection = By.xpath("//input[@class='color-option  ']");
		
		category = By.xpath("//span[@class='cat-name']");
	}
	
	public void selectOrderByText(String text) {
		Select order = new Select(driver.findElement(selectProductSort));
		order.selectByVisibleText(text);
	}
	
	public void selectOrderByValue(String value) {
		Select order = new Select(driver.findElement(selectProductSort));
		order.selectByValue(value);
	}
	
	public void selectOrderByIndex(int index) {
		Select order = new Select(driver.findElement(selectProductSort));
		order.selectByIndex(index);
	}
	
	public void selectColor(int color) {
		List<WebElement> colorElements = driver.findElements(colorSelection);
		/*for(int i=0;i<colorElements.size();i++) {
			System.out.println("Element "+ colorElements.get(i).getAttribute("id"));
		}*/
		colorElements.get(color).click();
		
	}
	
	public String getCategoryText() {
		return driver.findElement(category).getText();
	}
	
}
