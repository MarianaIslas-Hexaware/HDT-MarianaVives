package excercisesHdtTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;


public class InvalidAddress {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().window().maximize();
		
		String repeatedEmail= "marianavives123@gmail.com";
		String invalidEmail= "mariana@gmail";

		driver.findElement(By.id("email")).sendKeys(invalidEmail);
		/*Actions a = new Actions (driver);
		a.moveToElement(driver.findElement(By.id("passwd"))).build().perform();
		a.click();*/
		driver.findElement(By.id("passwd")).sendKeys("mariana123");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-group form-error']/input[@id='email']")).isDisplayed());
		
		
		driver.findElement(By.id("SubmitLogin")).click();

		if(driver.findElement(By.cssSelector(".alert-danger")).getText().contains("Invalid email address")) {
			System.out.println(driver.findElement(By.cssSelector(".alert-danger")).getText());
		} else {
			Assert.assertTrue(false);
		}	
	
	}
}
