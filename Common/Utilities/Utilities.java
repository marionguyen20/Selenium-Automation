package Utilities;
import Constant.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Set;

public class Utilities {
    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }
    public static String normalizeSpace (String text) {
        return StringUtils.normalizeSpace(text);
    }
    public static String generateEmail () {
        Random rand = new Random();
        int len = rand.nextInt(100);
        String generateString = RandomStringUtils.randomAlphabetic(6);
        return generateString + len + "@gmail.com";
    }
    public static String generatePassword () {
        Random rand = new Random();
        int len = rand.nextInt(100);
        String generateString = RandomStringUtils.randomAlphabetic(8);
        return generateString + len;
    }
    public static String generatePid () {
        Random rand = new Random();
        int len = rand.nextInt(100);
        String generateString = RandomStringUtils.randomAlphabetic(8);
        return generateString + len;
    }
    public static void closeWindow () {
        String originalWindow = Constant.WEBDRIVER.getWindowHandle();
        Set handles = Constant.WEBDRIVER.getWindowHandles();
        handles.remove(originalWindow);
        String nextWindow = String.valueOf(handles.iterator().next());
        Constant.WEBDRIVER.switchTo().window(nextWindow);
        Constant.WEBDRIVER.close();
        Constant.WEBDRIVER.switchTo().window(originalWindow);
    }
}
