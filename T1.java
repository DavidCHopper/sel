import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class T1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(
            driver.findElement(By.xpath("//div[@class='region-list']/a[@class='kit-link kit-link_color_black region-list__toggler']"))));
        driver.findElement(By.xpath("//div[@class='region-list']/a[@class='kit-link kit-link_color_black region-list__toggler']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
              driver.findElement(By.xpath("//input[@class='kit-input__control']"))));

        driver.findElement(By.xpath("//input[@class='kit-input__control']")).clear();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//input[@class='kit-input__control']"))));
        WebElement we = driver.findElement(By.xpath("//input[@class='kit-input__control']"));
        driver.findElement(By.xpath("//input[@class='kit-input__control']")).sendKeys("Нижегородская область");
        driver.findElement(By.xpath("//input[@class='kit-input__control']")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//input[@class='kit-input__control']")).sendKeys(Keys.RETURN);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println(driver.findElement(By.xpath("//a[@href='https://www.facebook.com/bankdruzey']")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//a[@href='https://www.facebook.com/bankdruzey']/..")).isDisplayed());
        System.out.println("");
        assertSame(true,driver.findElement(By.xpath("//a[@href='https://www.facebook.com/bankdruzey']")).isEnabled());

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

}
