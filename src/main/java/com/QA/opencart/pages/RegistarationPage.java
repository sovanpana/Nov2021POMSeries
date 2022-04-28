package com.QA.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.opencart.tests.BaseTest;
import com.QA.opencart.utils.Constants;
import com.QA.opencart.utils.ElementUtil;

public class RegistarationPage extends BaseTest{
	
	private WebDriver driver; 
	ElementUtil eleUtil;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");	   
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPwd = By.id("input-confirm");
	
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	
	private By agreeCheckBox = By.name("agree");
	
	private By continueBtn = By.xpath("//input[@value='Continue']");
	private By successMsg = By.cssSelector("div#content h1");
	private By logout = By.linkText("Logout");
	private By RegistrationLink = By.linkText("Register");

	
	public RegistarationPage(WebDriver driver) {
		this.driver=driver;	
		eleUtil = new ElementUtil(driver);
	}
	public Boolean accountRegistration(String firstName, String lastName, 
			                        String email, String telephone, String password, 
			                        String subscribe)
			{
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmPwd, password);
		
		if(subscribe.equals("yes")) {
			eleUtil.doClick(subscribeYes);
		}else {
			eleUtil.doClick(subscribeNo);
			
		}
		
		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueBtn);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String successmsg = eleUtil.doGetText(successMsg);
		System.out.println("successmsg>>>>>>>>>>" + successmsg);
		if (successmsg.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {			
			eleUtil.doClick(logout);
			eleUtil.doClick(RegistrationLink);
			return true;
		}
		return false;
		
	}
}
	
	
