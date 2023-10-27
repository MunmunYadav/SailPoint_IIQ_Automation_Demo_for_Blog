package Sailpoint_IIQ_Automation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AggregationTest {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		String browserName="chrome";
		if(browserName.equals("chrome")) {
			driver =new ChromeDriver();
		}else if(browserName.equals("firefox")) {
		driver=new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://localhost:8080/identityiq/login.jsf?prompt=true");
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
		@Test//(invocationCount = 4,threadPoolSize = 3)
		
	public void StartAggregation() throws InterruptedException {
			driver.get("http://localhost:8080/identityiq/monitor/tasks/viewTasks.jsf?resetTab=true");
			driver.findElement(By.id("loginForm:accountId")).sendKeys("spadmin");
			driver.findElement(By.id("loginForm:password")).sendKeys("admin");
			driver.findElement(By.id("loginForm:loginButton")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("tasksSearchField-inputEl")).sendKeys("Refresh identity cube");
			driver.findElement(By.xpath("//*[@id=\"gridview-1026-bd-Identity\"]/td/table/tbody/tr[2]/td[1]/div")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("editForm:validateBeforeExecuteButton")).click();
			driver.findElement(By.xpath("//*[@id=\"editForm:validateBeforeExecuteButton\"]/span")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("button-1013")).click();
			
	}
	@Test
	public void aggregationStatus() throws IOException, InterruptedException {
		driver.navigate().to("http://localhost:8080/identityiq/monitor/tasks/viewTasks.jsf?resetTab=true");
		driver.findElement(By.id("loginForm:accountId")).sendKeys("spadmin");
		driver.findElement(By.id("loginForm:password")).sendKeys("admin");
		driver.findElement(By.id("loginForm:loginButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("tab-1091-btnInnerEl")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("button-1086")).click();
		Thread.sleep(5000);
		//To take Screenshot
				TakesScreenshot t=(TakesScreenshot)driver;
				File src = t.getScreenshotAs(OutputType.FILE);
				File Dest=new File("./screenshot/AggregationStatus.png");
				FileUtils.copyFile(src, Dest);
				Reporter.log("aggregationStatus",true);
	
		
	}
}



