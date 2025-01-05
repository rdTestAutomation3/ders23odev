package common;

import driver.DriverFactory;
import pages.ButtonPage;
import pages.WebTablePage;

public class PageManager {
    public ButtonPage buttonPage;

    public WebTablePage webTablePage;

    public PageManager() {

        DriverFactory.initDriver();

        buttonPage = PageFactory.buildButtonPage();
        webTablePage = PageFactory.buildWebTablePage();

    }
}