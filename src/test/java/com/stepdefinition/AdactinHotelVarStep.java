package com.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinHotelVarStep {

	WebDriver driver;

	@Given("User is on the Adactin Page")
	public void user_is_on_the_Adactin_Page() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();

	}

	@When("User should perform login {string} , {string}")
	public void user_should_perform_login(String username, String password) {
		WebElement txtusername = driver.findElement(By.id("username"));
		txtusername.sendKeys(username);

		WebElement txtpass = driver.findElement(By.id("password"));
		txtpass.sendKeys(password);

		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();


	}
	@When("User should search hotels {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_should_search_hotels(String location, String Hotels, String RoomType, 
			String room_nos, String datepick_in, String datepick_out, String adult_room, String child_room) throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement locatehotel = driver.findElement(By.id("location"));
		locatehotel.sendKeys(location);

		WebElement selHotel = driver.findElement(By.id("hotels"));
		selHotel.sendKeys(Hotels);

		WebElement roomType = driver.findElement(By.id("room_type"));
		roomType.sendKeys(RoomType);

		WebElement roomNo = driver.findElement(By.id("room_nos"));
		roomNo.sendKeys(room_nos);

		WebElement pickIn = driver.findElement(By.id("datepick_in"));
		pickIn.clear();
		pickIn.sendKeys(datepick_in);

		WebElement pickOut = driver.findElement(By.id("datepick_out"));
		pickOut.clear();
		pickOut.sendKeys(datepick_out);

		WebElement adultRoom = driver.findElement(By.id("adult_room"));
		adultRoom.sendKeys(adult_room);

		WebElement childRoom = driver.findElement(By.id("child_room"));
		childRoom.sendKeys(child_room);

		WebElement btnSearch = driver.findElement(By.id("Submit"));
		btnSearch.click();
	}

	@When("User should select hotel")
	public void user_should_select_hotel() {

		WebElement btnRadio = driver.findElement(By.id("radiobutton_0"));
		btnRadio.click();

		WebElement btnContn = driver.findElement(By.id("continue"));
		btnContn.click();
	}

	@When("User should Book hotel {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_should_Book_hotel(String firstN, String lastN, String address, String ccNumber, String ccType, String expiryMon, String expiryYear,  String cvvNum) {
		WebElement firstName = driver.findElement(By.id("first_name"));
		firstName.sendKeys(firstN);

		WebElement lastName = driver.findElement(By.id("last_name"));
		lastName.sendKeys(lastN);

		WebElement addAddress = driver.findElement(By.id("address"));
		addAddress.sendKeys(address);

		WebElement ccNum = driver.findElement(By.id("cc_num"));
		ccNum.sendKeys(ccNumber);

		WebElement enterCCtype = driver.findElement(By.id("cc_type"));
		enterCCtype.sendKeys(ccType);

		WebElement expiryMonth = driver.findElement(By.id("cc_exp_month"));
		expiryMonth.sendKeys(expiryMon);

		WebElement expYear = driver.findElement(By.id("cc_exp_year"));
		expYear.sendKeys(expiryYear);

		WebElement enterCVV = driver.findElement(By.id("cc_cvv"));
		enterCVV.sendKeys(cvvNum);

		WebElement btnBook = driver.findElement(By.id("book_now"));
		btnBook.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("User should print the Order ID")
	public void user_should_print_the_Order_ID() throws InterruptedException {
		
		WebElement orderID = driver.findElement(By.id("order_no"));
		String attribute = orderID.getAttribute("value");
		System.out.println(attribute);
		driver.close();
	}
}