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
	
	private LoginPage loginPage;
	
	private HomePage labHomePage;
	
	@After(RunTest.HOOK.LAB)
	public void destroy() {
		quit();
	}
	
	@Before(RunTest.HOOK.LAB)
	public void setLoginPage() {
		System.out.println("Lab Facility Registry Steps");
		loginPage = new LoginPage(getDriver());
	}
	
	@When("User Logs in into the Lab instance")
	public void login() {
		loginPage.go();
		labHomePage = loginPage.goToHomePage();
	}
	
}
