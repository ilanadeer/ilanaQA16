
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Trello
{
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testTrello() {
    //opensite
    openSite();
    driver.findElement(By.xpath("//*[@href='/signup']")).click();

    fillNameField();
    fillEmailField();
    fillPasswordField();
    clickOnSignUpButton();
  }

  public void clickOnSignUpButton() {
    driver.findElement(By.id("signup")).click();
  }

  public void fillPasswordField() {
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("31052013");
  }

  public void fillEmailField() {
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("ilana_5@mail.ru");
  }

  public void fillNameField() {
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Ilana");
  }

  public void openSite() {
    driver.get("https://trello.com/");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
  }

  private boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
