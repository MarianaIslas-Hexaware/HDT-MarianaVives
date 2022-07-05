package excercisesHdtTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RequiredFields {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicit wait to let items to appear on the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().window().maximize();
		
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("marianavives123@abc.com");
		
		driver.findElement(By.cssSelector("i.icon-user")).click();
		
		String email = "";
		String name = "";
		String surname = "";
		String mobile= "";
		String passwd= "";
		String company = "";
		String address = "";
		String city = "";
		String alias = "";
		
		int count =0;
		
		// PERSONAL INFORMATION
				Assert.assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='Your personal information']")).getText(), "YOUR PERSONAL INFORMATION");
				WebElement radio = driver.findElement(By.id("id_gender2"));
				radio.click();
				driver.findElement(By.id("customer_firstname")).sendKeys(name);
		
				//Assert.assertFalse(driver.findElement(By.id("customer_firstname")).getText().isEmpty());
					
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
				dropdown4.selectByIndex(0);
				System.out.println(driver.findElement(By.id("id_state")));
		
				String postCode= "";
				driver.findElement(By.id("postcode")).sendKeys(postCode);
				
				WebElement dropdownCountry = driver.findElement(By.id("id_country"));
				Select dropdown5 = new Select(dropdownCountry);
				driver.findElement(By.id("id_country"));
				dropdown5.selectByIndex(0);
				driver.findElement(By.id("id_country"));
				driver.findElement(By.id("other")).sendKeys("ABCD");
				
				//At least one phone is required
				driver.findElement(By.id("phone")).sendKeys("");
				driver.findElement(By.id("phone_mobile")).clear();
				driver.findElement(By.id("phone_mobile")).sendKeys(mobile);
				if (driver.findElement(By.id("phone_mobile")).getText()!="") {
					System.out.println(driver.findElement(By.id("phone_mobile")).getText());
				}else {
					Assert.assertTrue(false);
				}
				
				//Alias is a required field
				driver.findElement(By.id("alias")).clear();
				driver.findElement(By.id("alias")).sendKeys(alias);
				if (driver.findElement(By.id("phone_mobile")).getText()!="") {
					System.out.println(driver.findElement(By.id("phone_mobile")).getText());
				}else {
					Assert.assertTrue(false);
				}
				
				//Register Button
				driver.findElement(By.id("submitAccount")).click();
			
			//Required fields
			//Mobile phone
				if (mobile.equals("")) {
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText(), "You must register at least one phone number.");
					count ++;
					System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}
				
			//Firstname
				if(name.equals("")){
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[3]")).getText(),"firstname is required.");
					count ++;
					System.out.println(count);
					
				}else {
					Assert.assertTrue(false);
				}
				
			//Lastname
				if (name.equals("")) {
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[2]")).getText(),"lastname is required.");
					count ++;
					System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}
				
			//Email
				if (email.equals("")) {
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[4]")).getText(),"email is required.");
					count ++;
					System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}
				
			//Password
				if (passwd.equals("")) {
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[5]")).getText(),"passwd is required.");
					count ++;
					System.out.println(count);
					//xpath: div[@class='columns-container']//li[1]
				}else {
					Assert.assertTrue(false);
				}
				
			//ID Country
				WebElement country = driver.findElement(By.id("id_country"));
				Select dropdownRequired = new Select(country);
				dropdownRequired.selectByIndex(0);
				WebElement option= dropdownRequired.getFirstSelectedOption() ;				
				String selectedValueInDropdown = option.getText();
				
				if(selectedValueInDropdown.equals("-")){
				Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[6]")).getText(),"id_country is required.");
				count ++;
				System.out.println(count);
				}else {
					Assert.assertTrue(false);
				}
				
			//Alias
				if(alias.equals("")) {
					Assert.assertEquals(driver.findElement(By.xpath("//div[@class='columns-container']//li[7]")).getText(),"alias is required.");
					count ++;
					System.out.println(count);
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
				
				System.out.println("there are "+ count +" errors");
	}
}
