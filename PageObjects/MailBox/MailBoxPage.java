package MailBox;

import Constant.Constant;
import Railway.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MailBoxPage {

    //Locators
    private final String confirmTemplate = "//td[@class='subject']//a[span[text() = 'Please confirm your account %s']]";
    private final String resetTemplate = "//td[@class='subject']//a[span[text() = 'Please reset your password %s']]";
    private final By activateLink = By.xpath("//div[@id = 'messagebody']//a");

    //Elements
    protected WebElement getConfirmMail (String email) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(confirmTemplate, email)));
    }
    protected WebElement getResetMail (String email) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(resetTemplate, email)));
    }
    protected WebElement getActivateLink () {
        Constant.WEBDRIVER.switchTo().frame("messagecontframe");
        return Constant.WEBDRIVER.findElement(activateLink);
    }

    //Methods
    public void activateAccount (String email) throws InterruptedException {
        this.getConfirmMail(email).click();
        this.getActivateLink().click();
        Thread.sleep(3000);
    }
}
