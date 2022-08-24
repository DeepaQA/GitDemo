package DeepaAndroid.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_TC1 extends BaseTest1 {
	
	@Test
	
	public void FillForm() throws InterruptedException
	{
		
		Thread.sleep(3000);
		//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Tester");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		String Toastmessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		
		Assert.assertEquals(Toastmessage, "Please enter your name");
		
		Thread.sleep(3000);
	}

}
