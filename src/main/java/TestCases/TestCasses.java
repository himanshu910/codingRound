package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.BaseClass;
import test.FlightBookingTest;
import test.HotelBookingTest;
import test.SignInTest;

public class TestCasses extends BaseClass {

	
	@Test(priority = 0)
	public static void shouldThrowAnErrorIfSignInDetailsAreMissingTest() throws InterruptedException {

		SignInTest.Yourtrips();
		SignInTest.SignIn();
		SignInTest.signInButton();
		SignInTest.errorsmsg();
	}
	
	@Test
	public static void testThatResultsAppearForAOneWayJourney() {

		FlightBookingTest.OneWay();

		FlightBookingTest.FromTag();
		// wait for the auto complete options to appear for the origin

		FlightBookingTest.waitFor(2);
		List<WebElement> originOptions = FlightBookingTest.ui_id_1.findElements(By.tagName("li"));
		originOptions.get(0).click();

		FlightBookingTest.toTag();

		// wait for the auto complete options to appear for the destination

		FlightBookingTest.waitFor(2);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = FlightBookingTest.ui_id_2.findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		FlightBookingTest.datepicker.click();
		// all fields filled in. Now click on search
		FlightBookingTest.SearchBtn();
		FlightBookingTest.waitFor(5);
		// verify that result appears for the provided journey search
		Assert.assertTrue(FlightBookingTest.isElementPresent(By.id("SearchBtn")));

	}
	
	@Test
	public void shouldBeAbleToSearchForHotels() {

		HotelBookingTest.hotelLink();
		HotelBookingTest.localityTextBox();
		HotelBookingTest.checkdate(24);
		HotelBookingTest.travellerSelection();
		HotelBookingTest.searchButton();

	}
	
}
