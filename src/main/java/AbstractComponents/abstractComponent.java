package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webAutomation.pageobject.cartPage;

public class abstractComponent {
	
	 WebDriver driver;
	 @FindBy(css = "[routerlink*='cart']")
		WebElement cartHeader_Btn;

	public abstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForwebelementtoAPpear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForwebelementtoDisAppear(WebElement  ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public cartPage gotoCartPage() {
		cartHeader_Btn.click();
		cartPage cp = new cartPage(driver);
		return cp;
	}
}
