package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {

	static WebDriver driver;
	public static String websiteUrl = "https://www.cleartrip.com/";
	public static String chromeDriverPath =

			"C:\\Users\\RB\\Documents\\GitHub\\gitrepo\\codingRound\\chromedriver.exe";
	// System.getProperty("user.home") + "\\chromedriver.exe";

	// ****** Sign In**********//
	@FindBy(xpath = "//span[@class='span span19 truncate']")
	public static WebElement Yourtrips;
	@FindBy(xpath = "//input[@title='Sign In']")
	public static WebElement SignIn;
	@FindBy(xpath = "//button[@id='signInButton']")
	public static WebElement signInButton;
	@FindBy(xpath = "//div[@id='errors1']/span")
	public static WebElement errors1;

	public static void Yourtrips() {
		Yourtrips.click();
	}

	public static void SignIn() {
		SignIn.click();
	}

	public static void signInButton() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modal_window']")));
		signInButton.click();
		;
	}

	public static void errorsmsg() {
		String errorsmsg = errors1.getText();
		Assert.assertTrue(errorsmsg.contains("There were errors in your submission"));
	}

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
		PageFactory.initElements(driver, SignInTest.class);
	}

	@Test(priority = 0)
	public static void shouldThrowAnErrorIfSignInDetailsAreMissingTest() throws InterruptedException {

		Yourtrips();
		SignIn();
		signInButton();
		errorsmsg();
	}

	@AfterMethod
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
