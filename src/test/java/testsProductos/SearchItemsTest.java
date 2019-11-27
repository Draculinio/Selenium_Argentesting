package testsProductos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonSteps.CommonSteps;
import helpers.Helpers;

public class SearchItemsTest extends CommonSteps{
	
	
	private Helpers helper = new Helpers();
	
	
	
	@Test()
	public void clickWomen() {
		List<WebElement> myDivs = driver.findElements(By.tagName("div"));
		myDivs.get(2).click();
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='price product-price']"));
		String title = driver.getTitle();
	}
	
	@Test(description="CP-1254", enabled = false)
	public void searchNoResults() {
		
		driver.findElement(By.id("search_query_top")).sendKeys("something");
		driver.findElement(By.id("search_query_top")).sendKeys(Keys.TAB);
		//driver.findElement(By.name("submit_search")).click();
		helper.waitForTime(3000);
		String textResult = driver.findElement(By.cssSelector("p[class = 'alert alert-warning']")).getText();
		Assert.assertTrue(textResult.contains("No results were found for your search"),"Se esperaba el texto: No results were found for your search y se encontro "+ textResult);
		helper.waitForTime(3000);
	}
	
	@Test(enabled = false)
	public void findClothes() {
		driver.findElement(By.id("search_query_top")).sendKeys("clothes");
		driver.findElement(By.name("submit_search")).click();
		
	}
	
	@Test(description = "ejercicio", enabled = false)
	public void ejercicioTarea() {
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Argentesting");
		driver.findElement(By.id("search_button_homepage")).click();
		driver.findElement(By.id("r1-0")).click();
		String text = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div/h1")).getText();
		Assert.assertTrue(text.contains("Congreso Argentino de Testing"));
	}
}
