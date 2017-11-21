package ua.rozetka;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FirstTest {
	
  private WebDriver driver;
  @Test(priority = 1)
  public void f() {
	  	driver.get("https://rozetka.com.ua/");  
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.equals("»нтернет-магазин ROZETKAЩ: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие"));
			
  }
  
  @Test(priority = 2)
  public void GoToLink(){
	  System.out.println("Will go to link Black Friday");
  }
  
  @BeforeTest
  public void setUp() {
	 		driver = new ChromeDriver();	
	 		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 		/*
			 * 	System.out.println("Welcome to Maven World");
	    		System.setProperty("webdriver.gecko.driver", "D:\\BrowsersDrivers\\geckodriver.exe");
	    		WebDriver driver = new FirefoxDriver();       
	    		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 */
  }

  @AfterTest
  public void Close() {
	  driver.quit();
  }

}
