package com.QA.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void accountsPageTitleTest() {
		String accPageTille = accountsPage.getAccountsPageTitle();
		Assert.assertEquals(accPageTille, Constants.ACCOUNT_PAGE_TITLE);

	}

	@Test
	public void accountsPageUrlTest() {
		String accPageUrl = accountsPage.getAccountsPageUrl();
		Assert.assertTrue(accPageUrl.contains(Constants.ACCOUNT_PAGE_URL_FRACTION));

	}

	@Test
	public void accountsPageHeaderTest() {
		String accPageHeader = accountsPage.getAccountsPageHeader();
		Assert.assertEquals(accPageHeader, Constants.ACCOUNT_PAGE_HEADER);
		;

	}

	@Test
	public Boolean logoutLinkTest() {
		return accountsPage.isLogoutLinkExist();

	}

	@Test
	public Boolean searchExistTest() {
		return accountsPage.searchExist();

	}

	@Test
	public void accountPageSectionsTest() {
		List<String> accSectionsList = accountsPage.getAccountsPageSections();
		Assert.assertEquals(accSectionsList, Constants.ACCOUNT_PAGE_SECTIONS_LIST);
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { { "macbook" }, { "imac" }, { "Apple" } };

	}

	@Test(dataProvider = "productData")
	public void SearchTest(String productName) {
		resultsPage = accountsPage.doSerach(productName);
		Assert.assertTrue(resultsPage.getProductListCount() > 0);
	}

	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] { { "macbook", "MacBook Pro" }, 
			                    { "macbook", "MacBook Air" },
			                    { "imac", "iMac" },
			                    { "Apple", "Apple Cinema 30\"" }
			                    		
			                    };

	}

	@Test(dataProvider = "productSelectData")
	public void selectProductTest(String productName, String productSelectName) {
		resultsPage = accountsPage.doSerach(productName);
		prodInfoPage = resultsPage.selectProduct(productSelectName);
		Assert.assertEquals(prodInfoPage.getProductHeaderName(), productSelectName);
	}
	

}
