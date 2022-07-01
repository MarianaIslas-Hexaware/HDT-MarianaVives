package excercisesHdtTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class InvalidAddress {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().window().maximize();
		
		String invalidEmail = "mariana.com";
		
		driver.findElement(By.id("email")).sendKeys(invalidEmail);
		driver.findElement(By.id("passwd")).sendKeys("mariana123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		if(driver.findElement(By.cssSelector(".alert-danger")).getText().contains("Invalid email address")) {
			System.out.println(driver.findElement(By.cssSelector(".alert-danger")).getText());
		} else {
			Assert.assertTrue(false);
		}
	}
}
