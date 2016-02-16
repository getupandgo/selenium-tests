package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class JunitBenestream {
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
  public void testJunitBenestream() throws Exception {
    driver.get(baseUrl + "/employees/benestream-waiver");
    driver.findElement(By.id("employee-agreeBenestream")).click();
    driver.findElement(By.id("btnSubmit")).click();
    driver.findElement(By.id("benestream-q11-0")).click();
    driver.findElement(By.id("benestream-q11-1")).click();
    driver.findElement(By.id("benestream-q1-1")).click();
    driver.findElement(By.id("benestream-q1-0")).click();
    driver.findElement(By.id("benestream-q2-0")).click();
    driver.findElement(By.id("benestream-q4-0")).click();
    driver.findElement(By.id("benestream-q5-0")).click();
    driver.findElement(By.id("benestream-q6-0")).click();
    driver.findElement(By.id("benestream-q6-1")).click();
    driver.findElement(By.id("benestream-q13-1")).click();
    driver.findElement(By.id("benestream-q16-1")).click();
    driver.findElement(By.xpath("//ol[@id='bsq']/li[16]/span/label[2]")).click();
    driver.findElement(By.id("benestream-q11-0")).click();
    driver.findElement(By.id("benestream-q11-1")).click();
    driver.findElement(By.id("benestream-q6-0")).click();
    driver.findElement(By.id("benestream-q6-1")).click();
    driver.findElement(By.id("benestream-q13-1")).click();
    driver.findElement(By.xpath("//ol[@id='bsq']/li[13]/span/label[2]")).click();
    driver.findElement(By.id("benestream-q16-1")).click();
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
