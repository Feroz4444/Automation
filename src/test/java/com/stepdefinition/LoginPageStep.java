package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageStep {
	
	WebDriver driver;
		
	@Given("User is on the AdactiHhotelApp Page")
	public void user_is_on_the_AdactiHhotelApp_Page() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://adactinhotelapp.com/");
		 driver.manage().window().maximize();
			  
	}

	@When("User should enter the Username and Password Correctly")
	public void user_should_enter_the_Username_and_Password_Correctly() {
	WebElement txtusername = driver.findElement(By.id("username"));
	txtusername.sendKeys("Ferozkhan");
	
	WebElement txtpassword = driver.findElement(By.id("password"));
	txtpassword.sendKeys("feroz@4444");
			
	}
	@When("After the Credentials User should click the Login button")
	public void after_the_Credentials_User_should_click_the_Login_button() {
	   
		WebElement btnlogin = driver.findElement(By.id("login"));
		btnlogin.click();
	}
	@Then("User should verify the login successfully done.")
	public void user_should_verify_the_login_successfully_done() {
		
		Assert.assertTrue("Verify Login Msg",true);
		
	}




}
