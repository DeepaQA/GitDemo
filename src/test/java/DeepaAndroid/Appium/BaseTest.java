package DeepaAndroid.Appium;


import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;




public class BaseTest {
	
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
		options.setApp("E://Rahul Shetty//Appium//src//test//java//resources//SampleApplication.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}
		
	@AfterClass
	public void tearDown()
	{
	driver.quit();
	//service.stop();
	}
}
