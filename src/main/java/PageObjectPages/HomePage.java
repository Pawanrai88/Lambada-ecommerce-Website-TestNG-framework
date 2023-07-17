package PageObjectPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePage.BasePage;
import Utilities.CommonActions;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	} 
	
	private @FindBy(xpath="//li[@class='nav-item dropdown dropdown-hoverable'][2]")
	WebElement myAccountDropdown;
	
	private @FindBy(linkText="Register")
	WebElement registerPageLink;
	
	private @FindBy(xpath="//a[@class='icon-left both text-reset']")
	WebElement shopByBtn;
	
	private @FindBy(xpath="(//ul[@class='navbar-nav vertical'])[1]/li")
	List<WebElement> shopByCtg;
	
	public RegistrationPage openRegistrationPage() {
		
		CommonActions ca = new CommonActions(driver);
		ca.moveToElement(myAccountDropdown);;
		registerPageLink.click();
		return new RegistrationPage(driver);
		
	}
	
     public String pageTittle() {
		
		return driver.getTitle();
	}

     public ProductPage shopByCategory(String productName) throws InterruptedException {
 		shopByBtn.click();
 		Thread.sleep(2000);
 		for(int i=0;i<=shopByCtg.size();i++) {
 			String product = shopByCtg.get(i).getText();
 			if(product.equalsIgnoreCase(productName)) {
 				shopByCtg.get(i).click();
 				break;
 			}
 			
 		}
 		Thread.sleep(1000);
 		return new ProductPage(driver);
 	}
}
