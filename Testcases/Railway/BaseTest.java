package Railway;

import Constant.Constant;
import MailBox.LoginMailBoxPage;
import MailBox.MailBoxPage;
import Utilities.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    HomePage homePage = new HomePage ();

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

    public void createAndActivateAccount (Account account) throws InterruptedException {
        //Create new account
        homePage
            .open()
            .gotoRegisterPage()
            .register(account);

        //Activate Account
        LoginMailBoxPage loginMailBoxPage = new LoginMailBoxPage ();
        MailBoxPage mailBoxPage = loginMailBoxPage
                .open()
                .loginMailBox(Constant.USERNAME_MAILBOX, Constant.PASSWORD_MAILBOX);
        
        mailBoxPage.activateAccount(account.getEmail());
        Utilities.closeWindow();
    }
}
