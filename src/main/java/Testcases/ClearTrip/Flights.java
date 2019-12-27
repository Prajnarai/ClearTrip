package Testcases.ClearTrip;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class Flights {

	Logger log = Logger.getLogger(Flights.class);
	private WebDriver driver;
	private Properties prop;

	public Properties getProp() {
		return prop;
	}


	public void setProp(Properties prop) {
		this.prop = prop;
	}


	public Flights(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	
	public void flightBook() throws InterruptedException {

		driver.findElement(By.id("RoundTrip")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// From Location
		driver.findElement(By.id("FromTag")).sendKeys("Chi");
		Thread.sleep(5000L);
		driver.findElement(By.id("FromTag")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("FromTag")).sendKeys(Keys.ENTER);
		log.info("From Location Entered");

		// To location
		driver.findElement(By.id("ToTag")).sendKeys("ban");
		Thread.sleep(5000L);
		driver.findElement(By.id("ToTag")).sendKeys(Keys.ENTER);
		log.info("To Location Entered");
	}

	public void calendar() throws InterruptedException {
		// Selecting From date
		Thread.sleep(5000L);
		log.info("Selecting from date");
		driver.findElement(By.id("DepartDate")).click();
		while (!driver.findElement(By.className("ui-datepicker-month")).getText().equals("February")) {
			Thread.sleep(3000L);
			driver.findElement(By.xpath("//*[@class='nextMonth ']")).click();

		}

		int datecount = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).size();
		
		int i;
		for (i = 0; i <= datecount; i++) {
			String dateValue = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(i).getText();

			if (dateValue.equalsIgnoreCase("4")) {
				driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(i).click();
				break;

			}
		}
		
		log.info("Selecting return date");
		Thread.sleep(5000L);
		driver.findElement(By.id("ReturnDate")).click();
		while (!driver.findElement(By.className("ui-datepicker-month")).getText().equals("February")) {
			Thread.sleep(5000L);
			driver.findElement(By.xpath("//*[@class='nextMonth ']")).click();
		}
		int returndate = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).size();
		
		int j;

		for (j = 0; j <= returndate; j++) {

			String dValue = driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(j).getText();
			
			if (dValue.equalsIgnoreCase("14")) {
				driver.findElements(By.xpath("//*[@data-handler='selectDay']")).get(j).click();
				break;

			}
		}
	}

	public void selectFlights() throws InterruptedException {
		log.debug("SelectFlights() started");
		Select S = new Select(driver.findElement(By.id("Adults")));
		S.selectByValue("2");
		
		driver.findElement(By.id("MoreOptionsLink")).click();
		log.info("More Options Link clicked");
		Select travel = new Select(driver.findElement(By.id("Class")));
		travel.selectByValue("Economy");
		log.info("Selected Economy class");
		WebElement name = driver.findElement(By.id("AirlineAutocomplete"));
		name.sendKeys("Ame");
		Thread.sleep(2000L);
		name.sendKeys(Keys.ENTER);
		log.info("Selected American Airlines");
		driver.findElement(By.xpath("//*[@title='Search flights']")).click();
	}

}
