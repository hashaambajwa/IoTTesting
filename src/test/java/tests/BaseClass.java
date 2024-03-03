package tests;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.*;
import io.appium.java_client.touch.ActionOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {

	AndroidDriver driver;
	static String urlButton = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup";
	static String urlTextButton = "//android.widget.EditText[@text=\"exp://\"]";
	static String expoLink = "exp://u.expo.dev/update/226951a1-88b1-43d1-8cdb-08fface431f8";
	static String connectButton = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup";
	static String homePage = "//android.widget.TextView[@text=\"Your Dashboard\"]";
	static String ceilingLightsToggle = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Switch";
	

	@BeforeTest
	public void setup() {
		try {

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability("VERSION", 14);
			caps.setCapability("appPackage", "host.exp.exponent");
			caps.setCapability("appActivity", "host.exp.exponent.LauncherActivity");
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("udid", "R5CR122PT1A");
			caps.setCapability("newCommandTimeout", 60 * 60);
			caps.setCapability("unicodeKeyboard", false);
			caps.setCapability("noReset", true);

			URL url = new URI("http://127.0.0.1:4723/wd/hub").toURL();
			driver = new AndroidDriver(url, caps);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void sampleTest() {
		try {
			System.out.println("Automation Testing Pending");
			driver.findElement(By.xpath(urlButton)).click();
			driver.findElement(By.xpath(urlTextButton)).sendKeys(expoLink);
			driver.findElement(By.xpath(connectButton)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(homePage)).click();
			driver.findElement(By.xpath(ceilingLightsToggle)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	static void teardown() {

	}

}
