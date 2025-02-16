package webAutomation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractComponent;

public class checkoutPage extends abstractComponent {
WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country_btn;
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement submit_btn;
	
	
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectingCountry_btn;
	
	By cart_visibility = By.cssSelector(".ta-results");
	
	  public void selectCountry(String countryname) { 
		  Actions act = new Actions(driver); 
		  act.sendKeys(country_btn, countryname).build().perform();
		  waitForwebelementtoAPpear(cart_visibility);
		  selectingCountry_btn.click();
	  }
	  public confirmationPage submitOrder() {
		  submit_btn.click();
		  return new confirmationPage(driver) ;
	  }
	  
	  
}
