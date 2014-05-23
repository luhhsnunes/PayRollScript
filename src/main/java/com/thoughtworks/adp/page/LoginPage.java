package com.thoughtworks.adp.page;

import com.thoughtworks.adp.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {
    private WebDriver driver;
    private User user;
    private WebDriverWait driverWait;

    public LoginPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        driverWait = new WebDriverWait(driver, 10);
    }

    public void login() {
        driver.switchTo().frame(driver.findElement(By.name("ADP")));

        WebElement userInput = driverWait.until(presenceOfElementLocated(By.name("vt_user")));
        userInput.sendKeys(user.getLogin());

        driver.findElement(By.name("vt_pass")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//img[contains(@src,'entrar')]")).click();
        driverWait.until(presenceOfElementLocated(By.xpath("//a[contains(@href,'sel_combo2')]"))).click();
    }
}
