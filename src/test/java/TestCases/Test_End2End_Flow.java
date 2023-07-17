package TestCases;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import PageObjectPages.ProductPage;
import PageObjectPages.CheckoutPage;
import PageObjectPages.HomePage;
import PageObjectPages.OrderConfirmationPage;
import PageObjectPages.OrderPlacedPage;
import PageObjectPages.RegistrationPage;

public class Test_End2End_Flow extends BaseTest {
	
	//String[][] productToOrder = {{"Palm Treo Pro"},{"MacBook Pro"}};
	
	@BeforeClass
	public void lunchBrowser() {
		BaseTest bt=new BaseTest();
		bt.setUp();	
		
	}
	
	@Test(priority=1)
	public void test_HomePage() {
		HomePage home=new HomePage(driver);
		String result=home.pageTittle();
		Assert.assertEquals(result,"Your Store");
	}
	
	@Test(priority=2,dependsOnMethods="test_HomePage")
	public void test_UserRegistration() throws InterruptedException {
		HomePage home=new HomePage(driver);
		RegistrationPage resgis= home.openRegistrationPage();
		home.pageTittle();
		String result_Tittle=resgis.getTitle();
		Assert.assertEquals(result_Tittle, "Register Account");
		String result_AccountCreation=resgis.newUserRegistration();
		Assert.assertEquals(result_AccountCreation,"Your Account Has Been Created!");
		String result_MyAccountHeader=resgis.navigateToMyAccount();
		Assert.assertEquals(result_MyAccountHeader,"My Account");
		
	}
	
	@Test(priority=3,dependsOnMethods="test_UserRegistration",dataProvider="getProductName")
	public void test_AddProductToCart(String productName, String itemToSelect) throws InterruptedException {
		ProductPage pp= new ProductPage(driver);
		HomePage home=new HomePage(driver);
		home.shopByCategory(productName);
		String result_AddToCartMsg=pp.addItemToCart(itemToSelect);
		System.out.println(result_AddToCartMsg);
		Assert.assertEquals(result_AddToCartMsg,"Success: You have added "+itemToSelect+" to your shopping cart !");
		
	}
	
   @Test(priority=4,dependsOnMethods="test_AddProductToCart")
	public void test_CheckoutPageFunctionality() throws InterruptedException{
		ProductPage pp= new ProductPage(driver);
		CheckoutPage chkp= pp.navigateToCheckoutPage();
		OrderConfirmationPage oc=chkp.getBillingDetails();
		String result_PageHeader=chkp.verifyPageHeader();
  		Assert.assertEquals(result_PageHeader,"Confirm Order");
		
	}
   
   @Test(priority=5,dependsOnMethods="test_CheckoutPageFunctionality")
  	public void test_OrderConfirmationPage() throws InterruptedException{
	   OrderConfirmationPage oc=new OrderConfirmationPage(driver);
  		OrderPlacedPage opp=oc.placeOrder();
  		String result_Msg=opp.verifySuccessMsg();
  		Assert.assertEquals(result_Msg, "Your order has been placed!");
  		
  		
  		
  	}
	
	
	@DataProvider(name="getProductName")
	public Object[][] getProduct() {
		
		return new Object [][] 
				{
			{"Cameras","Palm Treo Pro"},
			{"Laptops & Notebooks", "MacBook Pro"}
			
				};
	}

}
