package com.QA.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QA.opencart.pages.AccountsPage;
import com.QA.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}

	@Test
	public void loginPageURLTest() {
		String url = loginPage.getLoginPageUrl();
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}

	@Test
	public void forgotPasswordLlinkTest() {
		Boolean forgotPasswordLlink = loginPage.isForgotPasswordExist();
		Assert.assertTrue(forgotPasswordLlink);

	}

	@Test
	public void loginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}

}
