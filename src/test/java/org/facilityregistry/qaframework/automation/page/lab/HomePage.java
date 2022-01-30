package org.facilityregistry.qaframework.automation.page.lab;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage extends Page {
	
	private static final String PATH_HOME = "/Dashboard.do";
	
	private static final By MENU_ADMIN = By.id("menu_administration");
	
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
	
	public AdminPage goToAdminPage() {
		clickOn(MENU_ADMIN);
		return new AdminPage(this);
	}
}
