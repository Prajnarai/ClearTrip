package Testcases.ClearTrip;

import java.util.Properties;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Hotels {
	Logger log = Logger.getLogger(Hotels.class);
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;
	private Properties prop;
	
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public void location() throws InterruptedException {
		log.debug("Entering location()" );
		driver.findElement(By.xpath("//*[@class='hotelApp ']")).click();
		driver.findElement(By.id("Tags")).click();
		driver.findElement(By.id("Tags")).clear();
		driver.findElement(By.id("Tags")).sendKeys("chic");	
	Thread.sleep(5000L);
		driver.findElement(By.id("Tags")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("Tags")).sendKeys(Keys.ENTER);
		log.debug("Ending location()" );
		log.info("-----Completed location()" );
		
	}
	public void checkIn() throws InterruptedException {
		log.debug("Starting checkin()" );
		driver.findElement(By.id("CheckInDate")).click();
		while (!driver.findElement(By.className("ui-datepicker-month")).getText().equals("March")) {
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@data-handler='next']")).click();			
		}
		int days = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).size();
		log.debug("days in checkIn"+days);
		int i;
		Thread.sleep(2000L);
		for (i = 0; i <= days; i++) {
			String DValue = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(i).getText();
			if (DValue.equals("15")) {
				driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(i).click();
				break;
			}
		}
	}
		public void checkOut() throws InterruptedException {
			driver.findElement(By.id("CheckOutDate")).click();
			while (!driver.findElement(By.className("ui-datepicker-month")).getText().equals("March")) {
				Thread.sleep(2000L);
				driver.findElement(By.xpath("//*[@data-handler='next']")).click();			
			}
			int Cdays = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).size();
			int j;
			Thread.sleep(2000L);
			for (j = 0; j <= Cdays; j++) {
				String DValue = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(j).getText();
				if (DValue.equals("28")) {
					driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(j).click();
					break;
				}
			}
			
		}
		
		public void traveller() {
			Select TCount = new Select(driver.findElement(By.id("travellersOnhome")));
			TCount.selectByValue("2");			
			driver.findElement(By.id("SearchHotelsButton")).click();
	}
}
