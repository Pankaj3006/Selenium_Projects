package Automation_Testing_Demo;

import java.net.URL;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sauce_labs {

	public static final String USERNAME = "rahul1";
    public static final String ACCESS_KEY = "99f4d2f8-f4c8-4ff8-9691-6ba7416d00ca";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
    public static void main(String[] args) throws MalformedURLException {
		
    	DesiredCapabilities caps = DesiredCapabilities.chrome();

    	caps.setCapability("platform", "Windows 7");

    	caps.setCapability("version", "51.0");

    	WebDriver driver=new RemoteWebDriver(new URL(URL), caps);

    	driver.get("http://google.com");

    	System.out.println(driver.getTitle());
    	
}

}
