/*package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;

public class RecordandCompare {

	public static void main(String[] args) throws InterruptedException {
		Eyes eyes = new Eyes();

		eyes.setApiKey("eWFrfwRig1mlVHxT9UscWJ9SuDXs3jgXMrWqAWMcbJA110");

		eyes.setForceFullPageScreenshot(true);

		WebDriver driver = new FirefoxDriver();

		try {
			driver.get("https://www.charter.com/buyflow/buyflow-localization");
			driver = eyes.open(driver, "Charter.com", "localization", new RectangleSize(900, 700));
			eyes.checkWindow();
			driver.findElement(By.id("address1")).sendKeys("9799 hale dr");;
			driver.findElement(By.id("zip-code")).sendKeys("63123");;
			driver.findElement(By.id("get_online_only_deals")).click();
			
			Thread.sleep(5000);
			eyes.checkWindow();
			
			
//			eyes.checkWindow();
			eyes.close();
			
		} finally {
			eyes.abortIfNotClosed();
			driver.close();
		}

	}

}
*/