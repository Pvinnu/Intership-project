package Internship;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verification_on_formSubmition {

	
	WebDriver driver;
	@BeforeMethod	
	public void openbrowser() throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	  driver.get("https://roofrocketai.engageleads.net/login");
	  
	  if(driver.getCurrentUrl().equals("https://roofrocketai.engageleads.net/login")){
		  Reporter.log("Test case pass",false);
	  }
	  else {
		  Reporter.log("Test case failes",true) ;
	}
	}
	@Test
	public void login() throws InterruptedException, IOException {
		
      FileInputStream fis=new FileInputStream("./sample/LoginCredentials.properties");
        
        Properties p=new Properties();
        
        p.load(fis);
        
		driver.findElement(By.id("username")).sendKeys(p.getProperty("Email"));
		Thread.sleep(2000);
		driver.findElement(By.id("userpassword")).sendKeys(p.getProperty("Pass"));
		Thread.sleep(2000);
		driver.findElement(By.id("flexChecklg")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("(//span[@class='nv_text'])[11]")).click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@class,'btn gilroy')]")).click();
        Thread.sleep(2000);

        
       FileInputStream fis1=new FileInputStream("./sample/FormData.properties");
        
       // Properties p=new Properties();
        
        p.load(fis1);
        
		driver.findElement(By.id("firstname")).sendKeys(p.getProperty("Fname"));
		Thread.sleep(2000);
		driver.findElement(By.id("lastname")).sendKeys(p.getProperty("Lname"));
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(p.getProperty("Email"));;
		driver.findElement(By.id("password")).sendKeys(p.getProperty("Pass"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	@AfterMethod
	public void close() {
		if(driver.getCurrentUrl().equals("https://roofrocketai.engageleads.net/useroperation"))
		{
			Reporter.log("Form submition succesful",true);
		}
		else {
			Reporter.log("Form Submitionn  Failed",true);
		}
		driver.close();
	
}
	}
