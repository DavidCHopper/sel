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

public class T2 {
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
        /*wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//div[@class='region-list']/a[@class='kit-link kit-link_color_black region-list__toggler']"))));*/
        driver.findElement(By.xpath("//a[@class='kit-link kit-link_pseudo kit-link_color_black alt-menu-collapser__link']")).click();
        driver.findElement(By.xpath("//a[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1']")).click();
        //System.out.println(driver.findElement(By.xpath("//h1")).getText());
        assertEquals("«Сбербанк» - Страхование путешественников", driver.findElement(By.xpath("/html/head/title")).getText());
        driver.findElement(By.xpath("//a/img[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']/..")).click();
        driver.findElement(By.xpath("//div[text()='Минимальная']/../..")).click();
        driver.findElement(By.xpath("//span[text()='Оформить']")).click();
        driver.findElement(By.name("insured0_surname")).clear();
        driver.findElement(By.name("insured0_surname")).sendKeys("ghj");
        driver.findElement(By.name("insured0_name")).clear();
        driver.findElement(By.name("insured0_name")).sendKeys("wasd");
        driver.findElement(By.name("insured0_birthDate")).clear();
        driver.findElement(By.name("insured0_birthDate")).sendKeys("10.10.2000");
        driver.findElement(By.name("surname")).clear();
        driver.findElement(By.name("surname")).sendKeys("jhg");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("dsaw");
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys("qwerty");
        driver.findElement(By.name("birthDate")).clear();
        driver.findElement(By.name("birthDate")).sendKeys("10.10.2000");
        driver.findElement(By.name("passport_series")).clear();
        driver.findElement(By.name("passport_series")).sendKeys("0000");
        driver.findElement(By.name("passport_number")).clear();
        driver.findElement(By.name("passport_number")).sendKeys("000000");
        driver.findElement(By.name("issueDate")).clear();
        driver.findElement(By.name("issueDate")).sendKeys("10.0.2000");
        driver.findElement(By.name("issuePlace")).clear();
        driver.findElement(By.name("issuePlace")).sendKeys("bla-bla-bla");

        assertEquals("ghj", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("wasd", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("10.10.2000", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("jhg", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("dsaw", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("qwerty", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("10.10.2000", driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals("0000", driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("000000", driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("10.10.2000", driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("bla-bla-bla", driver.findElement(By.name("issuePlace")).getAttribute("value"));

        driver.findElement(By.xpath("//span[text()='Продолжить']")).click();
        assertSame(true,driver.findElement(By.xpath("//div[text()='Заполнены не все обязательные поля']")).isDisplayed());
        /*wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//input[@class='kit-input__control']"))));


        */
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
