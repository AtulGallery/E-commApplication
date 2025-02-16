package webAutomation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractComponent;

public class LandingPage extends abstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement emailID1 = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement emailID;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "login")
	WebElement submit_btn;

	public productPage getLogin(String email,String passwrd) {
		emailID.sendKeys(email);
		password.sendKeys(passwrd);
		submit_btn.click();
		productPage prp = new productPage(driver);
		
		/*
		 * // if the webelement is found but hidden under css then use javascript
		 * executor
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * 
		 * js.executeScript(null, null)
		 */
		
		return prp;
	}
	
	
	public void gotoURL() {
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
	}
}
