package com.QA.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.opencart.tests.BaseTest;
import com.QA.opencart.utils.ElementUtil;

public class AccountsPage extends BaseTest {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By header = By.linkText("Your Store");
	private By sections = By.xpath("//div[@id='content']/h2");
	private By logoutLink = By.linkText("Logout");
	private By search = By.name("search");
	private By searchIcon = By.xpath("//div[@id='search']//button");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public String getAccountsPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getAccountsPageHeader() {
	 return eleUtil.doGetText(header);
	 }
	
	public Boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}
	public Boolean doLogout() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);	
			return true;
		}else
			return false;
	}
	public List<String> getAccountsPageSections() {		
		return eleUtil.getElementsTextList(sections);
	}
	public Boolean searchExist() {
		return eleUtil.doIsDisplayed(search);
	}
	public ResultsPage doSerach(String productName) {
		if(searchExist()) {
			eleUtil.doSendKeys(search, productName);
			eleUtil.doClick(searchIcon);			
		}
		return new ResultsPage(driver);
		
	}
}
