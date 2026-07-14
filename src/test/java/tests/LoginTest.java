package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest{
	
	@Test
	public void verifyValidLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory")
        );
    }
	
	@Test
	public void verifyInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.login(
                ConfigReader.getProperty("wrong_username"),
                ConfigReader.getProperty("password")
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo.com")
        );
    }
	
	@Test
    public void verifyInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("wrong_password")
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo.com")
        );
	}
	
	

    @Test
    public void verifyInvalidLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "wrong_user",
                "wrong_password"
        );

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("do not match")
        );
    }
    
    @Test
    public void verifyEmptyCredentials() {
    	LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getProperty("emptyUser"),
                ConfigReader.getProperty("emptyPass")
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo.com")
        );
    	
    	
    }

    @Test
    public void verifyLockedUserLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "locked_out_user",
                "secret_sauce"
        );

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("locked out")
        );
    }
    
    @Test
    public void verifyUsernameTrimming(){
    	LoginPage loginPage = new LoginPage(driver);
    	
    	loginPage.login(
                ConfigReader.getProperty("spaced_username"),
                ConfigReader.getProperty("password")
        );
    	
    	Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory")
        );
    	

    }
    
    @Test
    public void verifyPasswordWithSpaces(){
    	LoginPage loginPage = new LoginPage(driver);
    	
    	loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("spaced_password")
        );
    	
    	Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo.com")
        );
    	

    }
    
    @Test
    public void verifyMaxLengthUsername() {
    	LoginPage loginPage = new LoginPage(driver);
    	
    	String maxLengthUser = "a".repeat(100);
  
    	loginPage.login(
    			maxLengthUser,
                ConfigReader.getProperty("password")
        );
    	
    	Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo.com")
        );
    }
   
    @Test
    public void verifyMultipleFailedAttempts() {
    	LoginPage loginPage = new LoginPage(driver);
    	
    	for(int i = 0; i < 3; i++) {
    		loginPage.login(
                    ConfigReader.getProperty("wrong_username"),
                    ConfigReader.getProperty("wrong_password")
            );
    		
    		Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    	}
    }
    
    @Test
    public void verifyPasswordIsMasked() {
       
        String inputType = driver.findElement(org.openqa.selenium.By.id("password")).getAttribute("type");
        
     
        Assert.assertEquals(inputType, ConfigReader.getProperty("maskedPasswordType"));
    }
    
}
