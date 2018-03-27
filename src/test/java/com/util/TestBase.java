package test.java.com.util;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.com.util.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase{
	
	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeTest
	public void Begin() throws InterruptedException, IOException{
		
		prop =  new Properties();
		FileInputStream ip =  new FileInputStream("\\Users\\Varun.k\\Desktop\\Auto\\TestAuto\\src\\main\\java\\com\\util\\properties\\Config.properties");
		prop.load(ip);
		
		/*String url ="http://10.0.1.40";
	    driver = new FirefoxDriver();
		driver.get(url);*/
		
		//String browsername = prop.getProperty("browser");
		
		driver = new FirefoxDriver();
		driver.get(prop.getProperty("URL"));
		
		
	}
	
    
	
	@Test
	public void TestCases() throws InterruptedException{
		
		re_usables.Login();
		
		//re_usables.DocumentStoppage();
		
		/*re_usables.EnterPriseName();
		
		re_usables.Plant();*/
		
		re_usables.CreateUser();
		
		re_usables.DeleteUser();
		
		
	}
	
	@AfterTest
	public void close(){
		
		driver.quit();
		
	}
	


}
