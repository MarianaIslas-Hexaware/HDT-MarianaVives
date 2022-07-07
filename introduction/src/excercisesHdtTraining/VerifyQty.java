package excercisesHdtTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VerifyQty {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.className("login")).click();
		
		//Variables
		String email = "marianavives123@gmail.com";
		
		//Login
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys("mariana123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		//Move your cursor over Women's link.
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

		//'More' button will be displayed, click on 'More' button.
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//a[normalize-space()='Faded Short Sleeve T-shirts'])[1]"))));
		a.moveToElement(driver.findElement(By.xpath("(//a[normalize-space()='Faded Short Sleeve T-shirts'])[1]"))).build().perform();
		driver.findElement(By.xpath("(//a[normalize-space()='Faded Short Sleeve T-shirts'])[1]")).click();

		//Increase quantity to 2 - Select size 'L' - Select color
		//Size
		WebElement dropdownSize = driver.findElement(By.id("group_1"));
		Select option = new Select (dropdownSize);
		option.selectByValue("2");
		option.getFirstSelectedOption();
		//Color
		driver.findElement(By.id("color_14")).click();
		
		//Click add to Cart Button
		driver.findElement(By.cssSelector("button[name='Submit'] span")).click();
		
		//Proceed to Checkout
		WebDriverWait waitCheckout = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitCheckout.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-ok")));
		String checkoutOk = driver.findElement(By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2")).getText();
		Assert.assertTrue(checkoutOk.equals("Product successfully added to your shopping cart"));
		driver.findElement(By.cssSelector("a[title='Proceed to checkout'] span")).click();
		
		//Complete the buy order process till payment.
		WebDriverWait waitCart = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitCart.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart_title")));
		
		//Verify products are the same as ordered at the beginning
		String prodName2= driver.findElement(By.cssSelector("td[class='cart_description'] p[class='product-name']")).getText();
		System.out.println(prodName2);
		//PENDIENTE revisar prodName- Assert.assertTrue(prodName.equals(prodName2));
		
		//Change Qty
		driver.findElement(By.cssSelector("a[class='cart_quantity_up btn btn-default button-plus'] span")).click();
		String price = driver.findElement(By.cssSelector("td[class='cart_unit'] span[class='price'] span")).getText();
		
		String qty = driver.findElement(By.cssSelector("td[class='cart_quantity text-center']")).getText();
		double x= Double.parseDouble(price);
		System.out.println(price);
		double y= Double.parseDouble(qty);
		System.out.println(qty);
		String total = driver.findElement(By.cssSelector("td[class='cart_total'] span[class='price'] span")).getText();
		int z1= Integer.parseInt(total);
		double z2= x*y;
		System.out.println(z2);
		
		
		

		
		driver.findElement(By.cssSelector("a[class='button btn btn-default standard-checkout button-medium'] span")).click();
		driver.findElement(By.cssSelector("button[name='processAddress'] span")).click();
		
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.cssSelector("button[name='processCarrier'] span")).click();
		
		WebDriverWait waitPayMethod = new WebDriverWait (driver, Duration.ofSeconds(5));
		waitPayMethod.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
		driver.findElement(By.cssSelector("a[title='Pay by bank wire'] span")).click();
		
		WebDriverWait waitPay = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitPay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='page-heading']")));
		driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium'] span")).click();
	
		//Make sure that Product is ordered.
		String confirmation = driver.findElement(By.xpath("//strong[contains(text(),'Your order will be sent as soon as we receive paym')]")).getText();
		Assert.assertTrue(confirmation.equals("Your order will be sent as soon as we receive payment."));
		
		driver.findElement(By.cssSelector("a[class='button-exclusive btn btn-default']")).click();
		driver.close();

	}
	
	static void getPrice(WebDriver driver) {
		
		
	}

}
