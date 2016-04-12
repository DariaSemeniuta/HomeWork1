import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Daria
 */
public class HomeWorkSelenium extends TestCase {
    private static WebDriver driver= new FirefoxDriver();
    private String firsPage="https://en.wikipedia.org/wiki/Main_Page";
    private By searchId = By.id("searchInput");
    WebElement search;
    @BeforeClass
    public void setUp() throws Exception{
        driver.get(firsPage);
    }

    @Test
    public void testFruit() throws Exception {
        try {
            search = driver.findElement(searchId);
            search.sendKeys("Fruit");
            search.submit();
            WebElement fruit = driver.findElement(By.linkText("apple"));
            fruit.click();
            assertNotNull(driver.findElement(By.linkText("fruit tree")));
            WebElement element = driver.findElement(By.className("mw-headline"));
            assertEquals(element.getText(), "Botanical information");
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден!");
        }
    }
    @Test
    public void testTomato() throws Exception{
        try {
            search = driver.findElement(searchId);
            search.sendKeys("Tomato");
            search.submit();
            assertNotNull(driver.findElement(By.xpath(".//a[text() = 'vegetable']")));
            assertEquals(driver.getTitle(), "Tomato - Wikipedia, the free encyclopedia");
        }
        catch (NoSuchElementException e) {
            System.out.println("Элемент не найден!");
        }
    }
    @AfterClass
    public void tearDown () throws Exception { 
        System.out.println( "Тест окончен" );
        driver.quit();
    }
}
