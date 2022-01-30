package org.facilityregistry.qaframework.automation;

import static org.junit.Assert.assertTrue;

import org.facilityregistry.qaframework.RunTest;
import org.facilityregistry.qaframework.automation.page.emr.HomePage;
import org.facilityregistry.qaframework.automation.page.emr.LoginPage;
import org.facilityregistry.qaframework.automation.test.RemoteTestBase;
import org.facilityregistry.qaframework.automation.page.emr.ConfigureMetadataPage;
import org.facilityregistry.qaframework.automation.page.emr.ManageLocationsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmrSteps extends RemoteTestBase {
	
	private LoginPage emrLoginPage;
	
	private HomePage emrHomePage;
	
	private ConfigureMetadataPage configureMetadataPage;
	
	private ManageLocationsPage manageLocationsPage;
	
	@After(RunTest.HOOK.EMR)
	public void destroy() {
		quit();
	}
	
	@Before(RunTest.HOOK.EMR)
	public void setLoginPage() {
		System.out.println("EMR Facility Registry Steps");
		emrLoginPage = new LoginPage(getDriver());
	}
	
	@When("User Logs in into the EMR")
	public void logintoEmr() throws InterruptedException {
		emrLoginPage.go();
		emrHomePage = emrLoginPage.goToHomePage();
	}
	
	@And("User goes to the Manage Locations Page")
	public void goToManageLOcations() {
		configureMetadataPage = emrHomePage.goToConfigureMetadata();
		manageLocationsPage = configureMetadataPage.goToManageLocations();
	}
	
	@Then("Facility {string} should exist in EMR instance")
	public void facilityExists(String location) {
		assertTrue(manageLocationsPage.locationExists(location));
	}
	
}
