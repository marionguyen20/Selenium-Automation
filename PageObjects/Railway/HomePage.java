package Railway;

import Constant.Constant;

//Class encapsulates the Home Page and is the starting point of all test cases
public class HomePage extends GeneralPage {
    //Locators
    //Elements
    //Methods
    public HomePage open () {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
