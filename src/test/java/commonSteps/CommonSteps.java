package commonSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.IndexPage;
import pages.WomenPage;

public class CommonSteps {
	protected WebDriver driver;
	protected IndexPage indexPage;
	protected WomenPage womenPage;
	@BeforeClass
	public void beforeAll() {
		System.out.println("Antes de la clase...");
	}
	
	@AfterClass
	public void afterAll() {
		System.out.println("Despues de la clase...");
	}
	
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
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
