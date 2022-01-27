package org.facilityregistry.qaframework.automation;

import static org.junit.Assert.assertTrue;

import org.facilityregistry.qaframework.RunTest;
import org.facilityregistry.qaframework.automation.page.emr.HomePage;
import org.facilityregistry.qaframework.automation.page.emr.LoginPage;
import org.facilityregistry.qaframework.automation.page.facility.AddFacilityPage;
import org.facilityregistry.qaframework.automation.page.facility.AddOrganizationPage;
import org.facilityregistry.qaframework.automation.test.RemoteTestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmrFacilityRegistrySteps extends RemoteTestBase {
	
	private LoginPage emrLoginPage;
	
	private HomePage emrHomePage;
	
	private org.facilityregistry.qaframework.automation.page.facility.LoginPage facilityLoginPage;
	
	private org.facilityregistry.qaframework.automation.page.facility.HomePage facilityHomePage;
	
	private AddOrganizationPage addOrgPage;
	
	private AddFacilityPage addFacilityPage;
	
	@After(RunTest.HOOK.EMR)
	public void destroy() {
		quit();
	}
	
	@Before(RunTest.HOOK.EMR)
	public void setLoginPage() {
		System.out.println("EMR Facility Registry Steps");
		emrLoginPage = new LoginPage(getDriver());
		facilityLoginPage = new org.facilityregistry.qaframework.automation.page.facility.LoginPage(getDriver());
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
	
	@Then("User Enters Organization Details")
	public void addOrganization() throws InterruptedException {
		addOrgPage.enterOrgName("test Org");
		addOrgPage.selectOrgType();
		addOrgPage.clickSave();
		addOrgPage.clickHome();
	}
	
	@When("User Clicks 'Add Facility'")
	public void clickAddFacility() throws InterruptedException {
		addFacilityPage = facilityHomePage.clickAddFacility();
	}
	
	@Then("User Enters Facility Details")
	public void addFacility() throws InterruptedException {
		addFacilityPage.enterFacilityName("test Facility");
		addFacilityPage.enterFacilityDescription("description");
		addFacilityPage.selectFacilityStatus();
		addFacilityPage.selectFacilityType();
		addFacilityPage.clickAddManagingOrg();
		addFacilityPage.selectManagingOrg();
		addFacilityPage.clickSave();
	}
	
	@When("User Logs in into the EMR")
	public void logintoEmr() {
		emrLoginPage.go();
		emrHomePage = emrLoginPage.goToHomePage();
	}
	
}
