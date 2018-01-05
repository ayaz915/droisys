package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;



public class ClassSelectorDemo {
	
	static WebDriver driver;

	public static void urlwait(){
		
		System.out.println("waiting");
	//String s= "https://www.charter.com/buyflow/retrieve-cart-implicit/,https://www.charter.com/buyflow/address-clarification,https://www.charter.com/buyflow/multiple-addresses,https://www.charter.com/buyflow/address-does-not-match";
	String url= driver.getCurrentUrl();
	//String url= "https://www.charter.com/buyflow/retrieve-cart-implicit/";
	
	List<String> all = new ArrayList<String>();
	all.add("https://www.charter.com/buyflow/retrieve-cart-implicit/");
	all.add("https://www.charter.com/buyflow/address-clarification");
	all.add("https://www.charter.com/buyflow/multiple-addresses");
	all.add("https://www.charter.com/buyflow/address-does-not-match");
	
	
	 Wait<String> wait = new FluentWait<String>(url)
			   .withTimeout(10, TimeUnit.SECONDS)//  change here
		       .pollingEvery(2, TimeUnit.SECONDS) // change here
		       .ignoring(NoSuchElementException.class);
	 
	 Function<String, Boolean> f=new Function<String, Boolean>(){
		 
		public  Boolean apply(String url){
			
			if(!all.contains(url)){
				
				//System.out.println("false");
				return false;
			}
			//System.out.println("true");
			return true;
		}
	 };
	
	}
	
	public static void main(String args[]){
		
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.charter.com/buyflow/buyflow-localization");
		driver.findElement(By.id("address1")).sendKeys("9798 hale dr");
		driver.findElement(By.id("zip-code")).sendKeys("63123");
		driver.findElement(By.id("get_online_only_deals")).click();
		ClassSelectorDemo.urlwait();
		String url= driver.getCurrentUrl();
		System.out.println("url");
		driver.findElement(By.xpath("//*[@id='multiple-addresses']/section/div/section/div/div[2]/form/div/div[1]/div/label/div[1]/address")).click();
		
		
	}
}
	

		
	

