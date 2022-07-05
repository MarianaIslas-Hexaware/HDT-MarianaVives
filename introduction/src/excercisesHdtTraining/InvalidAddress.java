package excercisesHdtTraining;

import java.util.ArrayList;
import java.util.regex.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class InvalidAddress {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().window().maximize();
		
		String repeatedEmail= "marianavives123@gmail.com";
		String invalidEmail= "mariana@gmail";

		driver.findElement(By.id("email")).sendKeys(invalidEmail);
		driver.findElement(By.id("passwd")).sendKeys("mariana123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		//ADD EXPLICIT WAIT
		
		
		Thread.sleep(4000);
		if(driver.findElement(By.cssSelector(".alert-danger")).getText().contains("Invalid email address")) {
			System.out.println(driver.findElement(By.cssSelector(".alert-danger")).getText());
		} else {
			Assert.assertTrue(false);
		}	
		
		/*ArrayList <String> invalidEmail = new ArrayList <String>();
		invalidEmail.add("mariana.com");
		invalidEmail.add("mariana@com");
		invalidEmail.add("mariana#abc.com");
		invalidEmail.add("mariana@domaincom");
		
		//Regular expression: 
			//For the domain part: "^(.+)@(.+)$"
			//
		String regex =  "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
		
		//Compile regular expression to get the patter
		Pattern pattern = Pattern.compile(regex);
		for (String email : invalidEmail) {
			Matcher match = pattern.matcher(email);
			System.out.println(email + ":" + match.matches()+"\n");
		}*/
		
		
	}
}
