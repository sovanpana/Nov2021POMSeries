package com.QA.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.QA.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	ElementUtil eleUtil;
	private By productHeaderName = By.xpath("//div[@id='content']//h1");

	private By productImages = By.xpath("//ul[@class='thumbnails']//img");
	private By productMetaData = By.xpath("//div[@id='content']//div[@class='col-sm-4']/ul[1]/li");
	private By productPriceData = By.xpath("//div[@id='content']//div[@class='col-sm-4']/ul[2]/li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");

	private Map<String, String> productMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHeaderName() {
		return eleUtil.doGetText(productHeaderName).trim();
	}

	public int getProductImageCount() {
		return eleUtil.getElements(productImages).size();
	}

	public Map<String, String> getProductInfo() {
		productMap = new LinkedHashMap<String, String>();
		productMap.put("Name", getProductHeaderName());
		productMap.put("TotalImages", String.valueOf(getProductImageCount()));
		getProductMetaData();
		getPriceMetaData();
		return productMap;

	}

	private void getProductMetaData() {
		List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
		for (WebElement e : metaDataList) {
			String text = e.getText();
			String[] splitString = text.split(":");
			String key = splitString[0].trim();
			String value = splitString[1].trim();
			productMap.put(key, value);
		}
	}

	private void getPriceMetaData() {
		List<WebElement> metaDataPriceList = eleUtil.getElements(productPriceData);
		String price = metaDataPriceList.get(0).getText().trim();
		String exTaxPrice = metaDataPriceList.get(1).getText().trim();
		productMap.put("Price", price);
		productMap.put("ExTaxPrice", exTaxPrice);
	}
}
