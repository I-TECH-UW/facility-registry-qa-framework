package org.facilityregistry.qaframework.automation;

import org.facilityregistry.qaframework.automation.page.emr.ConfigureMetadataPage;
import org.facilityregistry.qaframework.automation.page.emr.ManageLocationsPage;
import org.facilityregistry.qaframework.automation.page.facility.LoginPage;
import org.facilityregistry.qaframework.automation.test.RemoteTestBase;
import org.facilityregistry.qaframework.automation.page.facility.HomePage;
import org.facilityregistry.qaframework.automation.page.facility.AddFacilityPage;
import org.facilityregistry.qaframework.automation.page.facility.AddOrganizationPage;

import org.facilityregistry.qaframework.RunTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacilityRegistrySteps extends RemoteTestBase {
	
	private LoginPage facilityLoginPage;
	
	private HomePage facilityHomePage;
	
	private AddOrganizationPage addOrgPage;
	
	private AddFacilityPage addFacilityPage;
	
	@Before(RunTest.HOOK.FACILITY)
	public void setLoginPage() {
		System.out.println("Facility Registry Steps");
		facilityLoginPage = new LoginPage(getDriver());
	}
	
	@After(RunTest.HOOK.FACILITY)
	public void destroy() {
		quit();
	}
	
	@When("User Logs in into the Facility Registry instance")
	public void loginToFacility() {
		facilityLoginPage.go();
		facilityHomePage = facilityLoginPage.goToHomePage();
	}
	
	@And("User Clicks 'Add Organization'")
	public void clickAddOrganization() throws InterruptedException {
		addOrgPage = facilityHomePage.clickAddOrg();
	}
	
	@Then("User Enters Organization Details with {string}")
	public void addOrganization(String orgName) throws InterruptedException {
		addOrgPage.enterOrgName(orgName);
		addOrgPage.selectOrgType();
		addOrgPage.clickSave();
		addOrgPage.clickHome();
	}
	
	@When("User Clicks 'Add Facility'")
	public void clickAddFacility() throws InterruptedException {
		addFacilityPage = facilityHomePage.clickAddFacility();
	}
	
	@Then("User Enters Facility Details with {string}")
	public void addFacility(String facilityName) throws InterruptedException {
		addFacilityPage.enterFacilityName(facilityName);
		addFacilityPage.enterFacilityDescription("Demo Facility");
		addFacilityPage.selectFacilityStatus();
		addFacilityPage.selectFacilityType();
		addFacilityPage.clickAddManagingOrg();
		addFacilityPage.selectManagingOrg();
		addFacilityPage.clickSave();
	}
	
}
