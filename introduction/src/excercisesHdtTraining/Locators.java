package excercisesHdtTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://automationpractice.com/index.php\r\n");

		String email = "marianavs1234@gmail.com";
		String name = "Mariana";
		String surname = "Vives";
		String mobile = "3324943509";

		// PERSONAL INFORMATION
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.cssSelector("i.icon-user")).click();
		WebDriverWait waitPageToLoad = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitPageToLoad.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Your personal information']")));
		Assert.assertEquals(
				driver.findElement(By.xpath("//h3[normalize-space()='Your personal information']")).getText(),
				"YOUR PERSONAL INFORMATION");
		WebElement radio = driver.findElement(By.id("id_gender2"));
		radio.click();
		driver.findElement(By.id("customer_firstname")).sendKeys(name);

		// Assert.assertFalse(driver.findElement(By.id("customer_firstname")).getText().isEmpty());

		driver.findElement(By.id("customer_lastname")).sendKeys(surname);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys("mariana123");

		// Select dropdown items
		driver.findElement(By.id("days")).click();
		WebElement dropdownDays = driver.findElement(By.id("days"));
		Select dropdown1 = new Select(dropdownDays);
		dropdown1.selectByIndex(28);
		dropdown1.getFirstSelectedOption();
		System.out.println(dropdown1.getFirstSelectedOption().getText());

		WebElement dropdownMonth = driver.findElement(By.id("months"));
		Select dropdown2 = new Select(dropdownMonth);
		dropdown2.selectByIndex(10);
		dropdown2.getFirstSelectedOption();
		System.out.println(dropdown2.getFirstSelectedOption().getText());

		WebElement dropdownYear = driver.findElement(By.id("years"));
		Select dropdown3 = new Select(dropdownYear);
		dropdown3.selectByValue("1993");
		dropdown3.getFirstSelectedOption();
		System.out.println(dropdown3.getFirstSelectedOption().getText());

		// Checkboxes
		Assert.assertFalse(driver.findElement(By.id("newsletter")).isSelected());
		driver.findElement(By.id("newsletter")).click();
		Assert.assertTrue(driver.findElement(By.id("newsletter")).isSelected());
		driver.findElement(By.id("newsletter")).click();

		Assert.assertFalse(driver.findElement(By.id("optin")).isSelected());
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("phone_mobile")).sendKeys(mobile);
		driver.findElement(By.id("optin")).click();

		// Your address
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(name);
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(surname);
		driver.findElement(By.id("company")).sendKeys("Hexaware");
		driver.findElement(By.id("address1")).sendKeys("P. Sherman Calle Wallaby 42 Sydney");
		driver.findElement(By.id("address2")).sendKeys("5th Ave.");
		driver.findElement(By.id("city")).sendKeys("New York");

		WebElement dropdownState = driver.findElement(By.id("id_state"));
		Select dropdown4 = new Select(dropdownState);
		driver.findElement(By.id("id_state"));
		dropdown4.selectByIndex(5);
		System.out.println(driver.findElement(By.id("id_state")));

		// Postcode must have the format 00000
		String postCode = "00000";
		driver.findElement(By.id("postcode")).sendKeys(postCode);

		WebElement dropdownCountry = driver.findElement(By.id("id_country"));
		Select dropdown5 = new Select(dropdownCountry);
		driver.findElement(By.id("id_country"));
		dropdown5.selectByIndex(1);
		driver.findElement(By.id("id_country"));
		driver.findElement(By.id("other")).sendKeys("ABCD");

		// At least one phone is required
		driver.findElement(By.id("phone")).sendKeys("18003456345");
		driver.findElement(By.id("phone_mobile")).clear();
		driver.findElement(By.id("phone_mobile")).sendKeys(mobile);
		if (driver.findElement(By.id("phone_mobile")).getText() != "") {
			System.out.println(driver.findElement(By.id("phone_mobile")).getText());
		} else {
			Assert.assertTrue(false);
		}

		// Alias is a required field
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Mari");
		if (driver.findElement(By.id("phone_mobile")).getText() != "") {
			System.out.println(driver.findElement(By.id("phone_mobile")).getText());
		} else {
			Assert.assertTrue(false);
		}

		// Register Button
		driver.findElement(By.id("submitAccount")).click();
	}

	/*
	 * public static requiredField (WebDriver driver) { if (driver !="") {
	 * System.out.println(driver.findElement(By.id("phone_mobile")).getText()); } }
	 * else { Assert.assertTrue(false); }
	 */
}