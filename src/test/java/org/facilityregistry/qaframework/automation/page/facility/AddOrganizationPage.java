package org.facilityregistry.qaframework.automation.page.facility;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;

public class AddOrganizationPage extends Page {
    
    private static final String PAGE_PATH = "#/questionnaire/gofr-organization-questionnaire/mcsd-organization";
    
    private static final By FIELD_NAME = By.xpath("(//input[starts-with(@id,'input')])[1]");
    
    private static final By SELECT_TYPE = By.xpath("(//input[starts-with(@id,'input')])[2]");
    
    private static final By BUTTON_SAVE = By
            .xpath("//*[@id='app']/div[1]/main/div/div[6]/form/nav/div[1]/div/div/button[2]");
    
    private static final By MENU_HOME = By.xpath("//*[@id='menu']/li[1]/a/div");
    
    public AddOrganizationPage(Page parent) {
        super(parent);
    }
    
    @Override
    public String getPageUrl() {
        return PAGE_PATH;
    }
    
    public void enterOrgName(String name) throws InterruptedException {
        Thread.sleep(2000);
        setTextToFieldNoEnter(FIELD_NAME, name);
    }
    
    public void selectOrgType() throws InterruptedException {
        selectOptionByJavacript(SELECT_TYPE);
        Thread.sleep(1000);
    }
    
    public void clickSave()  {
        clickByJavacript(BUTTON_SAVE);
    }
    
    public HomePage clickHome() {
        clickByJavacript(MENU_HOME);
        return new HomePage(this);
    }
    
}
