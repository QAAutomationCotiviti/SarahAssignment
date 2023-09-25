import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SwagAddToCart {
    static WebDriver driver = new ChromeDriver();
    public static void clicked(String id){
        WebElement item = driver.findElement(By.id(id));
        item.click();
    }
    public static void login() {
        driver.get("https://www.saucedemo.com/");

        WebElement f_login = driver.findElement(By.id("user-name"));
        WebElement f_password = driver.findElement(By.id("password"));

        f_login.sendKeys("standard_user");
        f_password.sendKeys("secret_sauce");
        clicked("login-button");
    }

    public static void Add() {
        WebElement addtocart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        String before = addtocart.getAttribute("id");
        addtocart.click();

        WebElement check = driver.findElement(By.xpath("//*[@class='btn btn_secondary btn_small btn_inventory']"));
        String after = check.getAttribute("id");

        if (!before.equals(after))
            System.out.println("The item was added to check_cart");
        else System.out.println("The item was not added to check_cart");
    }
    public static void check_cart(){
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();
        System.out.println("The items in the check_cart are:");
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));

        for (WebElement item : items) {
            String name = item.getText();
            System.out.println(name);
        }
    }
    public static void fillCheckOut(){
        WebElement f_name = driver.findElement(By.id("first-name"));
        WebElement l_name = driver.findElement(By.id("last-name"));
        WebElement zip = driver.findElement(By.id("postal-code"));

        f_name.sendKeys("Sarah");
        l_name.sendKeys("Gorkhali");
        zip.sendKeys("44700");

        clicked("continue");
        clicked("finish");
    }
    public static void main(String[] args) {
        driver.manage().window().maximize();
        login();
        Add();
        check_cart();
        clicked("remove-sauce-labs-backpack");
        clicked("continue-shopping");
        Add();
        check_cart();
        clicked("checkout");
        fillCheckOut();
    }
}
