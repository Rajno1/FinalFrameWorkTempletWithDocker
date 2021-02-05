package com.issi.pages;

import com.issi.enums.WaitStrategy;
import org.openqa.selenium.By;
/**
 * Contains the elements identified of PSMS Home page and action methods created on it
 * And we are using this PSMSHomePage class to manage application logout
 */
public final class PSMSHomePage extends BasePage {
    private final By userActionsBtn = By.xpath("//div[@class='form-inline my-2 my-lg-0 text-right']/div/button[@title='User Actions']");
    private final By logoutlink = By.xpath("//li[contains(text(),'Logout')]");



    public PSMSHomePage cickUserActions(){
        waitupto(6000);
        clickOn(userActionsBtn,WaitStrategy.CLICKABLE," User actions");

            return this;
    }

    public PSMSLoginPage clickLogOut() {
        clickOn(logoutlink,WaitStrategy.CLICKABLE,"logout link");
        return new PSMSLoginPage();
    }
}
