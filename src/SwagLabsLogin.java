import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsLogin {
    static WebDriver driver= new ChromeDriver();
    public static void logout(){
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
        System.out.println("Logged Out");
    }
    public static void useCase(String sce, String user,String pass){
        driver.get("https://www.saucedemo.com/");

        WebElement f_login = driver.findElement(By.id("user-name"));
        WebElement f_password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        f_login.clear();
        f_password.clear();
        f_login.sendKeys(user);
        f_password.sendKeys(pass);
        loginButton.click();

        String page = "https://www.saucedemo.com/inventory.html";
        String url =driver.getCurrentUrl();

        if (url.equals(page)) {
            System.out.println("Test Scenario " + sce + " :- Logged In Successful");
            logout();
        }
        else{
            String error = driver.findElement(By.xpath("//*[@data-test='error']")).getText();
            System.out.println("Test Scenario "+ sce + " :- UnSuccessful \n" + error +"\n");
        }
    }
    public static void Case(){
        useCase("1. Both Empty","","");
        useCase("2. Password Empty","standard_user","");
        useCase("3. UserName Empty","","secret_sauc");
        useCase("4. Correct User, Correct Password","standard_user","secret_sauce");
        useCase("5. Correct User, Incorrect Password","standard_user","secret_sauc");
        useCase("6. InCorrect User, Correct Password","standard_use","secret_sauce");
        useCase("7. InCorrect User, Incorrect Password","standard_usr","secret_sauc");
        useCase("8. Locked out User","locked_out_user","secret_sauce");
        useCase("9. Problem User","problem_user","secret_sauce");
        useCase("10. Performance glitch User","performance_glitch_user","secret_sauce");
    }
    public static void main(String[] args) {
        driver.manage().window().maximize();
        Case();
    }
}
