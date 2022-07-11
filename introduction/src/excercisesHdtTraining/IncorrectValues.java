package excercisesHdtTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IncorrectValues {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php\r\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("login")).click();
		
		driver.findElement(By.id("email_create")).sendKeys("marianavives12@gmail.com");
		driver.findElement(By.cssSelector("i.icon-user")).click();

		String email = "M3$%2*@lom";
		String name = "M4r13n3";
		String surname = "V1V37";
		String mobile= "abc123";
		String passwd= "!$3";
		String company = "5%O0$";
		String address = "ABC&/(";
		String city = "Z4$0p48";
		String alias = "m$%@.lom";
		String postcode= "A73$";
		
		int count =0;
		
		// PERSONAL INFORMATION
				Assert.assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='Your personal information']")).getText(), "YOUR PERSONAL INFORMATION");
				WebElement radio = driver.findElement(By.id("id_gender2"));
				radio.click();
				driver.findElement(By.id("customer_firstname")).sendKeys(name);					
				driver.findElement(By.id("customer_lastname")).sendKeys(surname);
				
				driver.findElement(By.id("email")).clear();
				driver.findElement(By.id("email")).sendKeys(email);
				
				driver.findElement(By.id("passwd")).sendKeys(passwd);
			
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
				driver.findElement(By.id("company")).sendKeys(company);
				driver.findElement(By.id("address1")).sendKeys(address);
				driver.findElement(By.id("address2")).sendKeys("5th Ave.");
				driver.findElement(By.id("city")).sendKeys(city);

				WebElement dropdownState = driver.findElement(By.id("id_state"));
				Select dropdown4 = new Select(dropdownState);
				driver.findElement(By.id("id_state"));
				dropdown4.selectByIndex(1);
				System.out.println(driver.findElement(By.id("id_state")));
		
				driver.findElement(By.id("postcode")).sendKeys(postcode);
				
				WebElement dropdownCountry = driver.findElement(By.id("id_country"));
				Select dropdown5 = new Select(dropdownCountry);
				driver.findElement(By.id("id_country"));
				dropdown5.selectByIndex(1);
				driver.findElement(By.id("id_country"));
				driver.findElement(By.id("other")).sendKeys("ABCD");
				
				//At least one phone is required
				driver.findElement(By.id("phone")).sendKeys("");
				driver.findElement(By.id("phone_mobile")).clear();
				driver.findElement(By.id("phone_mobile")).sendKeys(mobile);
				
				//Alias is a required field
				driver.findElement(By.id("alias")).clear();
				driver.findElement(By.id("alias")).sendKeys(alias);
	
			
			
			//Test Incorrect Values
				
			//Mobile phone	
			WebDriverWait waitForRedBanner = new WebDriverWait (driver, Duration.ofSeconds(5));
			boolean validMob = isMobileValid(mobile);
			Assert.assertFalse(validMob);
			
				
			//Firstname
			boolean errorFirstName = driver.findElement(By.xpath("//div[@class='required form-group form-error']/input[@id='customer_firstname']")).isDisplayed();
			Assert.assertTrue(errorFirstName);

				
			//Lastname
			boolean errorLastname = driver.findElement(By.xpath("//div[@class='required form-group form-error']/input[@id='customer_lastname']")).isDisplayed();
			waitForRedBanner.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")),"lastname is invalid"));
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText(),"lastname is invalid.");

			//Email
				if (driver.findElement(By.xpath("//div[@class='required form-group form-error']/input[@id='email']")).isDisplayed()) {
					waitForRedBanner.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//div[@class='columns-container']//li[3]")), "email is invalid."));
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[3]")).getText(),"email is invalid.");
					count ++;
					System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}
				
			//Postcode
				if (driver.findElement(By.xpath("//div[@class='required form-group form-error']/input[@id='email']")).getText().isEmpty()) {
					waitForRedBanner.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//div[@class='columns-container']//li[4]")), "postcode is invalid."));
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[4]")).getText(),"postcode is invalid.");
					count ++;
					System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}
				
			//City
				if (city.contains("")) {
					waitForRedBanner.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//div[@class='columns-container']//li[5]")), "city is invalid."));
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[5]")).getText(),"city is invalid.");
					count ++;
					System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}
				
			/*//ID Country
				WebElement country = driver.findElement(By.id("id_country"));
				Select dropdownRequired = new Select(country);
				dropdownRequired.selectByIndex(0);
				WebElement option= dropdownRequired.getFirstSelectedOption() ;				
				String selectedValueInDropdown = option.getText();
				
				if(selectedValueInDropdown.equals("-")){
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[4]")).getText(),"id_country is required.");
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[7]")).getText(),"Country is invalid.");

				count ++;
				System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}*/
				
			//Alias
				if(alias.equals("")) {
					waitForRedBanner.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//div[@class='columns-container']//li[5]")), "city is invalid."));
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[7]")).getText(),"alias is required.");
				}else {
					Assert.assertTrue(false);
				}
								
			//Address 1
				if(address.equals("")) {
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[8]")).getText(),"address1 is required.");
					count++;
					System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}
			
			//City is required
				if (city.equals("")) {
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[9]")).getText(),"city is required.");
					count++;
					System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}				
				
			//Red Banner
				//Mobile field
				waitForRedBanner.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//div[@class='columns-container']//li[5]")), "phone_mobile is invalid."));
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[5]")).getText(), "phone_mobile is invalid.");
				count ++;
				System.out.println(count);
				
				//Error field
				waitForRedBanner.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//div[@class='columns-container']//li[2]")), "firstname is invalid."));
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[2]")).getText(),"firstname is invalid.");
				count ++;
				System.out.println(count);
				
				
				
				//Register Button
				driver.findElement(By.id("submitAccount")).click();
				
				driver.close();
	}
	
public static boolean isMobileValid(String mobile) {
	Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
	Matcher match = ptrn.matcher(mobile);
	return (match.find() && match.group().equals(mobile));
}
	
	
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

