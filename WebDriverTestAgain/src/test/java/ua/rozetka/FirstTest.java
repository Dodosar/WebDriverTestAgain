package ua.rozetka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class FirstTest {

	private WebDriver driver;

	@Test(priority = 0)
	public void f() {
		driver.get("https://rozetka.com.ua/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		try {
			Assert.assertTrue(title
					.equals("��������-������� ROZETKA�: �����������, ������������, ������������, ���������� � ������������ �������������"));
			System.out.println("Test Pass");
		} catch (Exception e) {
			System.out.println("Test Faild");
		}
	}

	@Test(priority = 1)
	public void GoToLink() {
		driver.findElement(By
				.xpath("//a[@data-title='���������, �� � �����������']"));
		driver.findElement(
				By.xpath("//a[@data-title='���������, �� � �����������']"))
				.click();
		/*
		 * String title1 = driver.getTitle(); System.out.println(title1); try{
		 * Assert.assertTrue(title1.equals(
		 * "��������, �� � ����������� - Rozetka.ua | ������ ��������, �� � ����������� � �����: ����, ������, �������"
		 * )); System.out.println("Test Pass"); } catch(Exception e){
		 * System.out.println("Test Faild"); }
		 */
	}

	/*
	 * @Test(priority = 2) public void GoToSmarphones(){
	 * driver.findElement(By.xpath(
	 * "//p[contains(concat(' ', @class,' '), ' pab-h3 ')]/a[@href='https://rozetka.com.ua/telefony/c4627900/']"
	 * )).click(); String title = driver.getTitle(); System.out.println(title);
	 * }
	 */

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Browser is Not Correct");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void Close() {
		// driver.quit();
	}

}
