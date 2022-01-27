package org.facilityregistry.qaframework.automation;

import org.facilityregistry.qaframework.automation.page.facility.LoginPage;

import org.facilityregistry.qaframework.automation.page.facility.HomePage;

import static org.junit.Assert.assertTrue;

import org.facilityregistry.qaframework.RunTest;
import org.facilityregistry.qaframework.automation.test.RemoteTestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacilityRegistrySteps extends RemoteTestBase {
	
	private LoginPage facilityLoginPage;
	
	private HomePage facilityHomePage;
	
	@After()
	public void destroy() {
		quit();
	}
	
	@Before()
	public void setLoginPage() {
		System.out.println("Facility Registry Steps");
		facilityLoginPage = new LoginPage(getDriver());
	}
	
	@When("User Logs in into the Facility Registry instance")
	public void loginToFacility() {
		facilityLoginPage.go();
		facilityHomePage = facilityLoginPage.goToHomePage();
	}
	
}
