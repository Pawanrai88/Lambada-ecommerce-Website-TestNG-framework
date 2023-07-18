package PageObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePagePackage.BasePage;

public class OrderPlacedPage extends BasePage {
	
	public OrderPlacedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(css="h1.page-title.my-3")
	WebElement successMsg;
	
	public String verifySuccessMsg() {
		
		return successMsg.getText();
		
	}

}
