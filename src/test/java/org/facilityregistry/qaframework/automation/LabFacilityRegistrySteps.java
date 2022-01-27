package org.facilityregistry.qaframework.automation;

import static org.junit.Assert.assertTrue;

import org.facilityregistry.qaframework.RunTest;
import org.facilityregistry.qaframework.automation.page.lab.HomePage;
import org.facilityregistry.qaframework.automation.page.lab.LoginPage;
import org.facilityregistry.qaframework.automation.test.RemoteTestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LabFacilityRegistrySteps extends RemoteTestBase {

    private LoginPage labLoginPage;
	
	private HomePage labHomePage;

	private org.facilityregistry.qaframework.automation.page.facility.LoginPage facilityLoginPage;
	
	private org.facilityregistry.qaframework.automation.page.facility.HomePage facilityHomePage;
	
	@After(RunTest.HOOK.LAB)
	public void destroy() {
		quit();
	}
	
	@Before(RunTest.HOOK.LAB)
	public void setLoginPage() {
		System.out.println("Lab Facility Registry Steps");
		labLoginPage = new LoginPage(getDriver());	
		facilityLoginPage = new org.facilityregistry.qaframework.automation.page.facility.LoginPage(getDriver());
	}

	@When("User Logs in into the Facility Registry")
	public void loginToFacility() throws InterruptedException {
		facilityLoginPage.go();
		facilityHomePage = facilityLoginPage.goToHomePage();
	}
	
	
	@When("User Logs in into the Lab instance")
	public void login() {
		labLoginPage.go();
		labHomePage = labLoginPage.goToHomePage();
	}
    
}
