package com.Testcases;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BaseTest.TestBase;
import com.Pages.BuyProduct;



public class LoginTest extends TestBase{
	BuyProduct obj;
	String currenturl;
	public LoginTest()
	{
		super();
	}
	@BeforeSuite
	public void Lauch_Browser()
	{
	//	System.out.println("Hello");
		LaunchDriver();
		obj=new BuyProduct();
	}
	
	@Test
	public void checktitle()
	{
		System.out.println("Hello");
		currenturl=obj.VerifyTitle();
		Assert.assertEquals(currenturl,"https://www.amazon.in/");
		
	}
	@Test
	public void buy()
	{
		obj.Purchase();
	}
	@AfterSuite
	public void closebrowser()
	{
		obj.CloseBrowser();
	}
}

