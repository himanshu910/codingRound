package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.BaseClass;
import test.FlightBookingTest;
import test.HotelBookingTest;
import test.SignInTest;

public class TestCasses extends BaseClass {

	
	@Test(priority = 0)
	public static void shouldThrowAnErrorIfSignInDetailsAreMissingTest() throws InterruptedException {
		SignInTest sit = PageFactory.initElements(driver, SignInTest.class);
		sit.Yourtrips();
		sit.SignIn();
		sit.signInButton();
		sit.errorsmsg();
	}
	
	@Test
	public static void testThatResultsAppearForAOneWayJourney() {
		FlightBookingTest fbt = PageFactory.initElements(driver, FlightBookingTest.class);
		fbt.OneWay();

		fbt.FromTag();
		// wait for the auto complete options to appear for the origin

		fbt.waitFor(2);
		List<WebElement> originOptions = fbt.ui_id_1.findElements(By.tagName("li"));
		originOptions.get(0).click();

		fbt.toTag();

		// wait for the auto complete options to appear for the destination

		fbt.waitFor(2);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = fbt.ui_id_2.findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		fbt.datepicker.click();
		// all fields filled in. Now click on search
		fbt.SearchBtn();
		fbt.waitFor(5);
		// verify that result appears for the provided journey search
		Assert.assertTrue(fbt.isElementPresent(By.id("SearchBtn")));

	}
	
	@Test
	public void shouldBeAbleToSearchForHotels() {
		HotelBookingTest hbt = PageFactory.initElements(driver, HotelBookingTest.class);
		hbt.hotelLink();
		hbt.localityTextBox();
		hbt.checkdate(24);
		hbt.travellerSelection();
		hbt.searchButton();

	}
	
}
