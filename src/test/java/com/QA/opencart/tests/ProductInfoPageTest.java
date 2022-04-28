package com.QA.opencart.tests;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.opencart.utils.Constants;

public class ProductInfoPageTest extends BaseTest{

	@BeforeClass
	public void accPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
	}
	@Test
	public void productHeaderNameTest() {
		resultsPage = accountsPage.doSerach("macbook");
		prodInfoPage = resultsPage.selectProduct("MacBook Pro");
		Assert.assertEquals(prodInfoPage.getProductHeaderName(), "MacBook Pro");
	}
	@DataProvider
	public Object[][] productData(){
		return new Object[][] { 
			                  {"macbook", "MacBook Pro", Constants.MACBOOK_IMAGES_COUNT},
			                  {"macbook", "MacBook Air", Constants.MACBOOK_IMAGES_COUNT}
		};
	}
	@Test (dataProvider = "productData")
	public void productImagesCountTest(String productName, String searchMainProdName, int count) {
		resultsPage = accountsPage.doSerach(productName);
		prodInfoPage = resultsPage.selectProduct(searchMainProdName);
		int imageCount = prodInfoPage.getProductImageCount();
		System.out.println("Total imagaes present for" +  searchMainProdName + " : " + imageCount);
		Assert.assertEquals(imageCount, count);
	}
	@Test
	public void productInfoTest() {
		resultsPage = accountsPage.doSerach("macbook");
		prodInfoPage = resultsPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = prodInfoPage.getProductInfo();
		actProductInfoMap.forEach((k,v) ->System.out.println(k+":"+v));
		softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProductInfoMap.get("TotalImages"), "4");
		softAssert.assertEquals(actProductInfoMap.get("Name"), "MacBook Pro");
		softAssert.assertEquals(actProductInfoMap.get("Price"), "$2,000.00");	
		softAssert.assertAll();
		}
	}


