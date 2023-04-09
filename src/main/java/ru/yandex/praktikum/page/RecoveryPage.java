package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.src.UrlList.PASSWORD_RECOVERY_PAGE_URL;

public class RecoveryPage {
    public static final String RETURN_TO_ACCOUNT_BUTTON = ".//a[contains(@href,'login')]";
    private final WebDriver driver;
    public RecoveryPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(PASSWORD_RECOVERY_PAGE_URL);
    }

    public void returnToAccountPage(){
        driver.findElement(By.xpath(RETURN_TO_ACCOUNT_BUTTON)).click();
    }
}
