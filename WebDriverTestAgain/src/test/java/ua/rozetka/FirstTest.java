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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import ua.rozetka.PhTvElectronicsPage;

public class FirstTest extends WebDriverSettings{

	RozetkaSite objRozetka;	

	@Test(priority = 0)
	public void f(){
		objRozetka = new RozetkaSite(driver);
		objRozetka.mainPage().open();
		System.out.println("Step 1: Check Title on Main Page");
		try {
			AssertJUnit
					.assertTrue(objRozetka
							.mainPage()
							.getTitleManePage()
							.equals(TitleNames.MAINPAGE.toString()));
			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
		}
	}

		@Test(priority = 1)
		public void SecondPage() {
		System.out.println("Step 2: Click to link Page of All SmatPhones");
		objRozetka.electronics().GoToSmartTVElect();
		/*try {
			System.out.println(objRozetka.electronics().getTitleFromPage());
			AssertJUnit.assertTrue(objRozetka.electronics().getTitleFromPage()
					.equals(TitleNames.SMARTPAGE.toString()));
			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
		}*/
	}

}
