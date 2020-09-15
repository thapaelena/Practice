package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First {
	
	@Test(priority=2, dependsOnMethods= "Register")

	

	public void login() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
//		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("thapa.elina@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("Monkey234");
		driver.findElement(By.id("send2")).click();
		String msg=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
		System.out.println(msg);
		if(msg.equals("Invalid login or password."))
		{
			System.out.println("Test Pass");
		}
			driver.quit();

	}
	
	
	@Test (priority=1) 
	public void Register() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		WebDriverWait wait= new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a")));
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"register\"]/span")).click();
		driver.findElement(By.id("firstname")).sendKeys("Elina");
		driver.findElement(By.id("lastname")).sendKeys("Thapa");
		driver.findElement(By.name("email")).sendKeys("thapa.elina@hotmail.com");
		Select cp=new Select(driver.findElement(By.id("company_type")));
		cp.selectByIndex(3);
//		cp.selectByValue("deployment");
//		cp.selectByVisibleText("Provides deployment, customization and integration services to merchants");
		Select role=new Select(driver.findElement(By.id("individual_role")));
		role.selectByIndex(2);
		Select country=new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("United States");
	}
	
	
		
	}

//refresh package and under test-output you will get reports. 
//emailable-report gives entire report that can be shared to others.
// if priority given then testng will run accoringly default priority is alpabetical order. 
// test cases can be disable into excution in testng
//details about tentng can be found in testng.org

//to create xml
//click testng and choose source tab
// 
//right click on class--navigate testng--convert testng--finish
//to run xml right click-- run as Test Suite
//toadd comment on xml <-->