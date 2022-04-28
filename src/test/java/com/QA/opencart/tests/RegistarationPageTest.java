package com.QA.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.opencart.pages.RegistarationPage;
import com.QA.opencart.utils.Constants;
import com.QA.opencart.utils.ExcelUtil;

public class RegistarationPageTest extends BaseTest{
	
	@BeforeClass
	public void regSetUp() {
		regPage = loginPage.goToReigisterPage();		
	}
	
	public String getRandom() {
		Random randomEmail = new Random();
		String email = "testAutomation" + randomEmail.nextInt(10000)+"@gmail.com";
		return email;
		
	}
	
	@DataProvider
	public Object[][] getResistrationTestData() {
		System.out.println("222222222222222222222222");
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		System.out.println(regData);
		return regData;
	}
	
	@Test(dataProvider="getResistrationTestData")
	public void accountRegistrationTest(String firstName, String lastName, String telephone, String pwd, String subscribe) {
		System.out.println("hiiiiiii1111111111111");
		Assert.assertTrue(regPage.accountRegistration(firstName,lastName, getRandom(), telephone, pwd, subscribe));
		
	}
	

}
