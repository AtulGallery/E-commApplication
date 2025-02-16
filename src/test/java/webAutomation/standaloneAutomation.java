package webAutomation;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import webAutomation.pageobject.LandingPage;
import webAutomation.pageobject.cartPage;
import webAutomation.pageobject.checkoutPage;
import webAutomation.pageobject.confirmationPage;
import webAutomation.pageobject.productPage;

public class standaloneAutomation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName = "IPHONE 13 PRO";
		String countryname = "india";
		String expectedorder = "THANKYOU FOR THE ORDER.";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 WebDriver driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage lp = new LandingPage(driver);
		lp.gotoURL();
		productPage prp = lp.getLogin("atulpathakdec@gmail.com", "Atul1234");

		List<WebElement> products = prp.getProductList();
		prp.getProductByname(productName);
		prp.addProducttoCart(productName);
		cartPage cp = prp.gotoCartPage();

		Boolean match = cp.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkoutPage check = cp.gotoCheckout();
		check.selectCountry(countryname);
		confirmationPage confirm = check.submitOrder();
		String actualorder = confirm.getConfirmationmessage();

		Assert.assertEquals(actualorder, expectedorder);
	// if the webelement is found but hidden under css then use javascript executor
		
		

	}

}
