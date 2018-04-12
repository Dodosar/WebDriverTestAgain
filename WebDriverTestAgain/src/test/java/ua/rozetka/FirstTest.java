package ua.rozetka;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import ua.DB.DataBase;

public class FirstTest extends WebDriverSettings {

	
	@BeforeClass
    public static void createTable(){
        DataBase.connect();
        System.out.println("test Connection");
        DataBase.execute("drop table TopSmartPhones");
        DataBase.execute("create table TopSmartPhones (id int(10) unsigned NOT NULL auto_increment,name varchar(200) NOT NULL,price varchar(20) NOT NULL,PRIMARY KEY (id));");
        DataBase.execute("INSERT INTO emp.TopSmartPhones (name,price) VALUES ('XAOMI','1500')");
        DataBase.execute("INSERT INTO emp.TopSmartPhones (name,price) VALUES ('Meisu','3000')");
        DataBase.close();
    }
	
    @AfterClass
    public static void checkTable(){
        DataBase.connect();
        DataBase.select("select * from TopSmartPhones");
        DataBase.close();
    }
    

	RozetkaSite objRozetka;

	@Test(priority = 0)
	public void MainPage() {
		objRozetka = new RozetkaSite(driver);
		System.out.println("Step 1: Check Title on Main Page");
		objRozetka.mainPage().open().and().CheckTheTitle();
	}

	@Test(priority = 1)
	public void SecondPage() {
		System.out.println("Step 2: Click to link Page of All SmartPhones");
		objRozetka.electronics().clickOnXpath().then().CheckTheTitle();
	}
	
	@Test(priority = 2)
	public void TelephonePage(){
		System.out.println("Step 3: Click to link Page of All Phones");
		objRozetka.phone().clickOnXpath().then().CheckTheTitle();		
	}
	
	@Test(priority = 3)
	public void SmartPhonePage(){
		System.out.println("Step 4: Click to link Page of SmartPhones");
		objRozetka.smartphone().clickOnXpath().then().CheckTheTitle();
	}
	
	@Test(priority = 4)
	public void SelectProductWithStock(){
		System.out.println("Step 4: OnFirstPageSelectProductsWithStock");
		
	}


}
