package registration;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class RegistrationMethods 
{
	WebDriver driver;
	
	  public void launch(String l, String d)
	  {
		  
		  System.setProperty("webdriver.chrome.driver", "D:\\kiran\\SELENIUM\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get(d);
		 
	  }
	  
	  public void fill(String l, String d)
	  {
		  driver.findElement(By.xpath(l)).clear();
		  driver.findElement(By.xpath(l)).sendKeys(d);
		  
	  }
	  
	  public void click(String l, String d) throws Exception
	  {
		  driver.findElement(By.xpath(l)).click();
		  
		 
	  }
	  
	  public void close(String l, String d)
	  {
		  driver.close();
		  
	  }
	  
	  public void waitVisible(String l, String d)
	  {
		  WebDriverWait w=new WebDriverWait(driver, 30);
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(l)));
		  
	  }
	  
	  public void selectDropdown(String l, String d)
	  {
		  WebElement e=driver.findElement(By.xpath(l));
		  Select s=new Select(e);
		  s.selectByVisibleText(d);
	  }
	  
	  public void enterotp(String l, String d) throws Exception
	  {
		  Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "");
			dc.setCapability("deviceName", "124bd058");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "5.0.2");
			dc.setCapability("appPackage", "com.miui.calculator");
			dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
			AndroidDriver driver1;
			while(2>1)
			{
				try
				{
					driver1=new AndroidDriver(u,dc);
					break;
				}
				catch(Exception e)
				{
					
				}
			}
			
			Activity jiovoice=new Activity("com.jio.join", "com.witsoftware.wmc.TabNavActivity");
			driver1.startActivity(jiovoice);
			WebDriverWait w=new WebDriverWait(driver1, 30);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.jio.join:id/rl_container'][@index='0']")));
			driver1.findElement(By.xpath("//*[@resource-id='com.jio.join:id/rl_container'][@index='0']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.jio.join:id/tv_message_text'][@index='0']")));
			String msg=driver1.findElement(By.xpath("(//*[@resource-id='com.jio.join:id/tv_message_text'])[last()]")).getAttribute("text");
			String gotp[]=msg.split(" ");
			String potp[]=gotp[0].split("-");
			String otp=potp[1];
			System.out.println(otp);
			//stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		    Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
			driver.findElement(By.xpath(l)).sendKeys(otp);
	  }

}
