package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class selenium
{
	String driverPath = "C:\\Users\\kotha\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
	
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	@BeforeTest
	void navigate() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kotha\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://topsoftwarecourses.com/");
		Thread.sleep(1000);
	}
	@Test(priority=1)
	void logIn() throws InterruptedException
	{
	
        WebElement ourCourses = driver.findElement(By.xpath("/html/body/nav/ul/div/li[1]/a"));	
    	action.moveToElement(ourCourses).perform();
    	WebElement dataScience = driver.findElement(By.xpath("//a[@href='/Data-science.html']"));
    	dataScience.click();
    	Thread.sleep(1000);
    	driver.navigate().back();
	
   }
	@Test(priority=2)
	void About() throws InterruptedException
	{
		WebElement about = driver.findElement(By.xpath("//a[normalize-space()='About']"));
    	about.click();
    	Thread.sleep(1000);
    	WebElement introVideo = driver.findElement(By.xpath("//div[@class='about-card']//*[name()='svg']"));
    	introVideo.click();
    	Thread.sleep(1000);
    	WebElement icon = driver.findElement(By.xpath("//div[@class='logo']//i[@class='fab fa-slack']"));
    	action.moveToElement(icon).click().perform();
    	Thread.sleep(1000);
	}
	@Test(priority=3)
	void contact()throws InterruptedException
    {
    	WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
    	contact.click();
    	Thread.sleep(1000);
    	WebElement fullName = driver.findElement(By.xpath("//div[@class='testbox']//input[@id='FullName']"));
    	fullName.sendKeys("Rupali Kothale");
    	WebElement email = driver.findElement(By.xpath("//div[@class='testbox']//input[@id='Email']"));
    	email.sendKeys("kothale12@gmail.com");
    	WebElement phoneNo = driver.findElement(By.xpath("//div[@class='testbox']//input[@id='Contact']"));
    	phoneNo.sendKeys("1234567890");
    	WebElement course =driver.findElement(By.xpath("//div[@class='testbox']//input[@id='Course']"));
    	course.sendKeys("Software Testing");
    	WebElement location = driver.findElement(By.xpath("//div[@class='testbox']//input[@id='Location']"));
    	location.sendKeys("Pune");
    	WebElement applyNowButton = driver.findElement(By.xpath("//*[@id=\"myForm\"]/button/span"));
        applyNowButton.click();
    }
	@AfterTest
	void close()
	{
		driver.quit();
	}
}
