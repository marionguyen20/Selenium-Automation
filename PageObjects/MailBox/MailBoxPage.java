package MailBox;

import Constant.Constant;
import Railway.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MailBoxPage {

    //Locators
    private final String confirmTemplate = "//td[@class='subject']//a[span[text() = 'Please confirm your account %s']]";
    private final String resetTemplate = "//td[@class='subject']//a[span[text() = 'Please reset your password %s']]";
    private final String emailSubjectTemplate = "//div[@id='message-header']//h2[contains(., 'Please confirm your account %s')]";
    private final By activateLink = By.xpath("//div[@id = 'messagebody']//a");

    //Elements
    protected WebElement findElement (By by) {
        WebDriverWait wdw = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIMEOUT));
        wdw.until(expectedConditions.visibilityOfElementLocated(by));
    }
    protected WebElement getConfirmMail (String email) {
        return findElement(By.xpath(String.format(confirmTemplate, email)));
    }
    protected WebElement getResetMail (String email) {
        return findElement(By.xpath(String.format(resetTemplate, email)));
    }

    //Inside iframe1
    protected WebElement getEmailSubject (String email) {
        return findElement(By.xpath(String.format(emailSubjectTemplate, email)));
    }
    protected WebElement getActivateLink () {
        return findElement(activateLink);
    }


    //Methods
    public void activateAccount (String email) throws InterruptedException {
        this.getConfirmMail(email).click();
        Constant.WEBDRIVER.switchTo().frame("messagecontframe");
        this.getEmailSubject();
        this.getActivateLink().click();
        Thread.sleep(3000);
    }
}
