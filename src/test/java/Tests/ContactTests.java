package Tests;

import Base.OpenDriver;
import org.example.Pages.ContactPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTests extends OpenDriver {
    @Test(priority = 1)
    public void ContactOpen(){
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        String ContactAsureince = contact.Contact();
        Assert.assertEquals(ContactAsureince,"Contact Name:","Found Contact Page");
    }
    @Test(priority = 2)
    public void VaildData() {
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert appeared with text: " + alertText);
            alert.accept();
            Assert.assertTrue(true, "Alert appeared");

        } catch (NoAlertPresentException e) {
            Assert.fail("No alert appeared — test failed");
        }
    }
    @Test(priority = 3)
    public void EmptyData() {
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        }
        catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }
    @Test(priority = 4)
    public void AddJavaCodeInMassage(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("Salma");
        contact.Message("System.out.print(\"Enter a number: \");");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared wrong massage");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        }
        catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }
    @Test(priority = 5)
    public void InvaildEmai(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("test@com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared invaild email");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        }
        catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }
    @Test(priority = 6)
    public void LongUserCharacter(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("JonathanAlexanderMaximilianTheodoreChristopherBenjaminNathanielFrederickWilliamHarrisonMontgomeryJameson");
        contact.Message("Hello World");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared Should Make Error on long character name");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        }
        catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }
    @Test(priority = 7)
    public void ContactOpenAndClose(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        String ContactAsureince = contact.Contact();
        Assert.assertEquals(ContactAsureince,"Contact Name:","Found Contact Page");
        contact.ClickOn_Close_ContactButton();
        contact.Sleep(2);

    }
    @Test(priority = 8)
    public void SpecialCharactersInTheNameField() {
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("@John#Doe$%^&*!~+=(){}[]|;:<>,.?/");
        contact.Message("Hello World");
        contact.SendMassageButton();
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared Should Make Error Special character");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }
    @Test(priority = 9)
    public void LeaveTheMessageFieldEmpty(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("Salma");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared no massage");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }
    @Test(priority = 10)
    public void LeaveTheEmailFieldEmpty(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared no email");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }@Test(priority = 11)
    public void WithOutName(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("Depigmail@.com");
        contact.Message("Hello World");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared Should Make Error no name");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }
    @Test(priority = 12)
    public void WrongEmail(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("Depigmail.com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Thanks for the message!!")) {
                Assert.fail("Test failed: Alert with message 'Thanks for the message!!' appeared Should Make Error wrong Email");
            } else {
                alert.accept();
                Assert.assertTrue(true, "Different alert appeared — test passed");
            }
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared — test passed");
        }
    }@Test(priority = 13)
    public void TryInvaildEmail2(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("test@com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();
        contact.Sleep(4);
        Alert Alert = driver.switchTo().alert();
        Alert.accept();
        contact.ClickOnContactButton();
        contact.Sleep(2);
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();
        contact.Sleep(4);
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert appeared with text: " + alertText);
            alert.accept();
            Assert.assertTrue(true, "Alert appeared");

        } catch (NoAlertPresentException e) {
            Assert.fail("No alert appeared — test failed");
        }
    }
    @Test(priority = 14)
    public void  ClickAnywhereOutside(){
        ContactPage contact = new ContactPage(driver);
        contact.Sleep(4);
        contact.ClickOnContactButton();
        contact.Sleep(2);
        Actions actions = new Actions(driver);
        String ContactAsureince = contact.Contact();
        Assert.assertEquals(ContactAsureince,"Contact Name:","Found Contact Page");
        actions.moveByOffset(200, 300).click().perform();
        contact.Sleep(4);
    }
}
