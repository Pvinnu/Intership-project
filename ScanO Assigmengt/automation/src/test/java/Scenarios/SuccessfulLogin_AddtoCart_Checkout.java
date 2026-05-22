package Scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SuccessfulLogin_AddtoCart_Checkout {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver=new ChromeDriver();
		// maximizing after launching the browser
			driver.manage().window().maximize();
			// navigating to application
			driver.get("https://sauce-demo.myshopify.com/");
			//Handling Synchronization
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//Clicking the login button
			driver.findElement(By.id("customer_login_link")).click();
			Thread.sleep(2000);
			//Sending email and pass from properties file
			driver.findElement(By.id("customer_email")).sendKeys("standard_user@saucedemo.com");
			Thread.sleep(2000);
			driver.findElement(By.id("customer_password")).sendKeys("secret_sauce");		
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value=\"Sign In\"]")).click();
			
			//Scenario2
			
			//clickking catalog button
			driver.findElement(By.xpath("//a[text()='Catalog']")).click();
			//selecting the products
			driver.findElement(By.xpath("//img[@alt=\"Black heels\"]")).click();
			driver.findElement(By.id("add")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			driver.findElement(By.xpath("//img[@alt=\"Bronze sandals\"]")).click();
			driver.findElement(By.id("add")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			driver.findElement(By.xpath("//img[@alt=\"Grey jacket\"]")).click();
			driver.findElement(By.id("add")).click();
			Thread.sleep(2000);
			
			//Scenario 3
			//Checking out the products
			driver.findElement(By.xpath("//a[text()='Check Out']")).click();
			Thread.sleep(2000);
			Actions a1=new Actions(driver);
			a1.scrollByAmount(0, 500);
			driver.findElement(By.id("checkout")).click();
			//Getting the details of products in console
			String checkoutdata=driver.findElement(By.xpath("(//div[@role=\"rowgroup\"])[2]")).getText();
			System.out.println(checkoutdata);
			driver.quit();
	}

}
