package org.facilityregistry.qaframework.automation.page.lab;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage extends Page {
    
    private static final String PAGE_PATH = "MasterListsPage.do";
    
    private static final By MENU_ORGAIZATION = By.xpath("//a[contains(text(),'Organization')]");
    
    private static final By FIELD_SEARCH = By.id("searchString");
    
    private static final By BUTTON_SEARCH = By.id("searchButton");
    
    public AdminPage(Page parent) {
        super(parent);
    }
    
    @Override
    public String getPageUrl() {
        return PAGE_PATH;
    }
    
    public void clickOnOrganizationMenu() {
        clickOn(MENU_ORGAIZATION);
    }
    
    public void enterSearchString(String location) {
        setTextToFieldNoEnter(FIELD_SEARCH, location);
    }
    
    public void clickSearch() {
        clickOn(BUTTON_SEARCH);
    }
    
    public Boolean locationExists(String location) {
        // waitForTextToBePresentInElement(TABLE_LOCATIONS, location);
        return containsText(location);
    }
}
