package Sailpoint_IIQ_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LogInTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
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
	public void TearDown() {
		driver.quit();	
	}
	@Test(priority = 1)
	public void LoginWithValidUserNameAndPassword() {
		driver.findElement(By.id("loginForm:accountId")).sendKeys("Spadmin");
		driver.findElement(By.id("loginForm:password")).sendKeys("admin");
		driver.findElement(By.id("loginForm:loginButton")).click();
	}
	@Test(priority = 2)
	public void LoginWithInValidUserNameAndPassword() {
		driver.findElement(By.id("loginForm:accountId")).sendKeys("padmin");
		driver.findElement(By.id("loginForm:password")).sendKeys("dmin");
		driver.findElement(By.id("loginForm:loginButton")).click();
		}
}
