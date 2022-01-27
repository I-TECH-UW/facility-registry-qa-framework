package org.facilityregistry.qaframework.automation.page.facility;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;

public class AddFacilityPage extends Page {
    
    private static final String PAGE_PATH = "#/questionnaire/gofr-facility-questionnaire/facility";
    
    private static final By FIELD_NAME = By.xpath("(//input[starts-with(@id,'input')])[1]");
    
    private static final By FIELD_DESCRIPTION = By.xpath("(//textarea[starts-with(@id,'input')])[1]");
    
    private static final By SELECT_STATUS = By.xpath("(//input[starts-with(@id,'input')])[2]");
    
    private static final By SELECT_FACILITY_TYPE = By.xpath("(//input[starts-with(@id,'input')])[3]");
    
    private static final By BUTTON_ADD_ORG = By.xpath("(//button[starts-with(@class,'v-btn')])[8]");
    
    private static final By SELECT_ORGANIZATION = By.xpath("(//input[starts-with(@id,'input')])[21]");
    
    private static final By SELECT_ORGANIZATION_TYPE = By.xpath("(//input[starts-with(@id,'input')])[22]");
    
    private static final By BUTTON_SAVE = By
            .xpath("//*[@id='app']/div[1]/main/div/div[6]/form/nav/div[1]/div/div/button[2]");
    
    private static final By SELECT_ORGANIZATION_VALUE = By.xpath("//*[@id='app']/div[5]/div/div/div[2]/div/div[2]/div");
    
    public AddFacilityPage(Page parent) {
        super(parent);
    }
    
    @Override
    public String getPageUrl() {
        return PAGE_PATH;
    }
    
    public void enterFacilityName(String name) throws InterruptedException {
        Thread.sleep(2000);
        setTextToFieldNoEnter(FIELD_NAME, name);
    }
    
    public void enterFacilityDescription(String description) throws InterruptedException {
        Thread.sleep(2000);
        setTextToFieldNoEnter(FIELD_DESCRIPTION, description);
    }
    
    public void selectFacilityStatus() throws InterruptedException {
        selectOptionByJavacript(SELECT_STATUS);
        Thread.sleep(1000);
    }
    
    public void selectFacilityType() throws InterruptedException {
        selectOptionByJavacript(SELECT_FACILITY_TYPE);
        Thread.sleep(1000);
    }
    
    public void clickAddManagingOrg() {
        clickByJavacript(BUTTON_ADD_ORG);
    }
    
    public void selectManagingOrg() throws InterruptedException {
        Thread.sleep(2000);
        selectOptionByAction(SELECT_ORGANIZATION, SELECT_ORGANIZATION_VALUE);
        Thread.sleep(2000);
        selectOptionByJavacript(SELECT_ORGANIZATION_TYPE);
    }
    
    public void clickSave() throws InterruptedException {
        Thread.sleep(2000);
        clickByJavacript(BUTTON_SAVE);
    }
    
}
