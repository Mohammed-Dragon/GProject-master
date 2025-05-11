package Tests;

import Base.OpenDriver;
import org.example.Pages.CartPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTests extends OpenDriver {
    @Test(priority = 1)
    public void AddToCart(){
        CartPage myCart = new CartPage(driver);
        myCart.Choosing_lumia_1520();
        myCart.ClickOnBuyButton();
        myCart.getAlertTextAndAccept();
        myCart.ClickOnCartButton();
        String Nokia= myCart.Nokia_lumia_1520_Price();
        Assert.assertEquals(Nokia,"820");
    }
    @Test(priority = 2)
    public void AddMoreThanOneItem() {
        CartPage myCart = new CartPage(driver);
        myCart.Choosing_Samsung_galaxy_s6();
        myCart.ClickOnBuyButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        myCart.ClickOnCartButton();
        Assert.assertEquals(myCart.Samsung_galaxy_s6_Price(), "360");
        myCart.ClickOnHomeButton();
    }
    @Test(priority = 3)
    public void AddMoreSecondItem () {
        CartPage myCart = new CartPage(driver);
        myCart.Sleep(3);
        myCart.Choosing_lumia_1520();
        myCart.Sleep(4);
        myCart.ClickOnBuyButton();
        myCart.Sleep(4);
        Alert Alert = driver.switchTo().alert();
        Alert.accept();
        myCart.ClickOnCartButton();
        myCart.Sleep(4);
        Assert.assertEquals(myCart.Nokia_lumia_1520_Price(),"820");
    }
    @Test(priority = 4)
    public void MakeCompleteBuy() {
        CartPage myCart = new CartPage(driver);
        myCart.Sleep(3);
        myCart.Choosing_lumia_1520();
        myCart.Sleep(4);
        myCart.ClickOnBuyButton();
        myCart.Sleep(4);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        myCart.ClickOnCartButton();
        myCart.Sleep(4);
        myCart.ClickPlaceOrder();
        myCart.Sleep(4);
        myCart.Name();
        myCart.Country();
        myCart.City();
        myCart.Credit_card();
        myCart.Month();
        myCart.Year();
        myCart.Purchase();
        myCart.Sleep(4);
        myCart.OkayButton();
        myCart.Sleep(4);
        myCart.ClickOnCartButton();
        myCart.Sleep(4);
        try {
            String nokiaPrice = myCart.Nokia_lumia_1520_Price();

            if (nokiaPrice.equals("820")) {
                Assert.fail("Phone found in cart with price 820 after login");
            }
        } catch (NoSuchElementException e) {

        }
    }
    @Test(priority = 5)
    public void MakeCompleteBuyWithoutAnyItem(){
        CartPage myCartPage = new CartPage(driver);
        myCartPage.ClickOnCartButton();
        myCartPage.Sleep(4);
        myCartPage.ClickPlaceOrder();
        myCartPage.Sleep(4);
        myCartPage.Name();
        myCartPage.Country();
        myCartPage.City();
        myCartPage.Credit_card();
        myCartPage.Month();
        myCartPage.Year();
        myCartPage.Purchase();
        myCartPage.Sleep(4);
        myCartPage.OkayButton();
        myCartPage.Sleep(4);
        Assert.fail("make complete buy without any item");
    }
    @Test(priority = 6)
    public void MakeCompleteBuyWithNameOnly() {
        CartPage myCartPage = new CartPage(driver);

        myCartPage.Sleep(4);
        myCartPage.Choosing_lumia_1520();
        myCartPage.Sleep(4);
        myCartPage.ClickOnBuyButton();
        myCartPage.Sleep(4);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        myCartPage.ClickOnCartButton();
        myCartPage.Sleep(4);
        myCartPage.ClickPlaceOrder();
        myCartPage.Sleep(4);
        myCartPage.Name();
        myCartPage.Purchase();
        try {
            Alert Alert = driver.switchTo().alert();
            String AlertText = alert.getText();
            System.out.println("Alert appeared with text: " + AlertText);
            Alert.accept();
            Assert.assertTrue(true, "Alert appeared — test passed.");
        } catch (NoAlertPresentException e) {
            // Alert not present — FAIL the test
            Assert.fail("Alert did not appear — test failed.");
        }
    }
    @Test(priority = 7)
    public void MakeCompleteBuyWithNameAndCountryOnly(){
        CartPage myCartPage = new CartPage(driver);

        myCartPage.Sleep(4);
        myCartPage.Choosing_lumia_1520();
        myCartPage.Sleep(4);
        myCartPage.ClickOnBuyButton();
        myCartPage.Sleep(4);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        myCartPage.ClickOnCartButton();
        myCartPage.Sleep(4);
        myCartPage.ClickPlaceOrder();
        myCartPage.Sleep(4);
        myCartPage.Name();
        myCartPage.Country();
        myCartPage.Purchase();
        try {
            Alert Alert = driver.switchTo().alert();
            String AlertText = alert.getText();
            System.out.println("Alert appeared with text: " + AlertText);
            Alert.accept();
            Assert.assertTrue(true, "Alert appeared — test passed.");
        } catch (NoAlertPresentException e) {
            // Alert not present — FAIL the test
            Assert.fail("Alert did not appear — test failed.");
        }
    }
    @Test(priority = 8)
    public void MakeCompleteBuyWithNameAndCountryAndCityOnly(){
        CartPage myCartPage = new CartPage(driver);

        myCartPage.Sleep(3);
        myCartPage.Choosing_lumia_1520();
        myCartPage.Sleep(4);
        myCartPage.ClickOnBuyButton();
        myCartPage.Sleep(4);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        myCartPage.ClickOnCartButton();
        myCartPage.Sleep(4);
        myCartPage.ClickPlaceOrder();
        myCartPage.Sleep(4);
        myCartPage.Name();
        myCartPage.Country();
        myCartPage.City();
        myCartPage.Purchase();try {
            Alert Alert = driver.switchTo().alert();
            String AlertText = alert.getText();
            System.out.println("Alert appeared with text: " + AlertText);

            Alert.accept();
            Assert.assertTrue(true, "Alert appeared — test passed.");

        } catch (NoAlertPresentException e) {
            Assert.fail("Alert did not appear — test failed.");
        }
    }
    @Test(priority = 9)
    public void MakeCompleteBuyWithNameAndCountryAndCityAndCardNumberOnly(){
        CartPage myCartPage = new CartPage(driver);

        myCartPage.Sleep(3);
        myCartPage.Choosing_lumia_1520();
        myCartPage.Sleep(4);
        myCartPage.ClickOnBuyButton();
        myCartPage.Sleep(4);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        myCartPage.ClickOnCartButton();
        myCartPage.Sleep(4);
        myCartPage.ClickPlaceOrder();
        myCartPage.Sleep(4);
        myCartPage.Name();
        myCartPage.Country();
        myCartPage.City();
        myCartPage.Credit_card();
        myCartPage.Purchase();
        try {
            Alert Alert = driver.switchTo().alert();
            String AlertText = alert.getText();
            System.out.println("Alert appeared with text: " + AlertText);
            Alert.accept();
            Assert.assertTrue(true, "Alert appeared — test passed.");
        } catch (NoAlertPresentException e) {
            Assert.fail("Alert did not appear — test failed.");
        }
    }
    @Test(priority = 10)
    public void MakeSureItmenStillFoundAfterLoginIn() {
        CartPage myCartPage = new CartPage(driver);
        myCartPage.Sleep(6);
        myCartPage.Choosing_lumia_1520();
        myCartPage.Sleep(6);
        myCartPage.ClickOnBuyButton();
        myCartPage.Sleep(6);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        myCartPage.Sleep(6);
        myCartPage.ClickOnCartButton();
        myCartPage.Sleep(6);
        myCartPage.ClickOnLoginButton();
        myCartPage.Sleep(6);
        myCartPage.login_Name();
        myCartPage.login_Password();
        myCartPage.LoginButtonEnter();
        myCartPage.Sleep(6);
        myCartPage.ClickOnHomeButton();
        myCartPage.Sleep(6);
        myCartPage.ClickOnCartButton();
        myCartPage.Sleep(6);
        try {
            String item = myCartPage.Nokia_lumia_1520_Price();
            Assert.assertTrue(item != null && !item.isEmpty(), "Item in cart after login");
        } catch (NoSuchElementException e) {
            Assert.fail("Item not in cart after login");
        }
    }
    @Test(priority = 11)
    public void MakeSureItmenStillFoundAfterLoginOut() {
        CartPage mycart = new CartPage(driver);
        mycart.Sleep(4);
        mycart.ClickOnLoginButton();
        mycart.Sleep(4);
        mycart.login_Name();
        mycart.login_Password();
        mycart.LoginButtonEnter();
        mycart.Sleep(4);
        mycart.Choosing_lumia_1520();
        mycart.Sleep(4);
        mycart.ClickOnBuyButton();
        mycart.Sleep(4);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        mycart.Sleep(4);
        mycart.ClickOnCartButton();
        mycart.Sleep(4);
        mycart.ClickOnHomeButton();
        mycart.Sleep(4);
        mycart.ClickOnLoginOutButton();
        mycart.Sleep(4);
        mycart.ClickOnCartButton();
        mycart.Sleep(4);
        try {
            String item = mycart.Nokia_lumia_1520_Price();
            Assert.assertEquals(item, "820", "item found in cart");

        } catch (NoSuchElementException e) {
            Assert.fail("Item not found after logout");
        }
    }
    @Test (priority = 12)
    public void DeleteItem (){
        CartPage mycart = new CartPage(driver);
        mycart.Sleep(4);
        mycart.Choosing_lumia_1520();
        mycart.Sleep(4);
        mycart.ClickOnBuyButton();
        mycart.Sleep(4);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        mycart.Sleep(4);
        mycart.ClickOnHomeButton();
        mycart.Sleep(4);
        mycart.Choosing_Samsung_galaxy_s6();
        mycart.Sleep(4);
        mycart.ClickOnBuyButton();
        mycart.Sleep(4);
        Alert Alert = driver.switchTo().alert();
        Alert.accept();
        mycart.Sleep(4);
        mycart.ClickOnCartButton();
        mycart.Sleep(4);
        mycart.DeleteButton();
        mycart.Sleep(4);
        mycart.DeleteButton();
        mycart.Sleep(4);
        List<WebElement> firstItem = driver.findElements(By.xpath("//*[@id='tbodyid']/tr/td[2]"));
        List<WebElement> secondItem = driver.findElements(By.xpath("//*[@id='tbodyid']/tr[2]/td[2]"));
        if (!firstItem.isEmpty() || !secondItem.isEmpty()) {
            Assert.fail("Unexpected item found in cart after logout");
        } else {
            Assert.assertTrue(true); // Optional: test passed
        }
    }

}
