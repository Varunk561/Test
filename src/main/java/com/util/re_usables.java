package com.util;

import java.awt.Desktop.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class re_usables extends TestBase {
	
	public static void Login() throws InterruptedException{
		
		Thread.sleep(1000);
	
		WebElement verify=driver.findElement(By.xpath("//*[@class='text-center mb-0']"));
		String a =verify.getText();
		
		
		if (a.equalsIgnoreCase("Downtime Reason Module")) {
			
			System.out.println("Login page verified");
			
		}else{
			
			System.out.println("Not verified");
		}
		
		WebElement username= driver.findElement(By.xpath("//*[@*='dtr-input ng-untouched ng-pristine ng-invalid']"));
		
		username.click();
		username.sendKeys(prop.getProperty("Username"));
		
		WebElement pwd = driver.findElement(By.xpath("//*[@*='password']"));
		pwd.click();
		pwd.sendKeys(prop.getProperty("Password"));
		
		WebElement submit = driver.findElement(By.xpath("//*[@*='btn btn-primary btn-block']"));
		submit.click();
		
		Thread.sleep(2000);
	}
	
	
	public static void DocumentStoppage() throws InterruptedException{
		
		
		WebElement dcmntbtn = driver.findElement(By.xpath("//*[@*='ml-sm-auto secondary-icon button-click ng-star-inserted']"));
		dcmntbtn.click();
		Thread.sleep(1000);
		
		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='main']/app-stoppage/div/div/div/app-create-stoppage/div/div/div/div/form/div[1]/div[1]/div[2]/div/kendo-dropdownlist/span/span[2]")));
		dropdown.selectByValue("Production Line 1");
	}
	

	public static void EnterPriseName() throws InterruptedException{
		
		
		WebElement config = driver.findElement(By.xpath("//span[contains(text(),'Configuration')]"));
		config.click();
		Thread.sleep(1000);
		WebElement enterprise = driver.findElement(By.xpath("//*[@*='ng-tns-c8-16 k-link']"));
		enterprise.click();
		
		/*Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@*='ng-tns-c8-16 k-link']"))).doubleClick();*/
		
		System.out.println("coming here");
		
		WebElement name = driver.findElement(By.xpath("//*[@name='CorporationName']"));
		name.clear();
		name.sendKeys("titan");
	}
	
	public static void Plant() throws InterruptedException {
		
		WebElement config = driver.findElement(By.xpath("//*[@*='ng-tns-c8-14 k-link k-header']"));
		config.click();
		WebElement enterprise = driver.findElement(By.xpath("//*[@*='ng-tns-c8-16 k-link']"));
		enterprise.click();
		WebElement plant = driver.findElement(By.xpath("//*[@*='ng-tns-c8-17 k-link k-state-selected']"));
		plant.click();
		WebElement addplant = driver.findElement(By.xpath("//*[@*='Add New Plant']"));
		addplant.click();
		
		WebElement alertpop = driver.findElement(By.xpath("//*[@name='PlantName']"));
		alertpop.click();
		alertpop.sendKeys("Nato");
		
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@*='k-select']")));
		dropdown.selectByVisibleText("India");
		
		WebElement submit = driver.findElement(By.xpath("//*[text()='Save']"));
		submit.click();
		
		Thread.sleep(2000);
		
		try{
			
			boolean msg = driver.findElement(By.xpath("//*[@*='toast-success toast ng-trigger ng-trigger-flyInOut']")).isDisplayed();
			
			System.out.println(msg+"Plant created successfully");
						
		}catch (Exception e) {
			// TODO: handle exception
			driver.findElement(By.xpath("//*[@*='toast-title ng-star-inserted']"));
			System.out.println("Plant license exceeded"+e);
		}
		
		
		
	}
	
	public static void CreateUser() throws InterruptedException{
		
		
		
		WebElement usrmgmt = driver.findElement(By.xpath("//*[text()='User Management']"));
		usrmgmt.click();
		WebElement accounts = driver.findElement(By.xpath("//*[@*='ng-tns-c8-21 k-link']"));
		accounts.click();
		Thread.sleep(2000);
		
		try{
		WebElement newusrclick = driver.findElement(By.xpath("//*[@*='Add New User']"));
		newusrclick.click();
		
		WebElement frstname= driver.findElement(By.xpath("//*[@name='FirstName']"));
		frstname.click();
		frstname.sendKeys("Grey");
		
		WebElement lstname = driver.findElement(By.xpath("//*[@name='LastName']"));
		lstname.click();
		lstname.sendKeys("black");
		
		WebElement email = driver.findElement(By.xpath("//*[@name='Email']"));
		email.click();
		email.sendKeys("gb@flsdtr");
		
		WebElement pswd = driver.findElement(By.xpath("//*[@name='Password']"));
		pswd.click();
		pswd.sendKeys("test");
		
		WebElement cnfrmpwd = driver.findElement(By.xpath("//*[@name='ConfirmPassword']"));
		cnfrmpwd.click();
		cnfrmpwd.sendKeys("test");
		
		WebElement save = driver.findElement(By.xpath("//*[text()='Save']"));
		save.click();
		
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement errmsg = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div")));
		
		if(errmsg.isDisplayed()){
			
			System.out.println("user exists");
			
			WebElement cancelbtn = driver.findElement(By.xpath("//*[text()='Cancel']"));
			
			cancelbtn.click();
			
		}
		}catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public static void DeleteUser(){
		
		try{
			
			System.out.println("coming");
			
	
			WebElement txt = driver.findElement(By.xpath("//*[text()='gb@flsdtr']"));
			if(txt.isDisplayed()){
				
				WebElement del = driver.findElement(By.xpath("//*[text()='gb@flsdtr' and following::*[text()='delete']]"));
				del.click();	
			}else{
				
				System.out.println("user doesnot exist");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
		
}



