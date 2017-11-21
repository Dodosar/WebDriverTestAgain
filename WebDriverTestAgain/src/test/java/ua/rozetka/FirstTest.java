package ua.rozetka;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class FirstTest {
	
  private WebDriver driver;
  
  @Test(priority = 0)
  public void f() {
	  	driver.get("https://rozetka.com.ua/");  
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.equals("��������-������� ROZETKA�: �����������, ������������, ������������, ���������� � ������������ �������������"));
			
  }
  
  @Test(priority = 1)
  public void GoToLink(){
	  driver.findElement(By.xpath("//a[@data-title='���������, �� � �����������']")).click();
	  String title1 = driver.getTitle();
	  System.out.println(title1);
	  Assert.assertTrue(title1.equals("��������, �� � ����������� - Rozetka.ua | ������ ��������, �� � ����������� � �����: ����, ������, �������"));
  }
  
  @Test(priority = 2)
  public void GoToSmarphones(){
	  driver.findElement(By.xpath("//p[contains(concat(' ', @class,' '), ' pab-h3 ')]/a[@href='https://rozetka.com.ua/telefony/c4627900/']")).click();
	  String title = driver.getTitle();
  }
  
  @BeforeTest
  public void setUp() {
	 		driver = new ChromeDriver();	
	 		driver.manage().window().maximize();
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
