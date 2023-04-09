import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.page.CurrentPage;
import ru.yandex.praktikum.page.MainPage;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.page.MainPage.MIDDLE_CABINET_BUTTON;
import static ru.yandex.praktikum.src.HeaderElements.TOP_CABINET_BUTTON;
import static ru.yandex.praktikum.src.UrlList.ACCOUNT_PAGE_URL;

@RunWith(Parameterized.class)
public class MainPageToAccountPageTest {
    private WebDriver driver;

    private final String button;

    public MainPageToAccountPageTest(String button){
        this.button = button;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {TOP_CABINET_BUTTON},
                {MIDDLE_CABINET_BUTTON},
        };
    }

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void burgerOpenAccountPageSuccessful(){
        MainPage page = new MainPage(driver);
        page.open();
        page.openCabinetPage(button);

        CurrentPage currentPage = new CurrentPage(driver);
        currentPage.waitForUrl(ACCOUNT_PAGE_URL);

        assertEquals("Не перешли на страницу логина", ACCOUNT_PAGE_URL, currentPage.getPageUrl());
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}
