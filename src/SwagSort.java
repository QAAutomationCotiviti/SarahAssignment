import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SwagSort {
    static WebDriver driver = new ChromeDriver();

    public static void login() {
        driver.get("https://www.saucedemo.com/");

        WebElement f_login = driver.findElement(By.id("user-name"));
        WebElement f_password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        f_login.sendKeys("standard_user");
        f_password.sendKeys("secret_sauce");
        loginButton.click();
    }

    public static void sort(String s) {
        Select order = new Select(driver.findElement(By.className("product_sort_container")));
        switch (s) {
            case "asce" -> {
                order.selectByValue("az");
                System.out.println("\nSorted Ascending");
                list_item();
            }
            case "dese" -> {
                order.selectByValue("za");
                System.out.println("\nSorted Descending");
                list_item();
            }
            case "lohi" -> {
                order.selectByValue("lohi");
                System.out.println("\nSorted Low to High");
                list_item();
            }
            case "hilo" -> {
                order.selectByValue("hilo");
                System.out.println("\nSorted High to Low");
                list_item();
            }
        }
    }
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
        login();
        sort("asce");
        sort("dese");
        sort("lohi");
        sort("hilo");
    }
}
