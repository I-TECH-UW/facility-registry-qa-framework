package org.facilityregistry.qaframework.automation.page.facility;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage extends Page{

    private static final String PATH_HOME = "/Dashboard.do";

    public HomePage(Page page) {
		super(page);
	}
	
	@Override
	public String getPageUrl() {
		return PATH_HOME;
	}
	
	public WebElement getLogOutLink() {
		return findElement(By.id("logout-form"));
	} 
    
}
