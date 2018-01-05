package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class Wait {

	
	
	WebDriver driver;
	
	@BeforeTest
	public void atBefore(){
		
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void atTest(){
		
		
		driver.get("https://www.facebook.com/");
		
		WebDriverWait wait= new WebDriverWait(driver,60);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		wait.ignoring(ElementNotFoundException.class, ElementNotVisibleException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("day")));
		new Select(driver.findElement(By.id("day"))).selectByIndex(4);
		
		WebDriverWait wait1= new WebDriverWait(driver,15);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("month")));
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("Feb");
		
		WebDriverWait wait2= new WebDriverWait(driver,20);
		wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("year")));
		new Select(driver.findElement(By.id("year"))).selectByValue("2014");
		
	}
	
	@AfterTest
	public void atAfter(){
		
		
	}

}
