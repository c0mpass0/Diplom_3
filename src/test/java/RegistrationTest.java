import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.AccountPage;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.RegistrationPage;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.AccountPage.ACCOUNT_PAGE_URL;
import static ru.yandex.praktikum.AccountPage.LOGIN_BUTTON;

public class RegistrationTest {
    private WebDriver driver;
    private String accessToken;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void cleanUp() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void registrationSuccess() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();

        registrationPage.fillName("Test");
        registrationPage.fillEmail("kudsbbvbdtfvkkj@nscn.dfk");
        registrationPage.fillPassword("123456");
        registrationPage.confirmRegistration();

        registrationPage.waitForUrl(ACCOUNT_PAGE_URL);
        assertEquals("Регистрация не прошла успешно", ACCOUNT_PAGE_URL, registrationPage.getPageUrl());

        AccountPage accountPage = new AccountPage(driver);
        accountPage.fillEmail("kudsbbvbdtfvkkj@nscn.dfk");
        accountPage.fillPassword("123456");
        accountPage.logIn();

        MainPage page = new MainPage(driver);
        page.waitForUrl(MainPage.MAIN_PAGE_URL);
        accessToken = accountPage.getAuthToken();
        accountPage.deleteUser(accessToken);
    }
}