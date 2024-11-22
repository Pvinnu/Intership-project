package Internship;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verification_of_UI_Elements {

	
	WebDriver driver;
	@BeforeMethod	
	public void openbrowser() throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	  driver.get("https://roofrocketai.engageleads.net/login");
	  
	  //Verifying links
	  if(driver.getCurrentUrl().equals("https://roofrocketai.engageleads.net/login"))
	  {
		  Reporter.log("Yes! it is a valid link",true);
	  }
	  else {
		  Reporter.log("Yes! it is not a valid link",true) ;
	     }
	}
	@Test
	public void login() throws InterruptedException, IOException 
	{
FileInputStream fis=new FileInputStream("./sample/LoginCredentials.properties");
        
        Properties p=new Properties();
        
        p.load(fis);
		driver.findElement(By.id("username")).sendKeys(p.getProperty("Email"));
		Thread.sleep(2000);
		driver.findElement(By.id("userpassword")).sendKeys(p.getProperty("Pass"));
		Thread.sleep(2000);
		driver.findElement(By.id("flexChecklg")).click();
	    WebElement submit=	driver.findElement(By.xpath("//input[@type='submit']"));

	    //Verifying buttons
	    if(submit.isDisplayed() && submit.isEnabled()) {
	    	System.out.println("Yes! Submit button is displayed and enabled");
	    }
	    else {
	    	System.out.println("No! Submit button is not displayed and enabled");
	    }
	    submit.click();
	    //Verifying Modules
	    Thread.sleep(2000);
	    WebElement Dashboard=driver.findElement(By.xpath("(//span[@class='nv_text'])[1]"));
	    if(Dashboard.isDisplayed() && Dashboard.isEnabled()) {
	    	System.out.println("Yes! Dashboard module is displayed and Enabled");
	    }
	    else {
	    	System.out.println("No! Dashboard module is not displayed and Enabled");
	    }
	    
	    WebElement users=driver.findElement(By.xpath("(//span[@class='nv_text'])[11]"));
        if(users.isDisplayed()) {
	    	System.out.println("Yes! user module it is displayed ");
	    }
	    else {
	    	System.out.println("No! user module is not displayed");
	    }
	    
	    if(users.isEnabled()) {
	    	System.out.println("Yes! user module is Enabled");
	    }
	    else {
	    	System.out.println("No user module is not Enabled");
	    }
	}    
	@AfterMethod
	public void close() {
		//verifying links...............................
		if(driver.getCurrentUrl().equals("https://roofrocketai.engageleads.net/research"))
		{
			Reporter.log("Login succesful",true);
		}
		else {
			Reporter.log("Login Failed",true);
		}
		driver.close();
	
}}

