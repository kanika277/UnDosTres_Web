package com.undos.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentPage {

    public paymentPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class= \"field form-group\"]/input[@class= \"form-control cardname\"]")
    public WebElement cardname;

    @FindBy(xpath = "//div[@class= \"field input-group\"]/input[@class= \"form-control cardnumber\"]")
    public WebElement cardnumber;

    @FindBy(xpath = "//div[@class= \"field col-xs-5 col-md-5 paddleft0\"]/input[@class= \"form-control expmonth\"]")
    public WebElement cardmonth;

    @FindBy(xpath = "//div[@class= \"field col-xs-7 col-md-7 paddleft0\"]/input[@class= \"form-control expyear\"]")
    public WebElement cardyear;

    @FindBy(xpath = "//div[@class=\"field form-group\"]/input[@class= \"form-control cvv\"]")
    public WebElement cvv;

    @FindBy(name = "Guardar esta tarjeta")
    public  WebElement savedetails;

    @FindBy(xpath = "//div[@class=\"field form-group\"]/input[@class= \"form-control email\"]")
    public WebElement email;

    @FindBy(id="paylimit")
    public  WebElement payButton;

    @FindBy(xpath = "//div[@class= \"modal-body\"]")
    public WebElement popup;

    @FindBy(name = "email")
    public WebElement popupemail;

    @FindBy(name = "password")
    public WebElement popuppwd;

    @FindBy(xpath = "//div[@class=\"recaptcha-checkbox-border\"]")
    public WebElement captcha;

    @FindBy(xpath = "//div[@class=\"list-group\"]/a[@class=\"list-group-item text-center select-card active\"]")
    public WebElement tarjeta;

    @FindBy(id = "loginBtn")
    public WebElement login;


}
