package Railway;

import Constant.Constant;
import Utilities.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage;

    @BeforeMethod
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe" );
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
//        Constant.WEBDRIVER.manage().window();
    }
    @AfterMethod
    public void tearDown (){
        Constant.WEBDRIVER.quit();
    }
}
