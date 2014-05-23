package com.thoughtworks.adp;


import com.thoughtworks.adp.infra.ConfigurationProperties;
import com.thoughtworks.adp.model.User;
import com.thoughtworks.adp.page.HomePage;
import com.thoughtworks.adp.page.LoginPage;
import com.thoughtworks.adp.page.ManutencaoDaEfetividadePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {

        ConfigurationProperties configurationProperties = new ConfigurationProperties();

        User user = new User(configurationProperties.getUser(), configurationProperties.getPassword());


        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.adpweb.com.br/rhweb8/");

        LoginPage loginPage = new LoginPage(driver, user);
        loginPage.login();

        HomePage homePage = new HomePage(driver);
        homePage.goToAppointmentMaintenance();

        ManutencaoDaEfetividadePage manutencaoDaEfetividadePage = new ManutencaoDaEfetividadePage(driver);
        manutencaoDaEfetividadePage.adjustEmployeesFrequency();

        driver.quit();
    }
}
