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

public class SignInTest extends BaseClass {

	
	// ****** Sign In**********//
	
	//fixed css of Yourtrips
	@FindBy(css = "#userAccountLink")
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



	@Test(priority = 0)
	public static void shouldThrowAnErrorIfSignInDetailsAreMissingTest() throws InterruptedException {

		Yourtrips();
		SignIn();
		signInButton();
		errorsmsg();
	}



}
