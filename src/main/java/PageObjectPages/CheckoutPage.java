package PageObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import BasePagePackage.BasePage;
import Utilities.CommonActions;

public class CheckoutPage extends BasePage {
	CommonActions ca =new CommonActions(driver);
	String price;
	Faker fake=new Faker();
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(css="input#input-payment-firstname")
	WebElement firstName;
	
	private @FindBy(css="input#input-payment-lastname")
	WebElement lastName;
	
	private @FindBy(css="input#input-payment-lastname")
	WebElement email;
	
	private @FindBy(css="input#input-payment-email")
	WebElement telephone;
	
	private @FindBy(css="input#input-payment-password")
	WebElement password;
	
	private @FindBy(css="input#input-payment-confirm")
	WebElement Cnfrmpassword;
	
	private @FindBy(css="input#input-payment-address-1")
	WebElement address1;
	
	private @FindBy(css="input#input-payment-city")
	WebElement city;
	
	private @FindBy(css="input#input-payment-postcode")
	WebElement zipCode;
	
	private @FindBy(css="#input-payment-country")
	WebElement country;
	
	private @FindBy(css="#input-payment-zone")
	WebElement zone;
	
	private @FindBy(xpath="//div[@class='custom-control custom-checkbox'][2]")
	WebElement checkboxPrivacy;
	

	private @FindBy(xpath="//label[@class='custom-control-label'and@for='input-agree']")
	WebElement termsNConditions;
	
	private @FindBy(css="button.btn.btn-lg.btn-block.btn-primary")
	WebElement continueBtn;
	
	private @FindBy(xpath="(//table[@class='table']/tbody/tr)[1]/td[4]")
	WebElement unitPrice;
	
	private @FindBy(css="h1.page-title.mb-3")
	WebElement orderConfrmPageHeader;
	
	
	public OrderConfirmationPage getBillingDetails() throws InterruptedException {
		
		firstName.sendKeys(fake.name().firstName());
		lastName.sendKeys(fake.name().lastName());
		address1.sendKeys(fake.address().streetAddress());
		city.sendKeys(fake.address().city());
		zipCode.sendKeys(fake.address().zipCode());
		ca.selectByVisibleText(country, "Canada");
		ca.selectByVisibleText(zone,"British Columbia");
		ca.scrollToElement(termsNConditions);
		termsNConditions.click();
		Thread.sleep(2000);
		ca.scrollToElement(continueBtn);
		continueBtn.click();
		return new OrderConfirmationPage(driver);
		
		
	}
	
	public String verifyPageHeader() {
		
		return orderConfrmPageHeader.getText();
	}

	

	
	
	
	
	
	
	
	
	
	

}
