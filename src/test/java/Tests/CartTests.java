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
        myCart.getAlertTextAndAccept();
        myCart.ClickOnCartButton();
        Assert.assertEquals(myCart.SamsungPrice(), "360");
        myCart.ClickOnHomeButton();
    }
    @Test(priority = 3)
    public void AddMoreSecondItem () {
        CartPage myCart = new CartPage(driver);
        myCart.Choosing_lumia_1520();
        myCart.ClickOnBuyButton();
        myCart.getAlertTextAndAccept();
        myCart.ClickOnCartButton();
        Assert.assertEquals(myCart.NokiaPrice(),"820");
    }
    @Test(priority = 4)
    public void MakeCompleteBuy() {
        CartPage myCart = new CartPage(driver);
        myCart.Choosing_lumia_1520();
        myCart.ClickOnBuyButton();
        myCart.getAlertTextAndAccept();
        myCart.ClickOnCartButton();
        myCart.ClickPlaceOrder();
        myCart.Name();
        myCart.Country();
        myCart.City();
        myCart.Credit_card();
        myCart.Month();
        myCart.Year();
        myCart.Purchase();
        myCart.OkayButton();
        driver.navigate().refresh();
        try {
            String nokiaPrice = myCart.NokiaPrice();
            Assert.assertEquals(nokiaPrice, "820", "Phone found in cart with price 820 after purchase.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true, "Item not found in cart after purchase, as expected.");
        }
    }
        @Test(priority = 5)
    public void MakeCompleteBuyWithoutAnyItem(){
        CartPage myCartPage = new CartPage(driver);
        myCartPage.ClickOnCartButton();
        myCartPage.ClickPlaceOrder();
        myCartPage.Name();
        myCartPage.Country();
        myCartPage.City();
        myCartPage.Credit_card();
        myCartPage.Month();
        myCartPage.Year();
        myCartPage.Purchase();
        myCartPage.Sleep(4);
        myCartPage.OkayButton();
        Assert.fail("make complete buy without any item");
    }
    @Test(priority = 6)
    public void MakeCompleteBuyWithNameOnly() {
        CartPage myCartPage = new CartPage(driver);
        myCartPage.Choosing_lumia_1520();
        myCartPage.ClickOnBuyButton();
        myCartPage.getAlertTextAndAccept();
        myCartPage.ClickOnCartButton();
        myCartPage.ClickPlaceOrder();
        myCartPage.Name();
        myCartPage.Purchase();
        try {
            Alert Alert = driver.switchTo().alert();
            String AlertText = Alert.getText();
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

        myCartPage.Choosing_lumia_1520();
        myCartPage.ClickOnBuyButton();
        myCartPage.getAlertTextAndAccept();
        myCartPage.ClickOnCartButton();
        myCartPage.ClickPlaceOrder();
        myCartPage.Name();
        myCartPage.Country();
        myCartPage.Purchase();
        try {
            Alert Alert = driver.switchTo().alert();
            String AlertText = Alert.getText();
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

        myCartPage.Choosing_lumia_1520();
        myCartPage.ClickOnBuyButton();
        myCartPage.getAlertTextAndAccept();
        myCartPage.ClickOnCartButton();
        myCartPage.ClickPlaceOrder();
        myCartPage.Name();
        myCartPage.Country();
        myCartPage.City();
        myCartPage.Purchase();try {
            Alert Alert = driver.switchTo().alert();
            String AlertText = Alert.getText();
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

        myCartPage.Choosing_lumia_1520();
        myCartPage.ClickOnBuyButton();
        myCartPage.getAlertTextAndAccept();
        myCartPage.ClickOnCartButton();
        myCartPage.ClickPlaceOrder();
        myCartPage.Name();
        myCartPage.Country();
        myCartPage.City();
        myCartPage.Credit_card();
        myCartPage.Purchase();
        try {
            Alert Alert = driver.switchTo().alert();
            String AlertText = Alert.getText();
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
        myCartPage.Choosing_lumia_1520();
        myCartPage.ClickOnBuyButton();
        myCartPage.getAlertTextAndAccept();
        myCartPage.ClickOnCartButton();
        myCartPage.ClickOnLoginButton();
        myCartPage.login_Name();
        myCartPage.login_Password();
        myCartPage.LoginButtonEnter();
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
        mycart.ClickOnLoginButton();
        mycart.login_Name();
        mycart.login_Password();
        mycart.LoginButtonEnter();
        mycart.Sleep(5);
        mycart.Choosing_lumia_1520();
        mycart.ClickOnBuyButton();
        mycart.getAlertTextAndAccept();
        mycart.ClickOnCartButton();
        mycart.ClickOnHomeButton();
        mycart.ClickOnLoginOutButton();
        mycart.ClickOnCartButton();
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
        mycart.Choosing_lumia_1520();
        mycart.ClickOnBuyButton();
        mycart.getAlertTextAndAccept();
        mycart.ClickOnHomeButton();
        mycart.Choosing_Samsung_galaxy_s6();
        mycart.ClickOnBuyButton();
        mycart.getAlertTextAndAccept();
        mycart.ClickOnCartButton();
        mycart.DeleteButton();
        driver.navigate().refresh();
        mycart.DeleteButton();
        List<WebElement> firstItem = driver.findElements(By.xpath("//*[@id='tbodyid']/tr/td[2]"));
        List<WebElement> secondItem = driver.findElements(By.xpath("//*[@id='tbodyid']/tr[2]/td[2]"));
        try {
            String nokiaPrice = mycart.NokiaPrice();
            Assert.assertNotEquals(nokiaPrice, "820", "Phone found in cart with price 820 after purchase.");
        } catch (NoSuchElementException e) {
            // Expected: item not found in cart after purchase
            Assert.assertTrue(true, "Item not found in cart after purchase, as expected.");
        }
    }

}
