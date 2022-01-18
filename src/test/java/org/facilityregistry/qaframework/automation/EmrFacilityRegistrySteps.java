package org.facilityregistry.qaframework.automation;

import static org.junit.Assert.assertTrue;

import org.facilityregistry.qaframework.RunTest;
import org.facilityregistry.qaframework.automation.page.emr.HomePage;
import org.facilityregistry.qaframework.automation.page.emr.LoginPage;
import org.facilityregistry.qaframework.automation.test.RemoteTestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmrFacilityRegistrySteps extends RemoteTestBase {
	
	private LoginPage loginPage;
	
	private HomePage homePage;
	
	@After(RunTest.HOOK.FR_EMR)
	public void destroy() {
		quit();
	}
	
	@Before(RunTest.HOOK.FR_EMR)
	public void setLoginPage() {
		System.out.println(" EMR Facility Registry Steps");
		loginPage = new LoginPage(getDriver());
		loginPage.go();
	}
	
	
	@When("User Logs in into the EMR")
	public void login() {
		homePage = loginPage.goToHomePage();
	}
	
}
