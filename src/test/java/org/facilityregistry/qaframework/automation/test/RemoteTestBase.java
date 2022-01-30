package org.facilityregistry.qaframework.automation.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.facilityregistry.qaframework.automation.page.Page;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteTestBase implements ITestBase {
	
	public static final int MAX_WAIT_IN_SECONDS = 120;
	
	public static final int MAX_PAGE_LOAD_IN_SECONDS = 120;
	
	public static final String REMOTE_URL_CHROME = "http://localhost:4444/wd/hub";
	
	public static String REMOTE_URL_FIREFOX = "http://localhost:4445/wd/hub";
	
	public static final int MAX_SERVER_STARTUP_IN_MILLISECONDS = 10 * 60 * 1000;
	
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public RemoteTestBase() {
		try {
			setup();
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Before
	public void setup() throws Exception {
		setupThread();
	}
	
	@After
	public void teardown() {
		quit();
	}
	
	/**
	 * Assert we're on the expected page.
	 * 
	 * @param expected page
	 */
	public void assertPage(Page expected) {
		assertTrue(getDriver().getCurrentUrl().contains(expected.getPageUrl()));
	}
	
	protected void quit() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
	
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
	}
	
	protected void setupThread() throws MalformedURLException {
		System.out.println("Inside Chrome");
		ChromeOptions options = new ChromeOptions();
		String url = System.getenv("REMOTE_URL_CHROME");
		if (url == null || url.isEmpty()) {
			url = REMOTE_URL_CHROME;
		}
		driver.set(new RemoteWebDriver(new URL(url), options));
		
	}
	
	protected WebDriver getDriver() {
		return driver.get();
	}
}
