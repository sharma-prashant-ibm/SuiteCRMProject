package testClasses;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// Goal: Print the first copyright text in the footer to the console
// Assert has not been used because we dont have to compare anything but only get the text

public class Activity3 {
	WebDriver driver;
	
 @BeforeClass   // used to opening the URL 
 public void beforeTest() {
	 driver= new FirefoxDriver();
	 driver.get("http://alchemy.hguy.co/crm");
 }
 
  @Test(priority = 1)         // used to get the text of the footer
  public void firstFooter() {
	 WebElement first= driver.findElement(By.xpath("//a[contains(.,'© Supercharged by SuiteCRM')]"));
	String text=first.getText();
	System.out.println("The first copyright text in the footer is: " + text);
  }
 
 
  @AfterClass   	 
// used to close the browser
  public void afterTest() throws InterruptedException {
	  driver.close();
  }

}
