package casestudy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testng {
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver hrm;
	@BeforeTest
	public void BT() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		hrm= new ChromeDriver();
		hrm.get(url);
		hrm.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	@Test(priority = 0)
	public void testcase1() throws InterruptedException
	{
		hrm.findElement(By.name("username")).sendKeys("Admin");
		hrm.findElement(By.name("password")).sendKeys("admin123");
		hrm.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
	}
	@Test(priority = 1)
	public void testcase2()
	{
		List<WebElement> link = hrm.findElements(By.tagName("a"));
		System.out.println("The number of links is " + link.size() );
		
	}
	@Test(priority = 2)
	public void testcase3() throws InterruptedException
	{
		Thread.sleep(2000);
		hrm.findElement(By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")).click();
		Thread.sleep(3000);
		
		Actions act = new Actions(hrm);
		WebElement ele=hrm.findElement(By.xpath("//*[@class='oxd-select-text-input']"));
		act.click(ele).build().perform();
		act.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
		act.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
		act.sendKeys(ele,Keys.ENTER).click().build().perform();
		Thread.sleep(3000);
		
		WebElement search_btn =hrm.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
		Thread.sleep(2000);
		act.click(search_btn).build().perform();
		Thread.sleep(2000);
		
		List<WebElement> list =hrm.findElements(By.xpath("//*[@class='oxd-table-card']"));
		System.out.println("The size of the list :"+list.size());
		Thread.sleep(2000);
		hrm.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(1).click();
		Thread.sleep(3000);
		hrm.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(1).click();
		Thread.sleep(3000);
		hrm.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		Thread.sleep(2000);
		
		
	}
	@AfterTest(enabled = true)
	  public void B() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  hrm.quit();
	  }
}
