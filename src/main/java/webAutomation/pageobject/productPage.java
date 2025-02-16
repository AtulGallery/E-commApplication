package webAutomation.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractComponent;

public class productPage extends abstractComponent {

	WebDriver driver;
	WebElement prod;

	public productPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class, 'mb-3')]")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement addCountry_btn;
	

	By productsBy = By.cssSelector(".mb-3");
	By cartButton = By.xpath("//div[@class='card-body']/button[2]");
	By toastmessage = By.cssSelector("#toast-container");

	By cartmessage = By.cssSelector("[routerlink*='cart']");

	public List<WebElement> getProductList() {
		waitForwebelementtoAPpear(productsBy);
		return products;
	}

	/*
	 * public List<WebElement> getCartProducts() {
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 * 
	 * return cartProducts; }
	 */

	public WebElement getProductByname(String productname) {
		WebElement prod = getProductList().stream().filter(
				product -> product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals(productname))
				.findFirst().orElse(null);
		return prod;

	}

	public void addProducttoCart(String productname) {
		WebElement prod = getProductByname(productname);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		prod.findElement(cartButton).click();
		//js.executeScript("arguments[0].click();", cartButton);
		waitForwebelementtoAPpear(toastmessage);
		waitForwebelementtoDisAppear(spinner);
		waitForwebelementtoAPpear(cartmessage);
		cartPage cp = new cartPage(driver);
		

		
	}
	


}
