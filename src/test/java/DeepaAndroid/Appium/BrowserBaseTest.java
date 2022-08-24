package DeepaAndroid.Appium;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;




public class BrowserBaseTest {
	
	//public AppiumDriverLocalService service;
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
	
	 /*service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//deepa//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
	service.start();*/
	
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("mydevice1");
		options.setChromedriverExecutable("E:\\Rahul Shetty\\Appium\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}
	public Double getFormattedAmount(String amount)
	{
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}
		
	@AfterClass
	public void tearDown()
	{
	driver.quit();
	//service.stop();
	}
}
