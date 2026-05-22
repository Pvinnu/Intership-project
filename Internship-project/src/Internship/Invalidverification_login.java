package Internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Invalidverification_login {

	WebDriver driver;
	@BeforeMethod	
	public void openbrowser() throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	  driver.get("https://roofrocketai.engageleads.net/login");
	}
	@Test
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("12342");
		Thread.sleep(2000);
		driver.findElement(By.id("userpassword")).sendKeys("dsjsflsdlmssfg");
		Thread.sleep(2000);
		driver.findElement(By.id("flexChecklg")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void close() {
		if(driver.getCurrentUrl().equals("https://roofrocketai.engageleads.net/research"))
		{
			Reporter.log("Login succesful",true);
		}
		else {
			Reporter.log("Test case has been Passed due to nagivate scenario login has failed",true);
		}
		driver.close();
	
}}
