package test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DatePicker {

public static void main(String[] args) {

//launch the FF browser
 WebDriver driver = new FirefoxDriver(); 
 driver.manage().window().maximize();
//Navigate to URL
driver.get("http://jqueryui.com/datepicker/"); 

//Though this is inside the frame so we need to switch into Frame 
driver.switchTo().frame(0); 

//Implicit Wait method 
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  

//Click on textbox so that datepicker will come  
driver.findElement(By.id("datepicker")).click();  

//Click on next so that we will be in next month  
 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
  
//DatePicker is a table.So  we have to navigate to each cell   
		  
WebElement datepicker = driver.findElement(By.id("ui-datepicker-div"));  
 List<WebElement> rows=datepicker.findElements(By.tagName("tr"));  
List<WebElement> columns=datepicker.findElements(By.tagName("td"));  
		   
for (WebElement cell: columns){  

	
if (cell.getText().equals("20")){  
cell.findElement(By.linkText("20")).click();  
break;  
 }  
}   
                   }
}