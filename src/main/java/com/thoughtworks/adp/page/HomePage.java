package com.thoughtworks.adp.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
    }

    public void goToAppointmentMaintenance() {
        driver.switchTo().frame(driver.findElement(By.name("BMLEFT")));

        driverWait.until(presenceOfElementLocated(By.xpath("//span[text()='Administração de Freqüência']"))).click();

        driver.findElement(By.xpath("//span[text()='Manutenção do Apontamento']")).click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("ADP")));
        driver.switchTo().frame(driver.findElement(By.name("BMRPK")));
        driver.findElement(By.className("box_texto")).click();

    }
}