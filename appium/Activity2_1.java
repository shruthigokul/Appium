package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_1 {

	 //Instantiate Driver
    AppiumDriver<MobileElement> driver=null;
	@BeforeTest
	public void init() throws MalformedURLException {
		//Set desired capabilities
		DesiredCapabilities caps=new DesiredCapabilities();
		 caps.setCapability("deviceId", "RZ8N818F4WV");
	        caps.setCapability("deviceName", "Galaxy M31");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.samsung.android.app.contacts");
	        caps.setCapability("appActivity", "com.samsung.android.contacts.contactslist.PeopleActivity");
	        
	        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			System.out.println("Contacts is open");
	

	}
	
	@Test(priority=0)
	public void add() throws InterruptedException
	{
			
				WebDriverWait wait=new WebDriverWait(driver,10);
				
				
				/*MobileElement turnOnButtonElement=driver.findElementById("com.samsung.android.app.contacts:id/button1");
				if(turnOnButtonElement.isDisplayed())
				{
					turnOnButtonElement.click();
				}*/
					
				MobileElement createContactButton=driver.findElementById("com.samsung.android.app.contacts:id/contact_list_floating_action_button");
				createContactButton.click();
				//Thread.sleep(5000);
				
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.RelativeLayout[1]/android.widget.CheckBox")));
					driver.findElementByXPath("//android.widget.RelativeLayout[1]/android.widget.CheckBox").click();
					driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]").click();	
				} catch (Exception e) {
					System.out.println("The save to Phone/Google/Sim widget does not appear");
				}
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.samsung.android.app.contacts:id/nameEdit")));
				driver.findElementById("com.samsung.android.app.contacts:id/nameEdit").sendKeys("AppiumTest");
				driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout").click();
				
				driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText").sendKeys("9962542311");
				driver.findElementById("com.samsung.android.app.contacts:id/smallLabel").click();
				
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.samsung.android.app.contacts:id/header")));
					String contactNameString=driver.findElementById("com.samsung.android.app.contacts:id/header").getText();
					String contactNumber=driver.findElementById("com.samsung.android.app.contacts:id/display_number").getText();
					
					Assert.assertEquals(contactNameString,"AppiumTest");
					Assert.assertEquals(contactNumber,"9962542311");
					
				}catch(AssertionError e)
				{
					System.out.println("ContactName/COntact number created is incorrect");
				} 
				
				
				
				//wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.samsung.android.app.contacts:id/contact_list_floating_action_button")));
				
				//driver.findElementById("com.samsung.android.app.contacts:id/contact_list_floating_action_button");
	/*			driver.get("https://www.training-support.net/");
				Thread.sleep(5000);
				String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
				System.out.println(pageTitle);
				//locating about us link
				Thread.sleep(5000);
				driver.findElementByXPath("//android.view.View[@content-desc='About Us']").click();
				WebDriverWait wait=new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.view.View[2]")));
				String pageTitleNew = driver.findElementByXPath("//android.view.View[2]").getText();
				System.out.println(pageTitleNew);*/
				
				
			
	}
	
	
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}
}
