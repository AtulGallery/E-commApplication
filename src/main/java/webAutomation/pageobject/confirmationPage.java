package webAutomation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractComponent;

public class confirmationPage extends abstractComponent {
	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
@FindBy(xpath ="//td/h1")
WebElement confirmationText;


public String getConfirmationmessage( ) {
return confirmationText.getText().toUpperCase();

}
}
