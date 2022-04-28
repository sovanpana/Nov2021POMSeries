package com.QA.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "account/login";
	public static final int DEFAULT_TIME_OUT = 5;
	
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_URL_FRACTION = "route=account/account";
	public static final String ACCOUNT_PAGE_HEADER = "Your Store";
	
	public static final List<String> ACCOUNT_PAGE_SECTIONS_LIST =
			                                Arrays.asList("My Account",
					                                      "My Orders",
					                                      "My Affiliate Account",
					                                      "Newsletter");

	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created";
	public static final String REGISTER_SHEET_NAME= "register"; 
	public static final int MACBOOK_IMAGES_COUNT = 4;
	//public static final int  IMAC_IMAGES_COUNT =3;
}
