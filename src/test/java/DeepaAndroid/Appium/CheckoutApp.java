package DeepaAndroid.Appium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CheckoutApp extends BrowserBaseTest {
	
	


	@Test
	
	public void CheckoutDemoApp() throws InterruptedException, IOException
	{
		driver.get("https://demowebapp.verifayalabs.com/");
		
		driver.findElement(By.name("firstName")).sendKeys("First 1");
		driver.findElement(By.name("lastName")).sendKeys("Last 1");
		driver.findElement(By.name("address1")).sendKeys("Address 1");
		driver.findElement(By.name("address2")).sendKeys("Address 2");
		driver.findElement(By.name("city")).sendKeys("City 1");
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		
		driver.findElement(By.name("state")).sendKeys("State 1");
		driver.findElement(By.name("zip")).sendKeys("123456");
		WebElement combobox=driver.findElement(By.name("country"));
		Select item=new Select(combobox);
		item.selectByVisibleText("India");
		
		driver.findElement(By.name("addressforpayment")).click();
		
		driver.findElement(By.xpath("(//input[@name='optsoftbill'])[2]")).click();
		
	
		
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshot, new File("E:\\Rahul Shetty\\Appium\\mobilescreenshot.png"));
		
		driver.findElement(By.id("nextbtn")).click();
		
		Thread.sleep(5000);
		
		
		
	}

	
	
	
}
