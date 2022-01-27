package org.facilityregistry.qaframework.automation.page.facility;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage extends Page {
	
	private static final String PATH_HOME = "/#/home";
	
	private static final By MENU_FACILITY = By.xpath("//*[@id='menu']/li[3]/a");
	
	private static final By SUB_MENU_FACILITY_ADD_ORG = By.xpath("//*[@id='menu']/li[3]/ul/div[3]/a/div");

	private static final By SUB_MENU_FACILITY_ADD_FACILITY = By.xpath("//*[@id='menu']/li[3]/ul/div[2]/a/div");
	
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
	
	public AddOrganizationPage clickAddOrg() throws InterruptedException {
		Thread.sleep(2000);
		hoverOn(MENU_FACILITY);
		Thread.sleep(2000);
		clickOn(SUB_MENU_FACILITY_ADD_ORG);
		return new AddOrganizationPage(this);
	}

	public AddFacilityPage clickAddFacility() throws InterruptedException {
		Thread.sleep(2000);
		hoverOn(MENU_FACILITY);
		Thread.sleep(2000);
		clickOn(SUB_MENU_FACILITY_ADD_FACILITY);
		return new AddFacilityPage(this);
	}
	
}
