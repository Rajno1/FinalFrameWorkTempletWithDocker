package com.issi.pages;

import com.issi.enums.WaitStrategy;
import org.openqa.selenium.By;
/**
 * Contains the elements identified of PSMS Login page and action methods created on it
 */
public final class PSMSLoginPage extends BasePage {

    private final By textboxUsername = By.id("id_uname");
    private final By textboxPassword = By.id("id_password");
    private final By buttonLogin = By.xpath("//span[text()='SIGN-IN']/parent::button");

    public PSMSLoginPage enterUserName(String username) {
        enterValue(textboxUsername, username, WaitStrategy.PRESENCE,"username");
        waitupto(500);
        return this; // this line is same as 'return new OrangeHRMLoginPage'
    }

    public PSMSLoginPage enterPassword(String password) {
        enterValue(textboxPassword, password,WaitStrategy.PRESENCE,"password");
        waitupto(500);
        return this;
    }

    public PSMSHomePage clickLogin() {
        clickOn(buttonLogin,WaitStrategy.PRESENCE,"loign button");
        return new PSMSHomePage();  // for method chaining
    }

}
