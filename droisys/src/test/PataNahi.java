package test;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PataNahi {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.charter.com/buyflow/content/channel-lineup-model");
		
		if(!driver.getCurrentUrl().equals("https://www.charter.com/buyflow/content/channel-lineup-model")){
			
		driver.navigate().to("https://www.charter.com/buyflow/content/channel-lineup-model");
		
		}
		
		
		String s =driver.getPageSource();
		System.out.println(s);
		
		//Assert.assertTrue(s.contains("ayaz"));
		
		if(s.contains("tel:")){
			
			System.out.println("Pass");
		}
		else{
			System.out.println("Fail");
		}
	}
	
	
}
