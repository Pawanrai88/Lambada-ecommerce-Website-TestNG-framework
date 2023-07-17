package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.BasePage;

public class CommonActions extends BasePage {
	
	public CommonActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public void moveToElement(WebElement ele) {
		
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
		
	}
	
	  public void waitForElementToAppear(WebElement ele) {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) (ele)));
			
		}

	  public void waitForElementToClickable(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable((ele)));
		
	}

	  public void refreshForStaleElement(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable((ele))));
		
	}
	  
	  public void waitForElementToBeSelected(WebElement ele) {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
			wait.until((ExpectedConditions.elementToBeSelected((ele))));
			
		}  

	  public void scrolldown() {
		
		
		js.executeScript("window.scrollBy(0,250)","");
	}

	   public void scrollup() {
		
		js.executeScript("window.scrollBy(0,-250)","");
	}
	   
	      public void jsClick(WebElement ele) {
			  js.executeScript("arguments[0].click();",(ele));
	      }
	      
	      public void jsClick(List<WebElement> ele) {
			  js.executeScript("arguments[0].click();",(ele));
	      }

	     public void mouseHover(WebElement ele) {
	    	 
	    	 Actions a=new Actions(driver);
	    	 a.moveToElement(ele).build().perform();
	        
	     }
	     
         public void scrollToElement(WebElement ele) {
	    	 
	    	 Actions a=new Actions(driver);
	    	 a.scrollToElement(ele).build().perform();
	        
	     }
	     
	     public void selectByVisibleText(WebElement ele,String visibleText) {
	    	 
	    	 
	    	 Select s=new Select(ele);
	    	 s.selectByVisibleText(visibleText);
	     }
     
}
