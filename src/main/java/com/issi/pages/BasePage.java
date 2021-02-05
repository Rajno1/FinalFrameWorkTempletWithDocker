package com.issi.pages;

import com.issi.driver.DriverManager;
import com.issi.enums.WaitStrategy;
import com.issi.factories.ExplicitWaitFactory;
import com.issi.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

public class BasePage {
    /**
     * Locates element by given wait strategy, performs the clicking operation on webelement and
     * writes the pass even to the extent report.
     * @param by By Locator of the webelement
     * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.issi.enums.WaitStrategy}
     * @param elementName Name of the element that needs to be logged in the report.
     */
    protected void clickOn(By by, WaitStrategy waitstrategy,String elementName) {
       WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element.click();
        ExtentLogger.pass(" Clicked on " +elementName );
    }

    /**
     * Locates element by given wait strategy, sends the value to located webelement and
     * writes the pass even to the extent report.
     * @param by By Locator of the webelement
     * @param value value to be send the text box
     * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.issi.enums.WaitStrategy}
     * @param elementname Name of the element that needs to be logged in the report.
     */
    protected void enterValue(By by, String value,WaitStrategy waitstrategy, String elementName) {
        WebElement element =ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element.sendKeys(value);
        ExtentLogger.pass("Entered  "+elementName+" as "+value);
    }

    /**
     * Scroll the page based on element
     * @param by By locator of the element
     * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.issi.enums.WaitStrategy}
     */
    protected void scrollByElement(By by,WaitStrategy waitstrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",element);
    }

    /**
     * it will switch the window based on previous window id
     * @param previousWindowId window id of previous window (parent)
     * @return current page window
     */
    protected String switchToWindow(String previousWindowId){
        Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!previousWindowId.equals(windowHandle)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
            }
        }
        return DriverManager.getDriver().getWindowHandle();

    }

    /**
     * select the value from drop down based on its name
     * @param by By locator of the drop down
     * @param enterMenuItem string value of menu that you want to select
     */
    protected void selectMenuItem(By by, String enterMenuItem){
        try {
            List<WebElement> menuList = DriverManager.getDriver().findElements(by);
            for (int i = 0; i < menuList.size(); i++) {
                String menuItem = menuList.get(i).getText();
                if (menuItem.equals(enterMenuItem)) {
                    menuList.get(i).click();
                    ExtentLogger.pass("Selected "+enterMenuItem+" option from menu");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  it will perform mouse over action
     * @param by By locator of the element that we want to mouse over
     * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.issi.enums.WaitStrategy}
     * @param elementName string value of element
     */
    protected void mouseOver(By by,WaitStrategy waitstrategy,String elementName){
        WebElement element =ExplicitWaitFactory.performExplicitWait(by, waitstrategy);
        element = DriverManager.getDriver().findElement(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(element).perform();
        ExtentLogger.pass("Mouse overed on "+elementName+"");
    }

    /**
     *  it will make the script to wait
     * @param time value that we want to make the script to wait
     */
    public static void waitupto(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return page title of webpage in String
     *
     * @return Page title of the webpage where the selenium is currently interacting.
     */
    public String getPage_Title() {
        return DriverManager.getDriver().getTitle();
    }




}
