package com.mob.auto;

import java.net.MalformedURLException;
import java.net.URL;

//import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.mobile.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;;


public class Testmob {
	
	public RemoteWebDriver driver;
	
	@AfterTest
	public void openApp() throws MalformedURLException{
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", "Android");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("BrowserName", "");
		capabilities.setCapability("App", "");
		
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
	}
	
	@org.testng.annotations.Test
	public void TestCases(){
		
		
		
		
		
		
	}

}
