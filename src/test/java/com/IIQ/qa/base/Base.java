package com.IIQ.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base {
	Properties prop;
	WebDriver driver;
	public void loadPropertiesFile() {
		prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\Config.properties");
		try {
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
	//driver.get("http://localhost:8080/identityiq/login.jsf?prompt=true");
	

}
