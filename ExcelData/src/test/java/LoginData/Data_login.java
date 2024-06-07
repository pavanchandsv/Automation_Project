package LoginData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Data_login {

	ChromeDriver driver;
	
	String url = "http://demo.guru99.com/v4";
	
	
	
	@DataProvider(name="guru99data")
	public Object[][] getdata() throws Exception
	{
		String filoc="./src/main/resources/Book.xlsx";
		Get_data gd =new Get_data(filoc);
		Object[][] data = gd.getArray(filoc);
		return data;
		
	}
	
	
	
	@BeforeMethod
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.manage().window();
		driver.get(url);
	
	}
	
	
	
	public void getTitle() {
		String Title= driver.getTitle();
		System.out.println("Title is :"+Title);
	}
	
	
	
	
	
	


	@Test(priority=1,enabled=false)
	public void Login() {
		
		WebElement userId = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		
		
		WebElement pass=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		String b="mngr405274";
		
		userId.sendKeys(b);
		pass.sendKeys("vEjeqYn");
		driver.findElement(By.name("btnLogin")).click();
		
	}
	
	
	
	@Test(priority=1,dataProvider ="guru99data" )
	public void LoginData(String a,String b) {
		
		WebElement userId = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		
		
		WebElement pass=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		
		
		userId.sendKeys(a);
		pass.sendKeys(b);
		driver.findElement(By.name("btnLogin")).click();
		String Title= driver.getTitle();
		String expected = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(Title, expected);
		
		
	}
	
	
	
}

		
	

