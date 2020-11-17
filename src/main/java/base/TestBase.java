package base;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import helpers.JsonParser;

public class TestBase {
	
	protected static WebDriver driver;
	static String browserType;
	public static Map<String, String> testDataDetails;

	static {
		
		JsonParser j = new JsonParser();
		String s = JsonParser.readJson("testdata.json");
		testDataDetails = j.publishAllXpathInResponse(s);
	}
	
	
	public  static WebDriver setUp() {
		if (driver == null) {
			browserType = testDataDetails.get("TestData.Browser.type");
			if(browserType.equals("Firefox"))
			{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);

			driver = new FirefoxDriver(options);
			}
		}
		return driver;
		
	}

	public void launchBaseUrl() {
		driver.get(testDataDetails.get("TestData.Browser.devserver"));		
	}
	
	public void quitDriver(){
        driver.quit();
    }

}
