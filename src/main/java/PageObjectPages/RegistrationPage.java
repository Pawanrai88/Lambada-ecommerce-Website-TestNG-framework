package PageObjectPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import BasePage.BasePage;

public class RegistrationPage extends BasePage {
  
	private static final Faker fake=new Faker();
	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	private  @FindBy(css="input#input-firstname")
	WebElement firstName;
	
	private @FindBy(css="input#input-lastname")
	 WebElement lastName;
	
	private @FindBy(css="input#input-email")
	 WebElement email;
	
	private @FindBy(css="input#input-telephone")
	 WebElement telephone;
	
	private @FindBy(css="input#input-password")
	 WebElement password;
	
	private @FindBy(css="input#input-confirm")
	 WebElement confirmPassword;
	
	private @FindBy(css="input.custom-control-input#input-newsletter-no")
	 WebElement subscribeRadio;
	
	private @FindBy(xpath="//label[@for='input-agree']")
	 WebElement checkboxPrivacyPolicy;
	
	private @FindBy(css="input.btn.btn-primary")
	 WebElement continueBtn;
	
	private @FindBy(css="h1.page-title.my-3")
	 WebElement successMsg;
	
	
	/*	private @FindBy(xpath="//a[@class='icon-left both text-reset']")
	WebElement shopByBtn;
	
	private @FindBy(xpath="(//ul[@class='navbar-nav vertical'])[1]/li")
	List<WebElement> shopByCtg;
	 */
	
	private @FindBy(xpath="//div[@class='buttons mb-4']/a")
	WebElement contBtn;
	
	private @FindBy(css="h2.card-header.h5")
	WebElement myAcctountPageHead;
	
	//continue button - 
	
	// my account page header = 
	public String getTitle() {
		
		return driver.getTitle();	 
	}
	
	public String newUserRegistration() throws InterruptedException {
		firstName.sendKeys(fake.name().firstName());
		lastName.sendKeys(fake.name().lastName());
		email.sendKeys(fake.internet().emailAddress());
		telephone.sendKeys(fake.phoneNumber().phoneNumber());
		password.sendKeys("Test@1234");
		confirmPassword.sendKeys("Test@1234");
		//subscribeRadio.click();
		checkboxPrivacyPolicy.click();
		continueBtn.click();
		Thread.sleep(3000);
		
		try {
		return successMsg.getText();
		
		}
		catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	public String navigateToMyAccount() throws InterruptedException {
		contBtn.click();
		Thread.sleep(2000);
		return myAcctountPageHead.getText();
		
	}
	/*public ProductPage navigateToShopByCatg(String productname) {
		
		shopByBtn.click();
	
		for(int i=0;i<=shopByCtg.size();i++) {
			String product = shopByCtg.get(i).getText();
		if(product.equalsIgnoreCase(productname)) {
			shopByCtg.get(i).click();
		}
		
	} 
		return new ProductPage(driver);
		
		
	}  */
	
}
