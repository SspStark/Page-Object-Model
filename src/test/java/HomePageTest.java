
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class HomePageTest {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","D:\\sspto\\Downloads1\\Softwares\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
        WebElement usernameEl = driver.findElement(By.id("username"));
        usernameEl.sendKeys("rahul");
        WebElement passwordEl = driver.findElement(By.id("password"));
        passwordEl.sendKeys("rahul@2021");
        WebElement loginButtonEl = driver.findElement(By.className("login-button"));
        loginButtonEl.submit();
    }
    @Test
    public void clickOnShopNowButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shop-now-button")));
        WebElement shopNowEl = driver.findElement(By.className("shop-now-button"));
        shopNowEl.click();
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/products";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }
    @Test
    public void checkHeadingElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-heading")));
        WebElement headingEl = driver.findElement(By.className("home-heading"));
        Assert.assertTrue(headingEl.isDisplayed(), "Element is not visible");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
