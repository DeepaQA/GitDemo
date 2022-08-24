package DeepaAndroid.Appium;


import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce_TC4 extends BaseTest1 {
	
	@Test
	
	public void FillForm() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Tester");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Angola']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		Thread.sleep(3000);
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
		Thread.sleep(3000);
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count=productPrices.size();
		double totalSum=0;
		
		for(int i=0;i<count;i++)
		{
			String amountString=productPrices.get(i).getText();
			//double price=Double.parseDouble(amountString.substring(1));
			
			Double price=getFormattedAmount(amountString);
			totalSum=totalSum+price;
			
		}
		
		String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum=getFormattedAmount(displaySum);
		
	//Assert.assertEquals(displayFormattedSum, totalSum);
		
		System.out.println(displayFormattedSum);
		
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(5000);
		
		Set<String> contexts=driver.getContextHandles();
		for(String contextName: contexts)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Testing");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
	Thread.sleep(5000);
		
		
		
			
			
			
			
			
			
			
	
	}

}
