package testClasses;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Goal:Create multiple leads by importing a CSV file

public class Activity11 {
	WebDriver driver= new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10000);
	Actions actions = new Actions(driver);
    String pressedKeyText;
	
	
 @BeforeClass    // used to opening the URL 
 public void beforeTest() {
	 driver.get("http://alchemy.hguy.co/crm");
	 
 }
 
  @Test (priority = 2)       
  public void multiLeads() throws InterruptedException {
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Log In']")));
//Login to the portal	  
	  WebElement username= driver.findElement(By.xpath("//input[@name='user_name']"));
	  WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
	  username.sendKeys("admin");
	  password.sendKeys("pa$$w0rd");
	  driver.findElement(By.xpath("//input[@title='Log In']")).click();
  }
  
  @Test (priority = 3)       
  public void sales() throws InterruptedException {	  
	
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_0")));
	  WebElement leads = driver.findElement(By.id("grouptab_0"));
	  Thread.sleep(3000);
      actions.moveToElement(leads).moveToElement(driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]"))).click().build().perform();

  }	 
  
  @Test (priority = 4)
	  public void pageImportleads()  {
	  
// Wait until the page is loaded 	 
	 WebElement Leads = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='actionMenuSidebar']/ul/li[3]")));
	 Leads.click();
	 
// Finding and clicking on Import Leads link
	 WebElement importLeads = driver.findElement(By.xpath("//div[@id='actionMenuSidebar']/ul/li[4]"));
	 importLeads.click(); 
  }
  
  
  @Test (priority = 5)
  public void uploadFile() {
	  
//uploading the Leads.csv file from local	  
  File file = new File("C:\\Users\\PRASHANTSHARMA\\Desktop\\IBM\\GBS Reskill\\Project\\Leads.csv");
  WebElement uploadInput = driver.findElement(By.xpath("//input[@id='userfile']"));
  uploadInput.sendKeys(file.getAbsolutePath());
  driver.findElement(By.xpath("//input[@id='gonext']")).click();
  driver.findElement(By.xpath("//input[@id='gonext']")).click();
  driver.findElement(By.xpath("//input[@id='gonext']")).click();
  driver.findElement(By.xpath("//input[@id='importnow']")).click();  
  }
  
  
  @Test (priority = 6)
  public void verifyLeads() {
	  
// go to View leads page
 driver.findElement(By.xpath("//div[@id='actionMenuSidebar']/ul/li[3]")).click();
 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '5e1d6f74ca91')]")));
 WebElement newLead=driver.findElement(By.xpath("//td/b/a[contains(@href, '5e1d6f74ca91')]"));

System.out.println("The new Lead text is: "+  newLead.getText());
Assert.assertEquals(newLead.getText(), "Mr. ratana nooraa");
 
 }
//used to close the browser
  @AfterClass  
 
  public void afterTest() {
 driver.close();
  }

}
