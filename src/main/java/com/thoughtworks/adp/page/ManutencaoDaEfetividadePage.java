package com.thoughtworks.adp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ManutencaoDaEfetividadePage {
    private WebDriver driver;

    public ManutencaoDaEfetividadePage(WebDriver driver) {
        this.driver = driver;
    }

    public void adjustEmployeesFrequency() {
        switchToFrame("BMPROG");
        List<WebElement> wrongFrequencyEmployees = driver.findElements(By.xpath("//font[contains(@color,'red')]"));

        wrongFrequencyEmployees.get(0).findElement(By.xpath("../../..//a")).click();
        
    }

    private void switchToFrame(String bmprog) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("ADP")));
        driver.switchTo().frame(driver.findElement(By.name(bmprog)));
    }
}
