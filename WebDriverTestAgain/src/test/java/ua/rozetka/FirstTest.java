package ua.rozetka;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import ua.rozetka.PhTvElectronics;

public class FirstTest {

	private WebDriver driver;

	PhTvElectronics objPhTvElectronics;
	
	MainPage objMainPage;
	
	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();		
	}

	@BeforeTest
	public void setUp() throws Exception {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://rozetka.com.ua/");	
		
		driver.manage().window().maximize();
	}	

	@Test(priority = 0)
	public void f() {
		System.out.println("Step 1: Check Title on Main Page");
		String title = objMainPage.getTitleManePage();
		try {
			AssertJUnit
					.assertTrue(title
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
		try {
			AssertJUnit.assertTrue(objPhTvElectronics.getTitleFromPage()
					.equals("Test"));
			System.out.println("test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
		}

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
	public void Teardown() {
		if (driver != null){
			driver.quit();
		}
	}	
	

}
