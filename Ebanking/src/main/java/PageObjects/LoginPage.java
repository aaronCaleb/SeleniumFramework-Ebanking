package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath ="//input[@id='email']")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(xpath = "//input[@id='pass']")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[@id='u_0_k_2a']")
    @CacheLookup
    WebElement btnLogin;


    public void setUserName(String uname)
    {

        txtUserName.sendKeys(uname);
    }

    public void setPassword(String pwd)
    {

        txtPassword.sendKeys(pwd);
    }


    public void clickSubmit()
    {

        btnLogin.click();
    }


}

