/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Book {
    @FindBy(xpath = "//input[@value = 'Search by Title, Author, Publisher or ISBN']")
    WebElement Textbox;

    @FindBy(xpath = "//input[@class = 'sprite search-btn']")
    WebElement SearchBtn;

    @FindBy(xpath = "//a[text() = 'The Alchemist: A Graphic Novel']")
    WebElement Novel;

    @FindBy(xpath = "//input[@value = 'Buy Now']")
    WebElement BuyNow;

    public Search_Book(WebDriver driver) { PageFactory.initElements(Base.driver, this);
    }

    public void SearchItem() {
        Textbox.sendKeys("The Alchemist: A Graphic Novel");
        SearchBtn.click();
        Novel.click();
        BuyNow.click();
    }
}
