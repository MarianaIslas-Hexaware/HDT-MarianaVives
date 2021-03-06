package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		//1. Invoke our Browser
		//Chrome Browser - ChrismeDriver  is a class that have all the methods to run/automate in chrome broswer
		//WebDriver is an interface
		
		// chromedriver.exe -> Chrome browser 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		
		//webdriver.chrome.driver -> value of path
		WebDriver driver = new ChromeDriver ();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		//driver.quit(); --> closes all tabs and multiple associated windows
		
		
		
		
		
		
		
		//Firefox Launch
		//webdriver.gecko.driver (key)
		//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\1000075178\\Documents\\geckodriver.exe");
		//		WebDriver driver = new FirefoxDriver();
		
		
		//Microsoft Edge Launch
				//webdriver.edge.driver (key)
				//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\1000075178\\Documents\\msedgedriver.exe");
				//		WebDriver driver = new EdgeDriver();
		
		
		
		

	}

}
