package test;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrokenLinks {

	static WebDriver driver;

public static List<WebElement> findAllLinks(WebDriver driver)

  {
	List<WebElement> elementList = new ArrayList();
	  elementList = driver.findElements(By.tagName("a"));
	  elementList.addAll(driver.findElements(By.tagName("img")));
	  List finalList = new ArrayList(); 
	  for (WebElement element : elementList)
	  {
        if(element.getAttribute("href") != null)
		  {
		  finalList.add(element);
		  }		  
	  }	
	  return finalList;
  }
	public static String isLinkBroken(URL url) throws Exception{
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try
		{
		    connection.connect();
		    response = connection.getResponseMessage();	        
		    connection.disconnect();
		    return response;
		}
		catch(Exception exp)
		{
		return exp.getMessage();
		}  				

	}
	public static void main(String[] args) throws Exception {

			driver = new FirefoxDriver(); 
			driver.manage().window().maximize();
			driver.get("https://www.charter.com/browse/content/charter-home"); 
			driver.manage().window().maximize();
			
		    List<WebElement> allImages = findAllLinks(driver);    
		    System.out.println("Total number of elements found " + allImages.size());
		    for( WebElement element : allImages){
		    	try
		    	{
			      System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		    	//System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		    	}
		    	catch(Exception exp)
		    	{
		    	  System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured At; " + exp.getMessage());
		    	}
		    }
	    }
	}