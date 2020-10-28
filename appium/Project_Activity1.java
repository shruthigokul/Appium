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

public class Project_Activity1 {

	 //Instantiate Driver
    AppiumDriver<MobileElement> driver=null;
	@BeforeTest
	public void init() throws MalformedURLException {
		//Set desired capabilities
		DesiredCapabilities caps=new DesiredCapabilities();
		 caps.setCapability("deviceId", "RZ8N818F4WV");
	        caps.setCapability("deviceName", "Galaxy M31");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", ".ui.TaskListsActivity");
	        
	        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			System.out.println("Google Task is open");
	

	}
	
	@Test(priority=0)
	public void add() throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(driver,5);
		Thread.sleep(5000);
		driver.findElementById("com.google.android.apps.tasks:id/welcome_get_started").click();
//		driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	//	Thread.sleep(5000);
		
		//storing the Google tasks in an array
		String gTask[]=new String[3];
		gTask[0]="Complete Activity with Google Tasks";
		gTask[1]="Complete Activity with Google Keep";
		gTask[2]="Complete the second Activity Google Keep";
		
		for (String task : gTask) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.tasks:id/tasks_fab")));
			driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.tasks:id/add_task_title")));
			driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys(task);
			driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		}
		
		List<MobileElement> taskList=driver.findElements(By.id("com.google.android.apps.tasks:id/task_name"));
	int gtaskSize=gTask.length;
		
		
		for(int i=0;i<gtaskSize;i++)
		{
		
			
			Assert.assertEquals(taskList.get(taskList.size()-(i+1)).getText().trim(), gTask[i]);
		}
		
		
			
	}
	
	
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}
}
