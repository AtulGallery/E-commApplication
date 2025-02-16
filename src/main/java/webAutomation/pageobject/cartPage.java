package webAutomation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import AbstractComponents.abstractComponent;

public class cartPage extends abstractComponent {
WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}
	@FindBy(css = ".totalRow button")
	WebElement checkOut_btn;
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	
	
	
	
	public boolean verifyProductDisplay(String productname) {
		boolean match = cartProducts.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productname));
	
		
		return match;
	}
	
	public checkoutPage gotoCheckout() {
		checkOut_btn.click();
		return new checkoutPage(driver);
		
	}
	

}
