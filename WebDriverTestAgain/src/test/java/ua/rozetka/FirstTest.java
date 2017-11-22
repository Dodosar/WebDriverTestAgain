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
import ua.rozetka.PhTvElectronics;

public class FirstTest {

	private WebDriver driver;
	
	PhTvElectronics objPhTvElectronics;
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		driver.manage().window().maximize();
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

	@Test(priority = 0)
	public void f() {
		driver.get("https://rozetka.com.ua/");		
		String title = driver.getTitle();
		System.out.println(title);
		try {
			Assert.assertTrue(title
					.equals("Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие"));
			System.out.println("Test Pass");
		} catch (Exception e) {
			System.out.println("Test Faild");
		}
	}

	@Test(priority = 1)
	public void GoToLink() {
		objPhTvElectronics = new PhTvElectronics(driver);
		
		objPhTvElectronics.GoToSmartTVElect();
		
		
		/*
		 * String title1 = driver.getTitle(); System.out.println(title1); try{
		 * Assert.assertTrue(title1.equals(
		 * "Телефоны, ТВ и электроника - Rozetka.ua | Купить Телефоны, ТВ и электроника в Киеве: цена, отзывы, продажа"
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

	@AfterTest
	public void Close() {
		// driver.quit();
	}

}
