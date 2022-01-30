package org.facilityregistry.qaframework.automation.page.emr;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;

public class ManageLocationsPage extends Page {
    
    protected static final String PAGE_URL = "/adminui/metadata/locations/manageLocations.page";
    
    private static final By TABLE_LOCATIONS = By.id("list-locations");
    
    public ManageLocationsPage(Page parent) {
        super(parent);
    }
    
    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }
    
    public Boolean locationExists(String location) {
        // waitForTextToBePresentInElement(TABLE_LOCATIONS, location);
        return containsText(location);
    }
    
}
