package org.example.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Navigation Bar
    private By HomeButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
    private By CartButton = By.xpath("//*[@id=\"cartur\"]");
    private By LoginButton = By.xpath("//*[@id=\"login2\"]");
    private By LoginButtonEnter = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private By LogoutButton = By.xpath("//*[@id=\"logout2\"]");
    private By SignUpButton = By.xpath("//*[@id=\"signin2\"]");
    private By BuyButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private By PlaceOrder = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private By Purchase = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private By OkayButton = By.xpath("/html/body/div[10]/div[7]/div/button");
    private By Delete = By.xpath("//*[@id=\"tbodyid\"]/tr/td[4]/a");



    // Filters
    private By PhonesFilter = By.xpath("//div[@class='list-group']//a[@onclick=\"byCat('phone')\"]");
    private By LaptopsFilter = By.xpath("//div[@class='list-group']//a[@onclick=\"byCat('notebook')\"]");
    private By MonitorsFilter = By.xpath("//div[@class='list-group']//a[@onclick=\"byCat('monitor')\"]");
    private By FilteredProducts = By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']//div[@class='card-block']/h4/a");


    private By Name = By.xpath("//*[@id=\"name\"]");
    private By Country = By.xpath("//*[@id=\"country\"]");
    private By City = By.xpath("//*[@id=\"city\"]");
    private By Credit_card = By.xpath("//*[@id=\"card\"]");
    private By Month = By.xpath("//*[@id=\"month\"]");
    private By Year = By.xpath("//*[@id=\"year\"]");
    private By login_Name = By.xpath("//*[@id=\"loginusername\"]");
    private By login_Password = By.xpath("//*[@id=\"loginpassword\"]");



    // Products
    // 1st page
    private By Samsung_galaxy_s6 = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
    private By Nokia_lumia_1520 = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a");
    private By Nokia_lumia_1520_Price = By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[3]");
    private By Samsung_galaxy_s6_Price = By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[3]");
    private By Nexus_6 = By.xpath("//div[@class=\"col-lg-4 col-md-6 mb-4\"]//div[@class=\"card h-100\"]//div[@class=\"card-block\"]//h4[@class=\"card-title\"]//a[@href=\"prod.html?idp_=3\"]");
    private By Samsung_galaxy_s7 = By.xpath("//*[@id=\"tbodyid\"]/div[4]/div/div/h4/a");

    private By Sony_vaio_i5 = By.xpath("//*[@id=\"tbodyid\"]/div[8]/div/div/h4/a");
    private By MacBook_air = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a");
    private By MakBook_pro = By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a");

    public By NextButton = By.xpath("//*[@id=\"next2\"]");
    public By PreviousButton = By.xpath("//*[@id=\"prev2\"]");



    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getAlertTextAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void ClickOnHomeButton(){
        driver.findElement(HomeButton).click();
    }
    public void ClickOnCartButton(){
        driver.findElement(CartButton).click();
    }
    public void ClickOnLoginButton(){
        driver.findElement(LoginButton).click();
    }
    public void LoginButtonEnter(){
        driver.findElement(LoginButtonEnter).click();
    }
    public void ClickOnLoginOutButton(){
        driver.findElement(LogoutButton).click();
    }
    public void ClickOnBuyButton(){
        driver.findElement(BuyButton).click();
    }
    public void ClickPlaceOrder(){
        driver.findElement(PlaceOrder).click();
    }
    public void Purchase(){
        driver.findElement(Purchase).click();
    }
    public void OkayButton(){
        driver.findElement(OkayButton).click();
    }
    public void DeleteButton(){
        driver.findElement(Delete).click();
    }




    public void ClickOnSignUpButton(){
        driver.findElement(SignUpButton).click();
    }
    public void Filters_Phones(){
        driver.findElement(PhonesFilter).click();
    }
    public void Filters_Laptops(){
        driver.findElement(LaptopsFilter).click();
    }
    public void Filters_Monitors(){
        driver.findElement(MonitorsFilter).click();
    }

    public List FilteredProducts(){
        List<WebElement> Products = driver.findElements(FilteredProducts);
        return Products;
    }
    public void Choosing_Nexus_6(){
        driver.findElement(Nexus_6).click();
    }
    public String Nokia_lumia_1520_Price(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Nokia_lumia_1520_Price));
        return driver.findElement(Nokia_lumia_1520_Price).getText();
    }
    public String Samsung_galaxy_s6_Price(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Samsung_galaxy_s6_Price));
        return driver.findElement(Samsung_galaxy_s6_Price).getText();
    }
    public void Choosing_Samsung_s7(){
        driver.findElement(Samsung_galaxy_s7).click();
    }
    public void Choosing_lumia_1520(){
        driver.findElement(Nokia_lumia_1520).click();
    }
    public void Choosing_MackBook_air(){
        driver.findElement(MacBook_air).click();
    }
    public void Choosing_Samsung_galaxy_s6(){
        driver.findElement(Samsung_galaxy_s6).click();
    }
    public void Choosing_Sony_Vaio_i5(){
        driver.findElement(Sony_vaio_i5).click();
    }
    public void Choosing_MacBook_Pro(){
        driver.findElement(MakBook_pro).click();
    }
    public void ClickNextButton(){
        driver.findElement(NextButton).click();
    }
    public void ClickPreviousButton(){
        driver.findElement(PreviousButton).click();
    }
    public void Name(){
        driver.findElement(Name).sendKeys("Depi");
    }
    public void Country(){
        driver.findElement(Country).sendKeys("Egypt");
    }
    public void City(){
        driver.findElement(City).sendKeys("Ismailia");
    }
    public void Credit_card(){
        driver.findElement(Credit_card).sendKeys(" 4111 1111 1111 1111");
    }
    public void Month(){
        driver.findElement(Month).sendKeys("12");
    }
    public void Year(){
        driver.findElement(Year).sendKeys("2025");
    }
    public void login_Name(){
        driver.findElement(login_Name).sendKeys("Depi@gmail.com");
    }
    public void login_Password(){
        driver.findElement(login_Password).sendKeys("12345678910");
    }
    public void Sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
