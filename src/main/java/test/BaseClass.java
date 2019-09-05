package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	
	protected static WebDriver driver;
	public static String websiteUrl = "https://www.cleartrip.com/";

	// Please change the Chrome driver path here
	public static String chromeDriverPath =	
	System.getProperty("user.home") + "\\Desktop\\New folder (3)\\codingRound\\chromedriver.exe";
	
	
	@BeforeMethod
	public static void setup() {
		
		System.out.println(chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		;
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(websiteUrl);
		PageFactory.initElements(driver, HotelBookingTest.class);
	}

	@AfterMethod
	public static void tearDown() {
		if (driver != null) {
			 driver.quit();
		}
	}
	
}
