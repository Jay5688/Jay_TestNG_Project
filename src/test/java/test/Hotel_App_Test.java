package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;

public class Hotel_App_Test {
  @Test
  public void f() {
	  	WebElement uName= driver.findElement(By.id("username"));
		uName.sendKeys("Jayakishore");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.id("login")).click();
		new Select(driver.findElement(By.id("location"))).selectByValue("Melbourne");
		new Select(driver.findElement(By.id("hotels"))).selectByValue("Hotel Sunshine");
		new Select(driver.findElement(By.id("room_type"))).selectByValue("Super Deluxe");
		new Select(driver.findElement(By.id("room_nos"))).selectByValue("2");
	    WebElement checkinDate = driver.findElement(By.id("datepick_in"));
      checkinDate.clear();
      checkinDate.sendKeys("24/12/2022");
		//driver.findElement(By.id("datepick_out")).clear();
      WebElement checkoutDate = driver.findElement(By.id("datepick_out"));
      checkoutDate.clear();
      checkoutDate.sendKeys("27/12/2022");
		new Select(driver.findElement(By.id("adult_room"))).selectByValue("2");
		new Select(driver.findElement(By.id("child_room"))).selectByValue("1");
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.className("login_title"));
		driver.findElement(By.id("first_name")).sendKeys("Jay");
		driver.findElement(By.id("last_name")).sendKeys("Kishore");
		driver.findElement(By.id("address")).sendKeys("Bangalore,Karnataka");
		driver.findElement(By.id("cc_num")).sendKeys("4534567487652345");
		new Select(driver.findElement(By.id("cc_type"))).selectByValue("VISA");
		new Select(driver.findElement(By.id("cc_exp_month"))).selectByValue("6");
		new Select(driver.findElement(By.id("cc_exp_year"))).selectByValue("2022");
		driver.findElement(By.id("cc_cvv")).sendKeys("456");
		driver.findElement(By.id("book_now")).click();
		/*try {
			Thread.sleep(10000);
			}
			catch (Exception e) {
				
			}*/
		//Implicit wait 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Implicit wait PageLoadTimeout() & ScriptTimeout()
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		//Implicit wait ScriptTimeout()
		//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		//Explicit wait
     // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
      //WebElement logout_button =
        //      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout.reg_button")));
             //  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout.reg_button"))
      //wait.until(ExpectedConditions.invisibilityOfElementLocated(null);
		//Fluent Wait
      Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
              .withTimeout(Duration.ofSeconds(30)) //wait for 30 sec max
              .pollingEvery(Duration.ofSeconds(2)) //checks element every 2 sec
              .ignoring(NoSuchElementException.class); //ignore no such element exception if element not found during polling

     WebElement itButton = fluentWait.until(ExpectedConditions.visibilityOfElementLocated
              (By.id("my_itinerary")));
     
       itButton.click();
		//driver.findElement(By.id("my_itinerary")).click();
		driver.findElement(By.name("ids[]")).click();
		driver.findElement(By.name("search_hotel")).click();
		driver.findElement(By.linkText("Booked Itinerary")).click();

	  
	  
	  
	  
  }
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com");
	
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();	
  }

}
