package excercisesHdtTraining;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddWishlist {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();
		
		//Click on sub menu 'T-shirts'.
		a.moveToElement(driver.findElement(By.xpath("//a[@title='T-shirts']"))).build().perform();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='T-shirts']")));
		
		driver.findElement(By.xpath("//a[@title='T-shirts']")).click();
		String prodName = driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']")).getText();
		System.out.println(prodName);
		a.moveToElement(driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"))).build().perform();
		
		//Mouse hover on the second product displayed.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-container")));
		a.moveToElement(driver.findElement(By.cssSelector(".product-container"))).build().perform();

		//Add to wishlist
		driver.findElement(By.cssSelector(".addToWishlist.wishlistProd_1")).click();
		WebDriverWait waitError = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitError.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fancybox-error")));

		String errorMsj = driver.findElement(By.cssSelector(".fancybox-error")).getText();
		Assert.assertTrue(errorMsj.equals("You must be logged in to manage your wishlist."));
		driver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).click();
		
		//Log in to add to Wishlist after log in
		String email = "marianavives123@gmail.com";
		a.moveToElement(driver.findElement(By.cssSelector(".login")));
		driver.findElement(By.cssSelector(".login")).click();;
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys("mariana123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		//Add Wishlist
		Actions act = new Actions(driver);
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Women']")));
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();
		
		//Click on sub menu 'T-shirts'.
		act.moveToElement(driver.findElement(By.xpath("//a[@title='T-shirts']"))).build().perform();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='T-shirts']")));
		
		driver.findElement(By.xpath("//a[@title='T-shirts']")).click();
		driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']")).getText();
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"))).build().perform();
		
		//Mouse hover on the second product displayed.
		WebDriverWait waitPd = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitPd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-container")));
		act.moveToElement(driver.findElement(By.cssSelector(".product-container"))).build().perform();

		//Add to wishlist
		driver.findElement(By.cssSelector(".addToWishlist.wishlistProd_1")).click();
		WebDriverWait waitSuccess = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitSuccess.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fancybox-error")));

		String wishlistMsj= driver.findElement(By.cssSelector(".fancybox-error")).getText();
		Assert.assertTrue(wishlistMsj.equals("Added to your wishlist."));
		driver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).click();
		driver.close();
		
	}

}
