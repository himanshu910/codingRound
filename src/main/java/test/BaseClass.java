package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	
	static WebDriver driver;
	public static String websiteUrl = "https://www.cleartrip.com/";
	public static String chromeDriverPath =	
	System.getProperty("user.home") + "\\chromedriver.exe";
	
	
	@BeforeMethod
	public static void setup() {
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
