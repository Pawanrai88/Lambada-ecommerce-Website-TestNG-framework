package PageObjectPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePagePackage.BasePage;
import Utilities.CommonActions;

public class ProductPage extends BasePage{
	
	CommonActions ca =new CommonActions(driver);
	
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(css="h1.h4")
	WebElement pageHeader;
	
	private @FindBy(xpath="//div[@class='carousel-inner']")
	List<WebElement> item;
	
	private @FindBy(xpath="//h4[@class='title']")
	List<WebElement>  itemTitle;
	
	private @FindBy(xpath="//button[contains(@class,'btn btn-cart cart-')]")
	List<WebElement>  addToCartBtn;
	
	private @FindBy(xpath="//p[contains(text(),'Success: You have added')]")
	WebElement successMsg1;
	
	private @FindBy(xpath="//p[contains(text(),'Success: You have added')]/a")
	WebElement successMsg2;
	
	private @FindBy(xpath="//a[@class='btn btn-secondary btn-block']")
	WebElement checkoutBtn;
	
	
	public String addItemToCart(String itemToSelect) throws InterruptedException {
		//get Title of Product page 
		String productPageTitle=pageHeader.getText();
		System.out.println(productPageTitle);
		
		// iterate over the products and select your item
		for(int i=0;i<=item.size();i++) {
			String itemOnIndex=itemTitle.get(i).getText();
			if(itemOnIndex.equalsIgnoreCase(itemToSelect)) {
				ca.jsClick(addToCartBtn.get(i));
				break;
			}
		} 
		 Thread.sleep(2000);
		 String msg1 =successMsg1.getText().trim();
		 String final_Text =msg1.replace("\n"," ");
		 Thread.sleep(3000);
		 return final_Text;		
	}
	
	public CheckoutPage navigateToCheckoutPage() throws InterruptedException {
		checkoutBtn.click();
		Thread.sleep(1000);
		return new CheckoutPage(driver);
		
	}

}
