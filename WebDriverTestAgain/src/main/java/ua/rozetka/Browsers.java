package ua.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public enum Browsers {	
	CHROME {
        public WebDriver create(){
        	System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
            return new ChromeDriver();
        }
    },
    IE {
        public WebDriver create(){
        	System.setProperty("", "");
            return new InternetExplorerDriver();
        }
    },
    SAFARI {
        public WebDriver create(){
        	System.setProperty("", "");
            return new SafariDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
        	System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
            return new FirefoxDriver();
        }
    };
    public WebDriver create(){
        return null;
    }
}
