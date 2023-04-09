import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.page.MainPage;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.page.MainPage.*;

public class ConstructorTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void selectSauceInConstructorSuccessful(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.selectConstructorCategory(SAUCE_CONSTRUCTOR_BUTTON);

        assertTrue("Не перешли в раздел конструктора",driver.findElements( By.xpath(SAUCE_CONSTRUCTOR_SELECTED)).size() != 0);
    }

    @Test
    public void selectIngredientInConstructorSuccessful(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.selectConstructorCategory(INGREDIENT_CONSTRUCTOR_BUTTON);

        assertTrue("Не перешли в раздел конструктора",driver.findElements( By.xpath(INGREDIENT_CONSTRUCTOR_SELECTED)).size() != 0);
    }

    @Test
    public void selectBunInConstructorSuccessful(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.selectConstructorCategory(INGREDIENT_CONSTRUCTOR_BUTTON);
        mainPage.selectConstructorCategory(BUN_CONSTRUCTOR_BUTTON);

        assertTrue("Не перешли в раздел конструктора",driver.findElements( By.xpath(BUN_CONSTRUCTOR_SELECTED)).size() != 0);
    }
}
