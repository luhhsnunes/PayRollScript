package com.thoughtworks.adp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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

        List<WebElement> trElements = driver.findElements(By.xpath("//table[contains(@bordercolor,'#000000')]//tbody//tr"));
        trElements.remove(0);

        List<WebElement> workdaysElements = new ArrayList<WebElement>();

        for (WebElement trElement : trElements) {
            String trElementText = trElement.getText();
            if (isWorkDay(trElementText) && !trElementText.isEmpty() && !trElementText.contains("Afastamento")){
                workdaysElements.add(trElement);
            }
        }

        return;
    }

    private boolean isWorkDay(String trElementText) {
        return !isHoliday(trElementText) && !isWeekend(trElementText);
    }

    private boolean isHoliday(String trElementText) {
        return trElementText.contains("Feriado");
    }

    private boolean isWeekend(String trElementText) {
        return trElementText.contains("999") && trElementText.contains("998");
    }

    private void switchToFrame(String bmprog) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("ADP")));
        driver.switchTo().frame(driver.findElement(By.name(bmprog)));
    }
}
