package PageObjectPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePagePackage.BasePage;

public class OrderConfirmationPage extends BasePage {
	
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(xpath="(//table[@class='table table-bordered table-hover mb-0']/tbody/tr)/td[1]")
	List<WebElement> itemsInOrderScr;
	
	private @FindBy(css="button#button-confirm")
	WebElement orderPlaceBtn;
	
	public List<String> verifyProductName() {
		List<String> products=new ArrayList<String>();
		for(int i=0;i<=itemsInOrderScr.size();i++) {
			products.add(itemsInOrderScr.get(i).getText());
			break;
		}
		return products;
	}
	
	public OrderPlacedPage placeOrder() throws InterruptedException {
		
		orderPlaceBtn.click();
		Thread.sleep(2000);
		return new OrderPlacedPage(driver);
		
	}
}
