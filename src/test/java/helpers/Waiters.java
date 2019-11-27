package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
	private WebDriver driver;
	private WebDriverWait wait;
	public Waiters(WebDriver driver, int time){
		this.driver = driver;
		wait = new WebDriverWait(this.driver,time);
	}
	
	public WebElement waitForClickable(By element) {
		//WebDriverWait wait = new WebDriverWait(driver,5);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
