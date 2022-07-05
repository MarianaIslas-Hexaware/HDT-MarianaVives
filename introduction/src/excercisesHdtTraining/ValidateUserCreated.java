package excercisesHdtTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidateUserCreated {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().window().maximize();
		
		String repeatedEmail="marianavives123@gmail.com";
		driver.findElement(By.id("email_create")).sendKeys(repeatedEmail);
		driver.findElement(By.cssSelector("i.icon-user")).click();
		//ADD EXPLICIT WAIT
		Thread.sleep(4000);
		if(driver.findElement(By.cssSelector("div[id='create_account_error'] ol li")).getText().contains("An account using this email address has already been registered")) {
			System.out.println(driver.findElement(By.cssSelector("div[id='create_account_error'] ol li")).getText());
		} else {
			Assert.assertTrue(false);
		}
		
		String email = "marianavives123@gmail.com";
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys("mariana123");
		driver.findElement(By.id("SubmitLogin")).click();
		
	}

}
