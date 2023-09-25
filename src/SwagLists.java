import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SwagLists {
    static WebDriver driver = new ChromeDriver();

    public static void LogIn() {
        driver.get("https://www.saucedemo.com/");

        WebElement f_login = driver.findElement(By.id("user-name"));
        WebElement f_password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        f_login.sendKeys("standard_user");
        f_password.sendKeys("secret_sauce");
        loginButton.click();
    }

    //    public static void item(String i){
//        String item = driver.findElement(By.id(i)).getText();
//        System.out.println(item);
//    }
    public static void list_item() {
        List<WebElement> items = driver.findElements(By.className("inventory_item_description"));

        for (WebElement item : items) {
            WebElement productName=item.findElement(By.className("inventory_item_name"));
            String name= productName.getText();

            WebElement productPrice=item.findElement(By.className("inventory_item_price"));
            String price= productPrice.getText();

            System.out.println(name+" "+price);
        }
    }

    public static void main(String[] args) {
        driver.manage().window().maximize();
        LogIn();
        list_item();
//        String a="item_";
//        String b="_title_link";
//        for(int i=0;i<=5;i++)
//        {
//            String name=a+i+b;
//            item(name);
//        };
    }
}
