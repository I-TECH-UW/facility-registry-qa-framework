package org.facilityregistry.qaframework.automation;

import static org.junit.Assert.assertTrue;
import org.facilityregistry.qaframework.RunTest;
import org.facilityregistry.qaframework.automation.page.lab.AdminPage;
import org.facilityregistry.qaframework.automation.page.lab.HomePage;
import org.facilityregistry.qaframework.automation.page.lab.LoginPage;
import org.facilityregistry.qaframework.automation.test.RemoteTestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LabSteps extends RemoteTestBase {
	
	private LoginPage labLoginPage;
	
	private HomePage labHomePage;
	
	private AdminPage adminPage;
	
	@After(RunTest.HOOK.LAB)
	public void destroy() {
		quit();
	}
	
	@Before(RunTest.HOOK.LAB)
	public void setLoginPage() {
		System.out.println("Lab Facility Registry Steps");
		labLoginPage = new LoginPage(getDriver());
	}
	
	@When("User Logs in into the Lab instance")
	public void login() {
		labLoginPage.go();
		labHomePage = labLoginPage.goToHomePage();
	}
	
	@And("User goes to the Admininistration Page")
	public void goToManageLOcations() {
		adminPage = labHomePage.goToAdminPage();
		adminPage.clickOnOrganizationMenu();
	}
	
	@Then("Facility {string} should exist in Lab instance")
	public void facilityExists(String location) {
		adminPage.enterSearchString(location);
		adminPage.clickSearch();
		assertTrue(adminPage.locationExists(location));
	}
	
}
