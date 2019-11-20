package testsProductos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.IndexPage;
import pages.WomenPage;

public class WomenSearchTest {
	private WebDriver driver;
	private Helpers helper = new Helpers();
	private IndexPage indexPage;
	private WomenPage womenPage;
	
	@BeforeMethod
	public void setUp() {
		//Reporter.log("Opening the browser");
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		indexPage = new IndexPage(driver);
		womenPage = new WomenPage(driver);
		indexPage.clickWomenLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test(description = "woman search by stock")
	public void womanSearchByStock() {
		Reporter.log("Looking for stock articles");
		womenPage.selectOrderByText("In stock");
		Reporter.log("Voy a intentar que true sea false");
		Assert.assertTrue(false,"El test fallo");
		
	}
	
	@Test(description = "woman search by reference")
	public void womanSearchByReference() {
		womenPage.selectOrderByValue("reference:asc");
	}
	
	@Test(description = "woman search by price lower first")
	public void womanSearchByPriceLowerFirst() {
		womenPage.selectOrderByIndex(1);
	}
	
	@Test(description = "see if elements are located")
	public void seeColorChecksLocated() {
		Reporter.log("Voy a seleccionar el color 3");
		womenPage.selectColor(3);
		Reporter.log("Ya seleccione el color 3");
	}
}