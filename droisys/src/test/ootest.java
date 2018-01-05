package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ootest {

	public static void main(String args[]) throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("az@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("123456");
		Thread.sleep(5000);
		driver.findElement(By.id("u_0_l")).click();
		
		
	}
}
