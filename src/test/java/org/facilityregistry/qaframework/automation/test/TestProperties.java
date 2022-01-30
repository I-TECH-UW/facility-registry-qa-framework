package org.facilityregistry.qaframework.automation.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

public class TestProperties {
	
	//emr
	public static final String EMR_PASSWORD_PROPERTY = "emr.password";
	
	public static final String DEFAULT_EMR_PASSWORD = "Admin123";
	
	public static final String EMR_USERNAME_PROPERTY = "emr.username";
	
	public static final String DEFAULT_EMR_USERNAME = "admin";
	
	public static final String EMR_URL_PROPERTY = "emr.url";
	
	public static final String DEFAULT_EMR_URL = "http://35.83.181.154:8090/openmrs/";
	
	//lab
	public static final String LAB_PASSWORD_PROPERTY = "lab.password";
	
	public static final String DEFAULT_LAB_PASSWORD = "adminADMIN!";
	
	public static final String LAB_USERNAME_PROPERTY = "lab.username";
	
	public static final String DEFAULT_LAB_USERNAME = "admin";
	
	public static final String LAB_URL_PROPERTY = "lab.url";
	
	public static final String DEFAULT_LAB_URL = "https://35.83.181.154:8443/";
	
	//facility
	public static final String FACILITY_PASSWORD_PROPERTY = "facility.password";
	
	public static final String DEFAULT_FACILITY_PASSWORD = "gofr";
	
	public static final String FACILITY_USERNAME_PROPERTY = "facility.username";
	
	public static final String DEFAULT_FACILITY_USERNAME = "root@gofr.org";
	
	public static final String FACILITY_URL_PROPERTY = "facility.url";
	
	public static final String DEFAULT_FACILITY_URL = "http://35.83.181.154:4000/";
	
	public static final String POLIING_INTERVAL_PROPERTY = "polling.interval";
	
	public static final String DEFAULT_POLIING_INTERVAL = "5";
	
	private static TestProperties SINGLETON;
	
	private Properties properties;
	
	public TestProperties() {
		properties = new Properties();
		try {
			URL resource = Thread.currentThread().getContextClassLoader().getResource("test.properties");
			if (resource != null) {
				System.out.println("Found properties file: " + resource.getPath());
				InputStream input = resource.openStream();
				properties.load(new InputStreamReader(input, "UTF-8"));
			}
		}
		catch (IOException ioException) {
			throw new RuntimeException("Could not find test.properties", ioException);
		}
	}
	
	public static TestProperties instance() {
		if (SINGLETON == null) {
			SINGLETON = new TestProperties();
		}
		return SINGLETON;
	}
	
	public String getEmrUrl() {
		return getProperty(EMR_URL_PROPERTY, DEFAULT_EMR_URL);
	}
	
	public String getEmrUsername() {
		return getProperty(EMR_USERNAME_PROPERTY, DEFAULT_EMR_USERNAME);
	}
	
	public String getEmrPassword() {
		return getProperty(EMR_PASSWORD_PROPERTY, DEFAULT_EMR_PASSWORD);
	}
	
	public String getLabUrl() {
		return getProperty(LAB_URL_PROPERTY, DEFAULT_LAB_URL);
	}
	
	public String getLabUsername() {
		return getProperty(LAB_USERNAME_PROPERTY, DEFAULT_LAB_USERNAME);
	}
	
	public String getLabPassword() {
		return getProperty(LAB_PASSWORD_PROPERTY, DEFAULT_LAB_PASSWORD);
	}
	
	public String getFacilityUrl() {
		return getProperty(FACILITY_URL_PROPERTY, DEFAULT_FACILITY_URL);
	}
	
	public String getFacilityUsername() {
		return getProperty(FACILITY_USERNAME_PROPERTY, DEFAULT_FACILITY_USERNAME);
	}
	
	public String getFacilityPassword() {
		return getProperty(FACILITY_PASSWORD_PROPERTY, DEFAULT_FACILITY_PASSWORD);
	}
	
	public int getPolingInterval() {
		return Integer.valueOf(getProperty(POLIING_INTERVAL_PROPERTY, DEFAULT_POLIING_INTERVAL));
	}
	
	public String getProperty(String property, String defaultValue) {
		String value = properties.getProperty(property);
		
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}
	
}
