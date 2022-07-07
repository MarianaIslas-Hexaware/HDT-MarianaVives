package excercisesHdtTraining;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchProduct {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php\r\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@title='T-shirts']"))).build().perform();
		driver.findElement(By.xpath("//a[@title='T-shirts']")).click();
		a.moveToElement(driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"))).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-container")));
		
		a.moveToElement(driver.findElement(By.cssSelector(".product-container"))).build().perform();
		String text = driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]")).getText();
		System.out.println(text);
		//a.moveToElement(driver.findElement(By.xpath("//a[@title='T-shirts']"))).contextClick().
		a.moveToElement(driver.findElement(By.id("search_query_top"))).build().perform();
		driver.findElement(By.id("search_query_top")).sendKeys(text);	
		driver.findElement(By.cssSelector(".btn.btn-default.button-search")).click();
		
		//Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
		String text2 = driver.findElement(By.xpath("//h5[@itemprop='name']")).getText();
		System.out.println(text2);
		Assert.assertTrue(text.equals(text2));
		driver.close();
		
	}
	
}
