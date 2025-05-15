package Tests;

import Base.OpenDriver;
import org.example.Pages.ContactPage;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTests extends OpenDriver {

    @Test(priority = 1)
    public void ContactOpen() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        String ContactAsureince = contact.Contact();
        Assert.assertEquals(ContactAsureince, "Contact Name:", "Found Contact Page");
    }

    @Test(priority = 2)
    public void VaildData() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertTrue(alertText.contains("Thanks"), "Expected success alert");
        } catch (NoAlertPresentException e) {
            Assert.fail("Expected alert did not appear for valid data");
        }
    }

    @Test(priority = 3)
    public void EmptyData() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Empty form should not show success message");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 4)
    public void AddJavaCodeInMassage() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("Salma");
        contact.Message("System.out.print(\"Enter a number: \");");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Code in message should not be accepted");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 5)
    public void InvaildEmai() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("test@com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Invalid email should not be accepted");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 6)
    public void LongUserCharacter() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("JonathanAlexanderMaximilianTheodoreChristopherBenjaminNathanielFrederickWilliamHarrisonMontgomeryJameson");
        contact.Message("Hello World");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Long name should not be accepted");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 7)
    public void ContactOpenAndClose() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        String ContactAsureince = contact.Contact();
        Assert.assertEquals(ContactAsureince, "Contact Name:", "Found Contact Page");
        contact.ClickOn_Close_ContactButton();
    }

    @Test(priority = 8)
    public void SpecialCharactersInTheNameField() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("@John#Doe$%^&*!~+=(){}[]|;:<>,.?/");
        contact.Message("Hello World");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Special characters in name should not be accepted");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 9)
    public void LeaveTheMessageFieldEmpty() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("Salma");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Empty message should not be accepted");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 10)
    public void LeaveTheEmailFieldEmpty() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Empty email should not be accepted");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 11)
    public void WithOutName() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("Depigmail@.com");
        contact.Message("Hello World");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Missing name should not be accepted");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 12)
    public void WrongEmail() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("Depigmail.com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();

        try {
            String alertText = contact.getAlertTextAndAccept();
            Assert.assertNotEquals(alertText, "Thanks for the message!!",
                    "Wrong email format should not be accepted");
        } catch (NoAlertPresentException e) {
            Assert.assertTrue(true, "No alert appeared as expected");
        }
    }

    @Test(priority = 13)
    public void TryInvaildEmail2() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        contact.ContactEmail("test@com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();

        String alertText = contact.getAlertTextAndAccept();
        System.out.println("First alert appeared with text: " + alertText);

        contact.ClickOnContactButton();
        contact.ContactEmail("Depi@gmail.com");
        contact.ContactName("Salma");
        contact.Message("Hello World");
        contact.SendMassageButton();

        try {
            alertText = contact.getAlertTextAndAccept();
            Assert.assertTrue(alertText.contains("Thanks"),
                    "Valid submission after invalid should show success");
        } catch (NoAlertPresentException e) {
            Assert.fail("Expected success alert after valid submission");
        }
    }

    @Test(priority = 14)
    public void ClickAnywhereOutside() {
        ContactPage contact = new ContactPage(driver);
        contact.ClickOnContactButton();
        Actions actions = new Actions(driver);
        String ContactAsureince = contact.Contact();
        Assert.assertEquals(ContactAsureince, "Contact Name:", "Found Contact Page");
        actions.moveByOffset(200, 300).click().perform();
    }
}