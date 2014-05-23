package com.thoughtworks.adp;


import com.thoughtworks.adp.infra.ConfigurationProperties;
import com.thoughtworks.adp.model.User;
import com.thoughtworks.adp.page.HomePage;
import com.thoughtworks.adp.page.LoginPage;
import com.thoughtworks.adp.page.ManutencaoDaEfetividadePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    private LoginPage loginPage;
    private HomePage homePage;
    private ManutencaoDaEfetividadePage manutencaoDaEfetividadePage;
    private User user;
    private WebDriver driver;

    public static void main(String[] args) {
        new Main().execute();
    }

    public void execute(){
        user = readConfigurations();

        driver = new FirefoxDriver();
        driver.get("https://www.adpweb.com.br/rhweb8/");

        initiatePages();

        loginPage.login();
        homePage.goToAppointmentMaintenance();
        manutencaoDaEfetividadePage.adjustEmployeesFrequency();

        driver.quit();
    }

    private void initiatePages() {
        loginPage = new LoginPage(driver, user);
        homePage = new HomePage(driver);
        manutencaoDaEfetividadePage = new ManutencaoDaEfetividadePage(driver);
    }

    private User readConfigurations() {
        ConfigurationProperties configurationProperties = new ConfigurationProperties();

        return new User(configurationProperties.getUser(), configurationProperties.getPassword());
    }
}
