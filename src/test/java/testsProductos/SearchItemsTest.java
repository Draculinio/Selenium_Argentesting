package testsProductos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;

public class SearchItemsTest {
	
	private WebDriver driver;
	private Helpers helper = new Helpers();
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
	
	@Test()
	public void clickWomen() {
		//driver.findElements(By.tagName("img"));
		List<WebElement> myDivs = driver.findElements(By.tagName("div"));
		myDivs.get(2).click();
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='price product-price']"));
		String title = driver.getTitle();
	}
	
	@Test(description="CP-1254", enabled = false)
	public void searchNoResults() {
		
		driver.findElement(By.id("search_query_top")).sendKeys("something");
		driver.findElement(By.name("submit_search")).click();
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
