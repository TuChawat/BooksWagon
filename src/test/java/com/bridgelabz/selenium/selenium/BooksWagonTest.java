/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium.selenium;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.listner.TestNGListner;
import com.bridgelabz.selenium.pages.Login_Bookswagon;
import com.bridgelabz.selenium.pages.Search_Book;
import com.bridgelabz.selenium.pages.Wishlist_Item;
import com.bridgelabz.selenium.utility.ReadExcelFile;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import static com.bridgelabz.selenium.utility.Screenshot.capture;

@Listeners(TestNGListner.class)
public class BooksWagonTest extends Base {
    public Login_Bookswagon login;
    public Search_Book Search;
    public Wishlist_Item Wishlist;

    @Test(dataProvider="testdata")
    public void Login_Bookswagon(String username, String password) throws IOException {
        login = new Login_Bookswagon(driver);
        login.loggedin(username,password);
        String Account = driver.findElement(By.xpath("//h1[text() = 'My Account']")).getText();
        Assert.assertEquals("My Account", Account);
        if (Account.equals("My Account")){
            test.log(LogStatus.PASS, "Navigated to My account");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @Test
    public void Search_Book() throws InterruptedException, IOException {
        Search = new Search_Book(driver);
        Search.SearchItem();
        Thread.sleep(2000);
        WebElement Book = driver.findElement(By.xpath("//img[@alt = 'The Alchemist: A Graphic Novel']"));
        if (Book.isDisplayed()){
            test.log(LogStatus.PASS, "Navigated to My account");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

//    @Test
//    public void addToWishlist() throws InterruptedException {
//        Wishlist = new Wishlist_Item(driver);
//        Wishlist.addItemToWishlist();
//    }

    @DataProvider(name="testdata")
    public Object[][] testDataExample(){
        ReadExcelFile configuration = new ReadExcelFile("D:\\Excel\\Bookswagon.xlsx");
        int rows = configuration.getRowCount(0);
        Object[][]signin_credentials = new Object[rows][2];

        for(int i=0;i<rows;i++)
        {
            signin_credentials[i][0] = configuration.getData(0, i, 0);
            signin_credentials[i][1] = configuration.getData(0, i, 1);
        }
        return signin_credentials;
    }
}
