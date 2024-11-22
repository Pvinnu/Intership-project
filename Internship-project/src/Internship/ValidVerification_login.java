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

public class ValidVerification_login {

	WebDriver driver;
	@BeforeMethod	
	public void openbrowser() throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	  driver.get("https://roofrocketai.engageleads.net/login");
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
	}
	@AfterMethod
	public void close() {
		
		if(driver.getCurrentUrl().equals("https://roofrocketai.engageleads.net/research"))
		{
			Reporter.log("Login succesful",true);
		}
		else {
			Reporter.log("Login Faiuled",true);
		}
		driver.close();
	
}}

