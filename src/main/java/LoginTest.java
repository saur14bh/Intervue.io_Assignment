import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.intervue.io/");

            // To go to the login page
            WebElement loginBtn = driver.findElement(By.linkText("Login"));
            loginBtn.click();

            // Switch to the new tab
            Thread.sleep(2000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait for and click the green center login button
            WebElement customLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[text()='Login' and contains(@class, 'AccessAccount-ColoredButton-Text')]")));
            customLoginBtn.click();

            // Fill in the login details
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailField.sendKeys("neha@intervue.io");

            Thread.sleep(1500);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("Ps@neha@123");

            // Click final login button inside form
            WebElement finalLoginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//form//button[.='Login with email']")));
            finalLoginButton.click();

            Thread.sleep(3000);

            // Click the search bar to write the input
            WebElement searchTrigger = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(@class, 'search_placeholder')]")));
            searchTrigger.click();

            // Wait for the input screen popup to appear
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Type what you want to search for']")));

            // Type into the input
            searchInput.sendKeys("hello" + Keys.ENTER);

            Thread.sleep(2000);

            // Click on the suggestion that comes based on the input
            WebElement helloSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'style__Wrapper') and .//span[text()='hello']]")));
            helloSuggestion.click();

            Thread.sleep(2000);

            // Click on the profile avatar
            WebElement profileDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'ProfileHeader__StyedDropdownHoverLink')]")));
            profileDropdown.click();

            Thread.sleep(2000);

            // Click on the logout button from the dropdown menu
            WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@href='/logout' and contains(text(), 'Logout')]")));
            logoutBtn.click();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
