package Constant;

import Railway.Account;
import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railwaysg2.somee.com/Page/HomePage.cshtml";
    public static final String MAILBOX_URL = "http://mail.trainingliving.com/webmail";
    public static final String USERNAME_MAILBOX = "safe.railway@trainingliving.com";
    public static final String PASSWORD_MAILBOX = "Logigear123!!";
    public static final String USERNAME = "thanh.nguyen@gmail.com";
    public static final String PASSWORD = "12345678";
    public static final Account DEFAULT_ACCOUNT = new Account(USERNAME, PASSWORD);

    public static final long TIMEOUT = 30;
}
