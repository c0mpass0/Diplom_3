package ru.yandex.praktikum;

import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class AccountPage {
    public static final String ACCOUNT_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String USER_DELETE_URL = "https://stellarburgers.nomoreparties.site/api/auth/user";
    public static final String EMAIL_INPUT = ".//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]/descendant::input";
    public static final String PASSWORD_INPUT = ".//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/descendant::input";
    public static final String LOGIN_BUTTON = ".//form[@class='Auth_form__3qKeq mb-20']/button";

    private final WebDriver driver;
    public AccountPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(ACCOUNT_PAGE_URL);
    }
    public void fillEmail(String email){
        driver.findElement(By.xpath(EMAIL_INPUT)).clear();
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(email);
    }
    public void fillPassword(String password){
        driver.findElement(By.xpath(PASSWORD_INPUT)).clear();
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(password);
    }

    public void logIn(){
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForUrl(String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
    public String getAuthToken() throws InterruptedException {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        System.out.println(localStorage.getItem("accessToken"));
        return localStorage.getItem("accessToken");
    }

    public ValidatableResponse deleteUser(String accessToken){
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_DELETE_URL)
                .then();
    }
}
