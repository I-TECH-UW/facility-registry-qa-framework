package org.facilityregistry.qaframework.automation.page.emr;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;

public class ConfigureMetadataPage extends Page {

    protected static final String PAGE_URL = "adminui/metadata/configureMetadata.page";

    private static final By MANAGE_LOCATIONS_LINK = By.id("org-openmrs-module-adminui-manageLocations-link-org-openmrs-module-adminui-manageLocations-link-extension");

    public ConfigureMetadataPage(Page parent) {
		super(parent);
	}

	@Override
	public String getPageUrl() {
		return PAGE_URL;
	}

    public ManageLocationsPage goToManageLocations() {
		clickOn(MANAGE_LOCATIONS_LINK);
		return new ManageLocationsPage(this);
	}
    
}
