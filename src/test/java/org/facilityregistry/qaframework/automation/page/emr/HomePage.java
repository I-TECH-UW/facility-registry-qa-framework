package org.facilityregistry.qaframework.automation.page.emr;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;

/**
 * This class represents the Home page
 */
public class HomePage extends Page {
	

	
	private final By LINK_LOGOUT = By.className("logout");
	
	private final String PATH_HOME_RESET = "referenceapplication/home.page?noredirect=true";
	
	private final By FIELD_OLD_PASSWORD = By.xpath("//input[@id='oldPassword-field']");
	
	private final By FIELD_NEW_PASSWORD = By.xpath("//input[@id='newPassword-field']");
	
	private final By FIELD_CONFIRM_PASSWORD = By.xpath("//input[@id='confirmPassword-field']");
	
	private static final By SAVE_BUTTON = By.id("save-button");
	
	private final String PATH_HOME = "/referenceapplication/home.page";
	
	
	public HomePage(Page page) {
		super(page);
	}
	
	@Override
	public String getPageUrl() {
		return PATH_HOME;
	}
	
	public String getPageUrlReset() {
		return PATH_HOME_RESET;
	}
	
	public Boolean hasLogOutLink() {
		return hasElement(LINK_LOGOUT);
	}
	
	public void clickLogout() {
		goToPage("appui/header/logout.action?successUrl=openmrs");
	}
	

	
	public void enterOldPassword(String oldPassword) {
		setText(FIELD_OLD_PASSWORD, oldPassword);
	}
	
	public void enterNewPassword(String newPassword) {
		setText(FIELD_NEW_PASSWORD, newPassword);
	}
	
	public void confirmNewPassword(String confirmPassword) {
		setText(FIELD_CONFIRM_PASSWORD, confirmPassword);
	}
	
	
	public String savePassword() {
		clickOn(SAVE_BUTTON);
		return "index.html";
	}
	
}
