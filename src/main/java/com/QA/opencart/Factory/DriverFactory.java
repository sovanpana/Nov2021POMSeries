package com.QA.opencart.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	
	ThreadLocal<WebDriver> tlDriver = new ThreadLocal();

	/**
	 * This method is used to initialize the driver using the browser name
	 * 
	 * @param browserName
	 * @return this returns the webDriver
	 */
	

	public WebDriver init_driver(Properties prop) {
		System.out.println("prop>>>>>>>>" + prop);
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is : " + browserName);
		
		optionsManager = new OptionsManager(prop);
				
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();			
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Pass correct browser name");
			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url").trim());
		return driver;
	}
	
	

	/**
	 * This method is used to initialize the properties file
	 * 
	 * @return this returns the properties class reference
	 */
	public Properties init_prop() {
		prop = new Properties();

		try {
			FileInputStream fip = new FileInputStream(
					".\\src\\test\\resources\\config\\config.properties");
			prop.load(fip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}
	/**
	 * take screenshot
	 */
	public  String getScreenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
