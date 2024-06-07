package TestLogin;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class guru99_login {
ChromeDriver driver;
	
	String url = "http://demo.guru99.com/v4";
	
	
	
	@DataProvider(name="guru99data")
	public Object[][] getdata()
	{
		Object[][] data = null;
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	@BeforeSuite
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pavan\\Downloads\\drive\\chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	
	}
	
	
	
	public void getTitle() {
		String Title= driver.getTitle();
		System.out.println("Title is :"+Title);
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	
	
	
	@Test(priority=2)
	public void verifyTitle() {
		String Title= driver.getTitle();
		String expected = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(Title, expected);
	}
	
	@Test(priority=1)
	public void Login() {
		
		WebElement userId = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		
		
		WebElement pass=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		String b="mngr405274";
		
		userId.sendKeys(b);
		pass.sendKeys("vEjeqYn");
		driver.findElement(By.name("btnLogin")).click();
	}
	
	
	
	
	
}
