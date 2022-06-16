package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.ILoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utility.ReadConfig;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    ReadConfig readConfig=new ReadConfig();
    public String baseUrl= readConfig.getApplicationUrl();
    public String username= readConfig.getUserName();
    public String password= readConfig.getPassword();

    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
        public void setUp(String br) {
        logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");
        if (br.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (br.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (br.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterClass
        public void tearDown(){
            driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source =takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

}
