package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	 //Instantiate Driver
    AppiumDriver<MobileElement> driver=null;
	@BeforeTest
	public void init() throws MalformedURLException {
		//Set desired capabilities
		DesiredCapabilities caps=new DesiredCapabilities();
		 caps.setCapability("deviceId", "RZ8N818F4WV");
	        caps.setCapability("deviceName", "Galaxy M31");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.android.chrome");
	        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	        
	        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			System.out.println("Chrome is open");
	

	}
	
	@Test(priority=0)
	public void add() throws InterruptedException
	{
	
				driver.get("https://www.training-support.net/");
				Thread.sleep(5000);
				String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
				System.out.println(pageTitle);
				//locating about us link
				Thread.sleep(5000);
				driver.findElementByXPath("//android.view.View[@content-desc='About Us']").click();
				WebDriverWait wait=new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.view.View[2]")));
				String pageTitleNew = driver.findElementByXPath("//android.view.View[2]").getText();
				System.out.println(pageTitleNew);
				
				
			
	}
	
	
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}
	
}
