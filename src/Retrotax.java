import org.openqa.selenium.*;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.*;

import java.util.Random;

public class Retrotax {
    private WebDriver driver;
    private JavascriptExecutor js;
    private String baseUrl;
    private Random r;

    private void initChrome(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/getupandgo/Documents/projects/selenium/lib/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1024,768");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);

        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor)driver;
        }  else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
        r = new Random();
    }

    private void fillField(String fieldId, String val){
        if(driver.findElement(By.id(fieldId)).isDisplayed()){
            driver.findElement(By.id(fieldId)).clear();
            driver.findElement(By.id(fieldId)).sendKeys(val);
        }
    }

    private void clickIfVisible(String fieldId){
        WebElement button = driver.findElement(By.id(fieldId + boolRandom()));
        if(button.isDisplayed())
            button.click();
    }

    private String randomSum(){
        String sum = String.valueOf(r.nextInt(900) + 100) + String.valueOf(r.nextInt(900) + 100);
        return sum;
    }

    private String randomEmail(){
        int size = r.nextInt(11);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        characters = characters.toLowerCase();
            char[] text = new char[size];
            for (int i = 0; i < size; i++)
            {
                text[i] = characters.charAt(r.nextInt(characters.length()));
            }
        String prefix = new String(text);

        return prefix + "@gmail.com";
    }

    private int boolRandom(){
        return r.nextInt(2);
    }
    private String randomPhone(){

        String strippedNum;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        num1 = r.nextInt(600) + 100;//numbers can't include an 8 or 9, can't go below 100.
        num2 = r.nextInt(641) + 100;//number has to be less than 742//can't go below 100.
        num3 = r.nextInt(8999) + 1000; // make numbers 0 through 9 for each digit.//can't go below 1000.

        strippedNum = Integer.toOctalString(num1);
        strippedNum += num2;
        strippedNum += num3;

        return strippedNum;
    }

    public void test() throws Exception {

        initChrome();

        baseUrl = "http://dev.retrotax-aci.com";
        driver.get(baseUrl + "/users/login");

        fillField("user-username", "AM12843");
        fillField("user-password", "eey29243");

        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        Thread.sleep(500);                 //because implicitlyWait() doesn't work

        driver.get(baseUrl + "/employees/basic_info?new=1");

        new Select(driver.findElement(By.id("employee-locationid"))).selectByVisibleText("Flowers Baking Co. of Bradenton LLC");
        fillField("employee-firstname", "Foo");
        fillField("employee-middleinitial", "j");
        fillField("employee-lastname", "Bar");
        new Select(driver.findElement(By.id("employee-suffixid"))).selectByVisibleText("Jr.");
        fillField("employee-address", "Planet");
        fillField("employee-address2", "Nibiru");
        fillField("employee-city", "GreenMansTown");
        new Select(driver.findElement(By.id("employee-stateid"))).selectByVisibleText("ALASKA");
        driver.findElement(By.id("employee-rehire-0")).click();
        js.executeScript("document.getElementById(\"employee-zip\").value = \"11111\";");
        js.executeScript("document.getElementById(\"employee-ssn\").value = \"111-11-1111\";");
        js.executeScript("document.getElementById(\"employee-ssnConfirmation\").value = \"111-11-1111\";");
        js.executeScript("document.getElementById(\"employee-dob\").value = \"11/11/1990\";");
        driver.findElement(By.id("btnSubmit")).click();

        Thread.sleep(500);

        driver.findElement(By.id("employee-afdc-0")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(500);

        driver.findElement(By.id("employee-foodstamps-0")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(500);

        driver.findElement(By.id("employee-ssi-0")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(500);

        driver.findElement(By.id("employee-vocrehab-0")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(500);

        driver.findElement(By.id("employee-veteran-0")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(500);

        driver.findElement(By.id("employee-unemployed-0")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(500);

        driver.findElement(By.id("employee-felon-0")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(500);

        driver.findElement(By.id("employee-cdib-0")).click();
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(500);

        driver.findElement(By.id("employee-agreeBenestream")).click();
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(500);

        clickIfVisible("benestream-q1-");
        clickIfVisible("benestream-q2-");
        clickIfVisible("benestream-q3-");
        clickIfVisible("benestream-q4-");
        clickIfVisible("benestream-q5-");
        clickIfVisible("benestream-q6-");
        fillField("benestream-q7", String.valueOf(r.nextInt(201)));
        clickIfVisible("benestream-q8-");
        fillField("benestream-q9", randomSum());
        fillField("benestream-q10", String.valueOf(r.nextInt(201)));
        clickIfVisible("benestream-q11-");
        clickIfVisible("benestream-q13-");
        fillField("benestream-q14", randomSum());
        fillField("benestream-q15", String.valueOf(r.nextInt(201)));
        clickIfVisible("benestream-q16-");
        fillField("benestream-q17", randomSum());
        fillField("benestream-email", randomEmail());
        fillField("benestream-phone", randomPhone());

        driver.findElement(By.id("btnSubmit")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='Submit']")).click();
    }

}
