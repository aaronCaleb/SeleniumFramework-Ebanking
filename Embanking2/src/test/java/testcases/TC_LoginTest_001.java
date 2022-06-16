package testcases;

import Base.BaseClass;
import PageObjects.LoginPage;
import lombok.extern.flogger.Flogger;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
        public void loginTest() throws IOException {
        driver.get(baseUrl);


        LoginPage loginPage=new LoginPage(driver);

        loginPage.setTxtUserName(username);

        loginPage.setTxtPassword(password);

        loginPage.clickSubmit();

        //logger.info("Successful");



        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
        } else{
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);}
    }
}
