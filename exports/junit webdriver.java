package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class JunitWebdriver {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://dev.retrotax-aci.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJunitWebdriver() throws Exception {
    driver.get(baseUrl + "/clients/index");
    driver.findElement(By.linkText("New")).click();
    new Select(driver.findElement(By.id("employee-locationid"))).selectByVisibleText("Flowers Baking Co. of Bradenton LLC");
    driver.findElement(By.id("employee-firstname")).clear();
    driver.findElement(By.id("employee-firstname")).sendKeys("ggggggggggg");
    driver.findElement(By.id("employee-middleinitial")).clear();
    driver.findElement(By.id("employee-middleinitial")).sendKeys("g");
    driver.findElement(By.id("employee-lastname")).clear();
    driver.findElement(By.id("employee-lastname")).sendKeys("gggggggggg");
    new Select(driver.findElement(By.id("employee-suffixid"))).selectByVisibleText("Jr.");
    driver.findElement(By.id("employee-address")).clear();
    driver.findElement(By.id("employee-address")).sendKeys("gggggggg");
    driver.findElement(By.id("employee-address2")).clear();
    driver.findElement(By.id("employee-address2")).sendKeys("gggggggg");
    driver.findElement(By.id("employee-city")).clear();
    driver.findElement(By.id("employee-city")).sendKeys("gggggggg");
    new Select(driver.findElement(By.id("employee-stateid"))).selectByVisibleText("ALASKA");
    driver.findElement(By.id("employee-rehire-0")).click();
    driver.findElement(By.id("btnSubmit")).click();
    driver.findElement(By.id("employee-afdc-0")).click();
    driver.findElement(By.id("employee-afdc-0")).click();
    driver.findElement(By.id("employee-afdc-0")).click();
    driver.findElement(By.name("btncontinue")).click();
    driver.findElement(By.id("employee-foodstamps-0")).click();
    driver.findElement(By.name("btncontinue")).click();
    driver.findElement(By.id("employee-ssi-0")).click();
    driver.findElement(By.xpath("//input[@value='Continue']")).click();
    driver.findElement(By.id("employee-vocrehab-0")).click();
    driver.findElement(By.xpath("//input[@value='Continue']")).click();
    driver.findElement(By.id("employee-veteran-0")).click();
    driver.findElement(By.xpath("//input[@value='Continue']")).click();
    driver.findElement(By.id("employee-unemployed-0")).click();
    driver.findElement(By.xpath("//input[@value='Continue']")).click();
    driver.findElement(By.id("employee-felon-0")).click();
    driver.findElement(By.xpath("//input[@value='Continue']")).click();
    driver.findElement(By.id("employee-cdib-0")).click();
    driver.findElement(By.id("btnSubmit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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
