package com.issi.pages;

import com.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class MasterModulePage extends BasePage {
    /**
     * Elements identified for submodule client type of MasterModule
     */
    private final By masterModuleBtn = By.xpath("//button[@name='btn-Master']");
    private final By clientTypeslink = By.xpath("//*[@id='menu-MasterBar']/div[3]/ul/a[1]/li");
    private final By addRecordbtn = By.xpath("//button[@title='Add Record']");
    private final By clientTypeText = By.xpath("//input[@name='nm_client_type']");
    private final By descriptionText = By.xpath("//textarea[@name='client_desc']");
    private final By savechangesbtn = By.id("id_btnsubmit");
    private final By closeBtn = By.xpath("//button/span[@aria-hidden='true']");

    /**
     *
     * Actions methods of ClientType module elements
     */
    public MasterModulePage clickOnMastermodulebtn(){
        clickOn(masterModuleBtn, WaitStrategy.CLICKABLE,"Master module button");
        return this;
    }
    public MasterModulePage clickOnClientTypeslink(){
        clickOn(clientTypeslink,WaitStrategy.CLICKABLE,"Client types link");
        return this;
    }
    public MasterModulePage clickOnAddRecordBtn(){
        clickOn(addRecordbtn,WaitStrategy.CLICKABLE,"Add record button");
        return this;
    }

    public MasterModulePage enterClientTypeText(String value){
        enterValue(clientTypeText,value,WaitStrategy.PRESENCE,"Client type");
        return this;
    }

    public MasterModulePage enterDescriptiontext(String value){
        enterValue(descriptionText,value,WaitStrategy.PRESENCE,"Client type");
        return this;
    }

    public MasterModulePage clickOnSaveChangesBtn(){
        clickOn(savechangesbtn,WaitStrategy.CLICKABLE,"Save Changes");
        return this;
    }

    public MasterModulePage clickOnCloseBtn(){
        clickOn(closeBtn,WaitStrategy.CLICKABLE,"close button");
        return this;
    }

    
}
