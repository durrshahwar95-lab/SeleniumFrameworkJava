package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	 public void setUp() {
		 driver = new ChromeDriver();
		 ConfigReader.loadProperties();
		 driver.manage().window().maximize();
		 driver.get(
	                ConfigReader.getProperty("url")
	        );
	 }
	
 @AfterMethod
	 public void tearDown(){

	       if(driver != null){
	            driver.quit();

	        }
	 }
}
