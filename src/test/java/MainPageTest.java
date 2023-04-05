import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.MainPage;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.AccountPage.ACCOUNT_PAGE_URL;

public class MainPageTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void burgerOpenAccountPage(){
        MainPage page = new MainPage(driver);
        page.open();
        page.openAccountPage();

        assertEquals("Не перешли домой", ACCOUNT_PAGE_URL, page.getPageUrl());
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}
