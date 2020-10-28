package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	 //Instantiate Driver
    AppiumDriver<MobileElement> driver=null;
	@BeforeTest
	public void init() throws MalformedURLException {
		//Set desired capabilities
		DesiredCapabilities caps=new DesiredCapabilities();
		 caps.setCapability("deviceId", "RZ8N818F4WV");
	        caps.setCapability("deviceName", "Galaxy M31");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	        caps.setCapability("appActivity", ".Calculator");
	        
	        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			System.out.println("Calculator is open");
	

	}
	
	@Test(priority=0)
	public void add() throws InterruptedException
	{
	
	    
				
				//Write assertions for all the results.
				//Calculate 5 + 9 and print the result to the console.
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal").click();
				Thread.sleep(5000);
				String getResult=driver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula").getText();
				System.out.println(getResult);
				Assert.assertEquals(Integer.parseInt(getResult), 14);
				
				
				//Calculate 5 * 100 and print the result to the console.
				//Calculate 50 / 2 and print the result to the console.
				
		
			
	}
	
	@Test(priority=1)
	public void subtract() throws InterruptedException
	{
	
	    
				
		//Write assertions for all the results.
				//Calculate 10 - 5 and print the result to the console.
		driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01").click();
		driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00").click();
		driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub").click();
		driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05").click();
		driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal").click();
		Thread.sleep(5000);
		String getResult=driver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula").getText();
		System.out.println(getResult);
		Assert.assertEquals(Integer.parseInt(getResult),5);
		
		
		
			
	}
	
	@Test(priority=2)
	public void multiply() throws InterruptedException
	{
		//Write assertions for all the results.
		//Calculate 5 * 100 and print the result to the console.
		
				
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal").click();
				Thread.sleep(5000);
				String getResult=driver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula").getText();
				System.out.println(getResult);
				Assert.assertEquals(Integer.parseInt(getResult), 500);
				
				
				
		
			
	}
	
	@Test(priority=3)
	public void divide() throws InterruptedException
	{
	
	    
				
				//Write assertions for all the results.
				//Calculate 50 / 2 and print the result to the console.
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02").click();
				driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal").click();
				Thread.sleep(5000);
				String getResult=driver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula").getText();
				System.out.println(getResult);
				Assert.assertEquals(Integer.parseInt(getResult), 25);
	}
	
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}
	
	        
	        
	}


