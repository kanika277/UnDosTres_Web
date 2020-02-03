package com.undos.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObject {
    public pageObject(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "operator")
    public WebElement operator;

    @FindBy(xpath = "//div[@class=\"undefined data-value centrarAnything\"]/b")
    public WebElement selectOperator;

    @FindBy(name = "mobile")
    public WebElement mobile;

    @FindBy(name = "amount")
    public WebElement amount;

    @FindBy(xpath="//ul[@class=\"category-list  cat1\"]/li[@data-name=\"10\"]")
    public WebElement selectAmount;

    @FindBy(xpath = "//div[@class=\"next\"]/button")
    public WebElement button;

    @FindBy(xpath = "//div[@class=\"list-group\"]/a[@class=\"list-group-item text-center walletshow select-wallet\"]")
    public WebElement Monedero;



}
