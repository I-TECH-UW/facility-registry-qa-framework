package org.facilityregistry.qaframework.automation.page.emr;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;

/**
 * This class represents the Home page
 */
public class HomePage extends Page {
	
	private final By LINK_LOGOUT = By.className("logout");
	
	private final String PATH_HOME = "/referenceapplication/home.page";

	private static final By CONFIGURE_METADATA_APP = By.id("org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension");
	
	
	public HomePage(Page page) {
		super(page);
	}
	
	@Override
	public String getPageUrl() {
		return PATH_HOME;
	}
	
	public Boolean hasLogOutLink() {
		return hasElement(LINK_LOGOUT);
	}
	
	public void clickLogout() {
		goToEmrPage("appui/header/logout.action?successUrl=openmrs");
	}
	
	public ConfigureMetadataPage goToConfigureMetadata() {
		clickOn(CONFIGURE_METADATA_APP);
		return new ConfigureMetadataPage(this);
	}
	
}
