import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.page.CurrentPage;
import ru.yandex.praktikum.page.RecoveryPage;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.src.UrlList.ACCOUNT_PAGE_URL;

public class RecoveryPageTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void returnFromRecoveryToLoginSuccessful(){
        RecoveryPage recoveryPage = new RecoveryPage(driver);
        recoveryPage.open();
        recoveryPage.returnToAccountPage();

        CurrentPage currentPage = new CurrentPage(driver);
        currentPage.waitForUrl(ACCOUNT_PAGE_URL);

        assertEquals("Не перешли на страницу логина", ACCOUNT_PAGE_URL, currentPage.getPageUrl());
    }
}
