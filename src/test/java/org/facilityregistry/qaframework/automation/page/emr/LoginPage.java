package org.facilityregistry.qaframework.automation.page.emr;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the Login page
 */
public class LoginPage extends Page {
	
	private final String LOGIN_PATH = "/login.htm";
	
	private final String LOGOUT_PATH = "/logout";
	
	private final By FIELD_USERNAME = By.cssSelector("#login-form input#username");
	
	private final By FIELD_PASSWORD = By.cssSelector("#login-form input#password");
	
	private final By BUTTON_LOGIN = By.id("loginButton");
	
	private final By LOCATIONS = By.cssSelector("#sessionLocation li");
	
	private String username;
	
	private String password;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		username = properties.getEmrUsername();
		password = properties.getEmrPassword();
	}
	
	@Override
	public void go() {
		goToEmrPage(LOGIN_PATH);
	}
	
	@Override
	public String getPageUrl() {
		return LOGIN_PATH;
	}
	
	@Override
	public String getPageRejectUrl() {
		return "index.htm";
	}
	
	public void enterUsername(String username) {
		setTextToFieldNoEnter(FIELD_USERNAME, username);
	}
	
	public void enterPassword(String password) {
		setTextToFieldNoEnter(FIELD_PASSWORD, password);
	}
	
	public void clickLoginButton() {
		clickOn(BUTTON_LOGIN);
	}
	
	public void selectLocation() {
		clickOn(LOCATIONS);
	}
	
	public HomePage goToHomePage() {
		go();
		enterUsername(this.username);
		enterPassword(this.password);
		selectLocation();
		clickLoginButton();
		return new HomePage(this);
	}
	
}
