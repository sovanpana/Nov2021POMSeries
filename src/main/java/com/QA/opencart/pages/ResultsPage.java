package com.QA.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.QA.opencart.tests.BaseTest;
import com.QA.opencart.utils.ElementUtil;

public class ResultsPage{
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By Header = By.xpath("//div[@id='content']/h1");
	private By productResults = By.xpath("//div[@class='product-thumb']//div[@class='caption']//a");
	//private By mainProductName = By.linkText("MacBook Pro");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	public int getProductListCount() {
		return eleUtil.getElements(productResults).size();
	}
	public ProductInfoPage selectProduct(String mainProductName) {
		System.out.println("mainProductName is : "+ mainProductName);
		List<WebElement> searchList = eleUtil.getElements(productResults);
		for(WebElement e : searchList) {
			String product = e.getText();
			if(product.equals(mainProductName)) {
				e.click();
				break;
			}			
		}
		return new ProductInfoPage(driver);
		
	}

}
