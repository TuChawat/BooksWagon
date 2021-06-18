package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wishlist_Item {
    @FindBy(xpath = "//input[@value = 'Search by Title, Author, Publisher or ISBN']")
    WebElement Textbox;

    @FindBy(xpath = "//input[@class = 'sprite search-btn']")
    WebElement SearchBtn;

    @FindBy(xpath = "//a[text() = 'Dragon Ball Super, Vol. 2']")
    WebElement Book;

    @FindBy(xpath = "//input[@value = 'Buy Now']")
    WebElement BuyNow;

    @FindBy(xpath = "//input[@id = 'ctl00_phBody_ProductDetail_btnNotify']")
    WebElement Notify;

    @FindBy(xpath = "//input[@value = 'Add to Wishlist']")
    WebElement Wishlist;

    public Wishlist_Item(WebDriver driver) { PageFactory.initElements(Base.driver, this);
    }

    public void addItemToWishlist() throws InterruptedException {
        Textbox.sendKeys("Dragon ball super");
        SearchBtn.click();
        Book.click();
        String Buy = BuyNow.getText();
        if (Buy.equals("Buy Now")){
            BuyNow.click();
        } else {
            Notify.click();
            Thread.sleep(2000);
            Wishlist.click();
        }
    }
}
