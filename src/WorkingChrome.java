import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingChrome {

    static WebDriver driver=new ChromeDriver();

    public static void viewWeather(String s){
        String searching=s;

        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.clear();
        search.sendKeys(searching);
        search.sendKeys(Keys.ENTER);

        String temperature = driver.findElement(By.id("wob_tm")).getText();
        String day = driver.findElement(By.id("wob_dts")).getText();
        String weather = driver.findElement(By.id("wob_dc")).getText();
        String location = driver.findElement(By.xpath("//span[@class='BBwThe']")).getText();

        System.out.println("For "+ day);
        System.out.println("Temperature is :"+ temperature + "°C");
        System.out.println("Weather is :"+ weather);
        System.out.println("Location is :"+ location + "\n");
    }
    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement translate = driver.findElement(By.xpath("//*[@id='SIvCob']/a"));
        translate.click();

        viewWeather("Weather Today");
        viewWeather("Weather Tomorrow");
    }
}
