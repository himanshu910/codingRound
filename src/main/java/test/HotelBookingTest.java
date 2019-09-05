package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseClass {


	@FindBy(linkText = "Hotels")
	public static WebElement hotelLink;
	@FindBy(id = "Tags")
	public static WebElement localityTextBox;
	@FindBy(id = "SearchHotelsButton")
	public static WebElement searchButton;
	@FindBy(id = "travellersOnhome")
	public static WebElement travellerSelection;
	@FindBy(xpath = "//input[starts-with(@id, 'ui-id')]")
	public static WebElement ui_id_1;
	@FindBy(id = "Tags")
	public static WebElement Tags;

	public static void checkdate(int day) {
		String checkinxpath = "//a[contains(text(),'" + day + "')]";

		driver.findElement(By.xpath(checkinxpath)).click();

		waitFor(2);
		
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-active")).click();
		
	}

	public static void hotelLink() {
		hotelLink.click();
	}

	public static void localityTextBox() {
		localityTextBox.sendKeys("Indiranagar, Bangalore, Karnataka, India");
		waitFor(2);
		WebElement element_move = driver.findElement(By.xpath("//*[. = 'Indiranagar, Bangalore, Karnataka, India']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element_move).click().build().perform();

	}

	public static void travellerSelection() {
		selectByVisibleValue(travellerSelection, "1 room, 2 adults");
	}

	public static void searchButton() {
		searchButton.click();
	}

	public static void selectByVisibleValue(WebElement we, String value) {
		Select select = new Select(we);
		select.selectByVisibleText(value);
	}

	public static void waitFor(int durationInSeconds) {
		try {
			Thread.sleep(durationInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	public HotelBookingTest(WebDriver driver){
		this.driver=driver;
		}




}
