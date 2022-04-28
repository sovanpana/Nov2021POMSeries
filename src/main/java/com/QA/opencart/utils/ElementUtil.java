package com.QA.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;

		default:
			break;
		}
		return locator;

	}

	public WebElement getElement(By locator) {
		// By.id(locator);
		return driver.findElement(locator);
	}

	public void doClick(By searchIcon) {
		driver.findElement(searchIcon).click();
	}
	
	public void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();
	}

	public void doSendKeys(By locator, String values) {
		//getElement(locator).sendKeys(values);
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(values);

	}

	public void doSendKeys(String locatorType, String locatorValue, String values) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(values);

	}
	public String doGetText(By locator) {
		return driver.findElement(locator).getText();
		
	}
	public String doGetAttribute(By locator, String attName) {
		return driver.findElement(locator).getAttribute(attName);
		
	}
	public boolean doIsDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
		
	}
	public boolean doIsEnabled(By locator) {
		return driver.findElement(locator).isEnabled();
		
	}
	public boolean doIsSelected(By locator) {
		return driver.findElement(locator).isSelected();
		
	}
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}
	public int getElementCount(By locator) {
		return driver.findElements(locator).size();
	}
	public void printElementsList(By locator) {
		List<WebElement> list =getElements(locator);		
		for(WebElement e: list) {
			String text=e.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
	}
	
	public List<String> getElementsTextList(By locator) {
		List<WebElement> list =getElements(locator);
		List<String> elementList= new ArrayList<String>();
		for(WebElement e: list) {
			String text=e.getText();
			if(!text.isEmpty()) {
			elementList.add(text);
		}
			
	}
		return elementList;
	
	}
	
	public List<String> getElementAttributeListt(By locator,String attributeName) {
		
		List<WebElement> list =getElements(locator);
		List<String> elementList= new ArrayList<String>();
		for(WebElement e: list) {
			String attName=e.getAttribute(attributeName);			
			elementList.add(attName);			
	}
		return elementList;
	
	}
	public void waitForElementVisible(By locator, int timeOut) {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		//driver, Duration.ofSeconds(timeOut)
	}
	public void clickOnLink(By locator, String matchLink) throws InterruptedException {
		List<WebElement> list =getElements(locator);
		System.out.println(list.size());
		
		for(WebElement e: list) {
			String text=e.getText();
			System.out.println(text);
			if(text.contains(matchLink)) {
		    e.click();
		    Thread.sleep(2000);
		    break;
		    }
		}	
	}
	
		

}
