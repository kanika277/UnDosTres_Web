package com.undos.web.steps;

import com.undos.web.pages.pageObject;
import com.undos.web.pages.paymentPage;
import com.undos.web.util.BrowserFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class rechargeSteps {

    WebDriver driver;
    paymentPage paypage;

    @Given("the user starts the application")
    public void theUserStartsTheApplication() {
        driver = BrowserFactory.getInstance().getDriver();
        driver.navigate().to("https://prueba.undostres.com.mx");
    }

    @When("the user fills operator and number in the respective field and clicks")
    public void theUserFillsOperatorAndNumberInTheRespectiveFieldAndClicks() throws InterruptedException {
        if (driver.getCurrentUrl().equals("https://prueba.undostres.com.mx/")) {
            pageObject payment = new pageObject(driver);
            payment.operator.click();
            payment.selectOperator.click();
            payment.mobile.sendKeys("5523261151");
            payment.amount.click();
            payment.selectAmount.click();
            Thread.sleep(1000);
            payment.button.click();
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(payment.Monedero));    // wait to page to reload
        }
    }

    @Then("the user should navigate to Payment page")
    public void theUserShouldNavigateToPaymentPage() {

        Assert.assertEquals("https://prueba.undostres.com.mx/payment.php", driver.getCurrentUrl());   // validation
    }

    @When("the user fills the details on payment page and clicks the pay button")
    public void theUserFillsTheDetailsOnPaymentPageAndClicksThePayButton() {
        paypage = new paymentPage(driver);
        paypage.tarjeta.click();
        paypage.cardname.sendKeys("Test");
        paypage.cardnumber.sendKeys("4111111111111111");
        paypage.cardmonth.sendKeys("11");
        paypage.cardyear.sendKeys("2025");
        paypage.cvv.sendKeys("111");
        paypage.email.sendKeys("test@test.com");
        paypage.payButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(paypage.popup));
    }

    @And("the user fills the pop up with the given credentials")
    public void theUserFillsThePopUpWithTheGivenCredentials() throws InterruptedException {
        if (driver.findElement(By.xpath("//div[@class=\"facebookButton point\"]")) != null) {
            paypage.popupemail.sendKeys("marze.zr@gmail.com ");
            paypage.popuppwd.sendKeys("123456");
            WebElement iframeSwitch= driver.findElement(By.xpath("//div[@class=\"g-recaptcha\"]/div/div/iframe"));
            driver.switchTo().frame(iframeSwitch);
            driver.findElement(By.xpath("//div[@class=\"rc-anchor-center-item rc-anchor-checkbox-holder\"]/span/div[@class=\"recaptcha-checkbox-border\"]")).click();
        }
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        paypage.login.click();
        Thread.sleep(2000);

    }

    @Then("the credentials should be validated")
    public void theCredentialsShouldBeValidated()  {
        if(paypage.login.isDisplayed())
        {
            System.out.println("Login Unsuccessful: Invalid Credentials");
        }
        else
        {
            System.out.println("Login Successful");
        }
    }
}

