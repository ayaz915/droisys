package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestNG {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://business.spectrum.com/";
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNG() throws Exception {
    driver.get(baseUrl + "/content/localization");
    driver.findElement(By.id("address1")).clear();
    driver.findElement(By.id("address1")).sendKeys("9798 hale dr");
    driver.findElement(By.cssSelector("label.col-sm-3.control-label")).click();
    driver.findElement(By.id("zipcode")).clear();
    driver.findElement(By.id("zipcode")).sendKeys("63123");
    driver.findElement(By.id("localize_retrievecart_continue")).click();
    driver.findElement(By.name("address")).click();
    Thread.sleep(30000);
    driver.findElement(By.cssSelector("address.pull-left.ng-binding")).click();
    driver.findElement(By.id("begin_new_cart")).click();
    Thread.sleep(30000);
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
