package Testcases.ClearTrip;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	Logger log = Logger.getLogger(Base.class);
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;
	public Properties prop;
	
	
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void loadProperties() throws IOException {
		prop=new Properties();
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\props\\Data.properties");
		prop.load(fis);
	}
	
	public WebDriver initialiseBrowser() throws Exception {
	log.debug("Browser Invokation");
		String browserName=prop.getProperty("browser");
		String url=prop.getProperty("url");
		log.info(browserName);
		log.info(url);
	
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		    driver = new ChromeDriver();
			
		}		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Prajna\\geckodriver.exe");
		    driver = new FirefoxDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "C:\\Prajna\\iexploredriver.exe");
				driver = new InternetExplorerDriver();
				
		}
		else {
			throw new Exception ("Invalid Brower Type");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
}
