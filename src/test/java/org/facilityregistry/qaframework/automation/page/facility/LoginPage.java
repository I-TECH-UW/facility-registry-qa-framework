package org.facilityregistry.qaframework.automation.page.facility;

import org.facilityregistry.qaframework.automation.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
	
	private static final String PATH_LOGIN = "/#/Login";
	
	private static final By FIELD_USERNAME = By.id("input-34");
	
	private static final By FIELD_PASSWORD = By.id("input-37");
	
	private static final By BUTTON_SUBMIT = By
	        .xpath("//*[@id='app']/div/main/div/div[6]/center/div[2]/div[3]/header/div/button");
	
	static final String LOGOUT_PATH = "/logout";
	
	private String username;
	
	private String password;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		username = properties.getFacilityUsername();
		password = properties.getFacilityPassword();
	}
	
	public String getUsername() {
		return username;
	}
	
	@Override
	public void go() {
		goToFacilityPage(PATH_LOGIN);
	}
	
	@Override
	public String getPageUrl() {
		return PATH_LOGIN;
	}
	
	public void enterUsername(String username) {
		setTextToFieldNoEnter(FIELD_USERNAME, username);
	}
	
	public void enterPassword(String password) {
		setTextToFieldNoEnter(FIELD_PASSWORD, password);
	}
	
	public WebElement getLoginButton() {
		return findElement(BUTTON_SUBMIT);
	}
	
	public HomePage goToHomePage() {
		go();
		enterUsername(this.username);
		enterPassword(this.password);
		clickOn(BUTTON_SUBMIT);
		return new HomePage(this);
	}
}
