package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FlightBookingTest {

	static WebDriver driver;
	public static String websiteUrl = "https://www.cleartrip.com/";
	public static String chromeDriverPath =

			"C:\\Users\\RB\\Documents\\GitHub\\gitrepo\\codingRound\\chromedriver.exe";
	// System.getProperty("user.home") + "\\chromedriver.exe";
	// ******Flight Booking**********//
	@FindBy(id = "travellersOnhome")
	public static WebElement travellerSelection;
	@FindBy(id = "OneWay")
	public static WebElement OneWay;
	@FindBy(id = "FromTag")
	public static WebElement FromTag;
	@FindBy(xpath = "//input[@id='ToTag']")
	public static WebElement toTag;
	@FindBy(id = "SearchBtn")
	public static WebElement SearchBtn;
	@FindBy(className = "SearchBtn")
	public static WebElement searchSummary;
	@FindBy(id = "ui-id-1")
	public static WebElement ui_id_1;
	@FindBy(id = "ui-id-2")
	public static WebElement ui_id_2;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	public static WebElement datepicker;

	public static void OneWay() {
		OneWay.click();
	}

	public static void FromTag() {
		FromTag.clear();
		FromTag.sendKeys("Bangalore");
	}

	public static void toTag() {
		toTag.clear();
		toTag.sendKeys("Delhi");
	}

	public static void SearchBtn() {
		SearchBtn.click();
	}

	@Test
	public static void testThatResultsAppearForAOneWayJourney() {

		OneWay();

		FromTag();
		// wait for the auto complete options to appear for the origin

		waitFor(2);
		List<WebElement> originOptions = ui_id_1.findElements(By.tagName("li"));
		originOptions.get(0).click();

		toTag();

		// wait for the auto complete options to appear for the destination

		waitFor(2);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = ui_id_2.findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		datepicker.click();
		// all fields filled in. Now click on search
		SearchBtn();
		waitFor(5);
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.id("SearchBtn")));

	}

	public static boolean isElementPresent(By by) {
		try {
			driver.findElements(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void waitFor(int durationInSeconds) {
		try {
			Thread.sleep(durationInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	@BeforeMethod
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		;
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(websiteUrl);
		PageFactory.initElements(driver, FlightBookingTest.class);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			 driver.quit();
		}
	}

}
