package DemoLab;

import Utilities.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoLabMain {
    static final WebDriver driver= utility.WebDriver("chrome");
    static DemoLabElements ele= new DemoLabElements(driver);

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com");
        ele.signUp("sarah","sarah");

//      Invalid
        ele.login("$arah1234","sarah");

//        Valid
        ele.login("$arah1234","$arah1234");

        ele.listings();
        ele.closing();

    }
}
