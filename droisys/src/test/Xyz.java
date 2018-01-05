package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.indago.util.ErrorUtil;

public class Xyz {

	static WebDriver driver;
	 public static void captureScreenshot(String filename) throws IOException{
			try{
			System.out.println("Taking ScreenShot" );
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+filename+".jpg"));
		    System.out.println("ScreenShot is captured, to view image please go to "+System.getProperty("user.dir")+"\\Screenshots\\"+"HomePage"+".jpg" );
			}
		    catch(Throwable t){
				ErrorUtil.addVerificationFailure(t);
			
				System.out.println("Not able to take screenshot");
				
			}
     }
	public static void checkForLacalizationError() throws Exception{
		
		System.out.println("checking for Lacalization Error");
			captureScreenshot("AddressNotMatchPage");
			System.out.println("ScreenShot is captured, to view image please go to "+System.getProperty("user.dir")+"\\Screenshots\\"+"LacalizationErrorPage"+".jpg" );
		
			throw new IllegalArgumentException(" Stoping the script....!!!!");
			
	 }	
	
	
	public static void main(String args[]) throws Exception{
		
		Xyz.checkForLacalizationError();
		
	}
}
