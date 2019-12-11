package commonSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import helpers.Screenshots;
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
		String driverByOs = "";
		System.out.println(System.getProperty("os.name"));
		if(System.getProperty("os.name").equals("Windows 10")) {  //tambien se puede .contains("Windows") para que se use con cualquier winows
			driverByOs= "Drivers/chromedriver.exe";
		}else {
			driverByOs= "Drivers/chromedriver";
		}
		//Reporter.log("Opening the browser");
		System.setProperty("webdriver.chrome.driver", driverByOs);
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--incognito");
		//options.addArguments("--start-maximized");
		options.addArguments("--window-size=600,420");
		driver = new ChromeDriver(options);
		driver.navigate().to("http://automationpractice.com/index.php");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(400,320));
		//driver.manage().window().setPosition(new Point(500,700));
		
		indexPage = new IndexPage(driver);
		womenPage = new WomenPage(driver);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		String resultado;
		if(result.getStatus()==1) {
			resultado = "PASO";
		}else {
			resultado = "FALLO";
		}
		System.out.println("El test "+ result.getMethod().getDescription()+" resulto: "+resultado);
		if(!result.isSuccess()) {
			//this.takeScreenshot(result.getMethod().getDescription());
			Screenshots.takeScreenshot(result.getMethod().getDescription(), driver);
		}
		driver.close();
		driver.quit();
	}
	
	
}
