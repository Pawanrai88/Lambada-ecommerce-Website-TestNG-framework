package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import com.google.common.io.Files;

public class BaseTest {
	
	public  static WebDriver driver;
	private  Properties prop = new Properties();
	private  FileInputStream fis;
	 
	
	static Logger log = Logger.getLogger(BaseTest.class);
	private  WebDriverWait wait;
	
	public void setUp() {
		
		PropertyConfigurator.configure("C:\\Users\\12363\\eclipse-workspace\\LambdaTest\\src\\test\\resources\\Properties\\log4j.properties");
		
		prop=new Properties();
		try {
			fis =new FileInputStream("C:\\Users\\12363\\eclipse-workspace\\LambdaTest\\src\\test\\resources\\Properties\\Config.properties");
			
			log.info("Test execution started !!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
			log.info("Config properties file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			 driver= new ChromeDriver();
			 log.info("Chrome browser launched");
			
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			 driver= new EdgeDriver();
			 log.info("Edge browser launched");
			
		}
		if(browserName.equalsIgnoreCase("firefox"))
		{
			 driver= new FirefoxDriver();
			 log.info("Firefox browser launched");
			
		}
		
	String testEnv = System.getProperty("Env")!=null ? System.getProperty("Env"):prop.getProperty("Env");
	
	   if(testEnv.equalsIgnoreCase("QA"))
	   {
		   driver.get(prop.getProperty("QA_url"));
		   log.info("Navigate to : " + prop.getProperty("QA_url"));
	   }
	   
	   if(testEnv.equalsIgnoreCase("Prod"))
	   {
		   driver.get(prop.getProperty("Prod_url"));
		   log.info("Navigate to : " + prop.getProperty("Prod_url"));
	   }
	   
	   if(testEnv.equalsIgnoreCase("UAT"))
	   {
		   driver.get(prop.getProperty("UAT_url"));
		   log.info("Navigate to : " + prop.getProperty("UAT_url"));
	   }
	   
	   if(testEnv.equalsIgnoreCase("Dev"))
	   {
		   driver.get(prop.getProperty("Dev_url"));
		   log.info("Navigate to : " + prop.getProperty("Dev_url"));
	   }
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicit.wait"))));
	   wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicit.wait"))));
		
	}
	
    @AfterClass
	public void tearDown() {

		if(driver !=null) {
		driver.quit();
		log.info("Test execution completed !!!");
		}
	}
    
 /*   public void takeScreenShot() throws IOException {
    	
    	File src= null;
    	src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	Files.copy(src,new File("./Screenshot/"+"scr-"+System.currentTimeMillis()+".png"));
    }
    */

}
