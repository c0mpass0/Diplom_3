package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String TOP_ACCOUNT_BUTTON = "//a[contains(@href,'account')]";
    public static final String CONSTRUCTOR_BUTTON = ".//li/a[contains(@href='/')]";

    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(MAIN_PAGE_URL);
    }
    public void openAccountPage(){
        driver.findElement(By.xpath(TOP_ACCOUNT_BUTTON)).click();
    }
    public void openConstructorPage(){
        driver.findElement(By.xpath(CONSTRUCTOR_BUTTON)).click();
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
