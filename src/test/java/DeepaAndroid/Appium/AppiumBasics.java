package DeepaAndroid.Appium;


import java.net.MalformedURLException;


import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;



public class AppiumBasics extends BaseTest{

	@Test	
	public void sampleAppTest() throws MalformedURLException
	{
	
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[2]")).click();
	}
}

