package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String ACCOUNT_BUTTON = ".//a[contains(@href='/account')]";
    public static final String CONSTRUCTOR_BUTTON = ".//li/a[contains(@href='/')]";

    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(PAGE_URL);
    }
    public void openAccountPage(){
        driver.findElement(By.xpath(ACCOUNT_BUTTON)).click();
    }
    public void openConstructorPage(){
        driver.findElement(By.xpath(CONSTRUCTOR_BUTTON)).click();
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
}
