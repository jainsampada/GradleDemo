package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseTest.TestBase;

public class BuyProduct extends TestBase {
    Actions act = new Actions(driver);
	//Locator Info
    @FindBy(linkText = "Mobiles")
    WebElement category;

    @FindBy(xpath = "//div[text()='IQOO Z6']")
    WebElement product;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    WebElement addtocart;

    @FindBy(id = "attach-sidesheet-checkout-button")
    WebElement checkout;

    public BuyProduct() {
        PageFactory.initElements(driver, this);
    }

    public String VerifyTitle() {
        return driver.getCurrentUrl();
    }

    public void Purchase() {

        category.click();
        product.click();
        act.moveToElement(addtocart).click().perform();
        checkout.click();

    }

    public void CloseBrowser() {
        driver.quit();
    }
}
