package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Waiters;

public class IndexPage {
	private By womanLink;
	private WebDriver driver;
	private Waiters waiter;
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		womanLink = By.linkText("Women");
		waiter = new Waiters(driver,5);
		
	}
	
	public void clickWomenLink() {
		/*WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement womanButton = wait.until(ExpectedConditions.elementToBeClickable(womanLink));*/
		//Waiters waiter = new Waiters(driver,5);
		WebElement womanButton = waiter.waitForClickable(womanLink);
		//driver.findElement(womanLink).click();
		womanButton.click(); //TODO: why this if you can do something else
	}
	
	
	
}
