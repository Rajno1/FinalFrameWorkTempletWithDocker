package com.issi.tests;

import com.issi.annotations.FrameWorkAnnotation;
import com.issi.enums.BrowserType;
import com.issi.enums.CategoryType;
import com.issi.pages.MasterModulePage;
import com.issi.pages.PSMSHomePage;
import org.testng.annotations.Test;

import java.util.Map;
/**
 * Contains the tests related to MasterModule of PSMS application .
 */
public final class MasterModuleTest extends BaseTest{
    private MasterModuleTest() {
    }

    @Test
    @FrameWorkAnnotation(browser = {BrowserType.CHROME},author = {"Rajasekhar"},category = {CategoryType.FUNCTIONAL})
    public void clientTypeTest(Map<String,String> data) {
        new MasterModulePage()
                .clickOnMastermodulebtn()
                .clickOnClientTypeslink()
                .clickOnAddRecordBtn()
                .enterClientTypeText(data.get("clienttype"))
                .enterDescriptiontext(data.get("descriptiontext"))
                .clickOnSaveChangesBtn()
                  .clickOnCloseBtn();
    }
}
