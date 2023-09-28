package DemoLab;

import org.openqa.selenium.*;

import java.util.List;

public class DemoLabElements    {
    WebDriver driver;
    public void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void closing(){
        sleep(500);
        driver.close();
        System.out.println("Driver is closing");
    }
    public boolean isAlertPresent()
    {
        try
        {
            acceptAlert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }
    public void acceptAlert(){
        sleep(1000);
        String note= driver.switchTo().alert().getText();
        System.out.println("There seems to be an issue: "+note);
        driver.switchTo().alert().accept();
    }
    public void signUp(String user,String pass){
        driver.findElement(By.id("signin2")).click();
        sleep(500);
        WebElement username=driver.findElement(By.id("sign-username"));
        username.clear();
        username.sendKeys(user);
        WebElement password=driver.findElement(By.id("sign-password"));
        password.clear();
        password.sendKeys(pass);
        sleep(1000);

        WebElement signUpBtn=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        JavascriptExecutor javaexe = (JavascriptExecutor)driver;
        javaexe.executeScript("arguments[0].click();",signUpBtn);

        if (isAlertPresent()) {
            sleep(500);

            WebElement closeBtn = driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
            JavascriptExecutor javaexe1 = (JavascriptExecutor) driver;
            javaexe1.executeScript("arguments[0].click();", closeBtn);
        }
    }
    public void login(String user, String pass){
        driver.findElement(By.id("login2")).click();
        sleep(500);
        WebElement username=driver.findElement(By.id("loginusername"));
        username.clear();
        username.sendKeys(user);
        WebElement password=driver.findElement(By.id("loginpassword"));
        password.clear();
        password.sendKeys(pass);
        sleep(1000);

        driver.findElement(By.xpath("//*[@onclick='logIn()']")).click();
        if (!isAlertPresent()){
            System.out.println("Logged in Successfully");
        }else {
            sleep(2000);
            WebElement closeBtn=driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
            JavascriptExecutor javaexe3 = (JavascriptExecutor)driver;
            javaexe3.executeScript("arguments[0].click();",closeBtn);
            System.out.println("Not Logged In");

        }
    }
    public void listings(){
        sleep(2000);
        List<WebElement> items=driver.findElements(By.className("h-100"));
        for (WebElement item: items){
            WebElement productName =item.findElement(By.className("hrefch"));
            System.out.println(productName.getText());
        }
    }
    DemoLabElements(WebDriver driver){
        this.driver=driver;
    }
}
