package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class Project_Activity2 {
	 //Instantiate Driver
    AppiumDriver<MobileElement> driver=null;
	@BeforeTest
	public void init() throws MalformedURLException {
		//Set desired capabilities
		DesiredCapabilities caps=new DesiredCapabilities();
		 caps.setCapability("deviceId", "RZ8N818F4WV");
	        caps.setCapability("deviceName", "Galaxy M31");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.keep");
	        caps.setCapability("appActivity", ".activities.BrowseActivity");
	        
	        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			System.out.println("Keep Notes is open");
	

	}
	
	@Test(priority=0)
	public void add() throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(driver,5);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.keep:id/skip_welcome")));
		driver.findElementById("com.google.android.keep:id/skip_welcome").click();
		
		String noteTitle="NewNote2";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.keep:id/new_note_button")));
		driver.findElementById("com.google.android.keep:id/new_note_button").click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.keep:id/editable_title")));
		driver.findElementById("com.google.android.keep:id/editable_title").sendKeys(noteTitle);
		driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("description for NewNote1");
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		//androidx.cardview.widget.CardView[@content-desc="NewNote1. description for NewNoteq1 Shah Dhdhd . "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]
		Thread.sleep(5000);
		MobileElement noteList=driver.findElement(By.xpath("//androidx.cardview.widget.CardView[contains(@content-desc,'"+noteTitle+"')]//android.widget.TextView[1]"));
		Assert.assertEquals(noteList.getText(),noteTitle);
		Thread.sleep(5000);
		
	}
	
	
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}
}
