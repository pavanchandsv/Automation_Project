package TestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class Login_test {


	ChromeDriver driver;
	
	String url = "https://www.sidemenclothing.com/account/login";
	
	
	
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
	
	
	
	
	@Test(priority=3)
	public void verifyLoginPage() {
		String Title= driver.getTitle();
		String expected = "Account – Sidemen Clothing";
		Assert.assertEquals(Title, expected);
	}
	
	@Test(priority=1)
	public void Login() {
		
		WebElement userId = driver.findElement(By.id("customer_email"));
		
		
		WebElement pass=driver.findElement(By.id("customer_password"));
		//String b="mngr405274";
		
		userId.sendKeys("pavanchandsv@gmail.com");
		pass.sendKeys("Pvrao577@");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[3]/div/input")).click();
	}
	
	@Test(priority=2)
	public void challenge() {
		
		String tit= driver.getTitle();
		Assert.assertEquals("Challenge – Sidemen Clothing", tit);
		if(tit=="Challenge – Sidemen Clothing")
		{
		
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/input[2]")).click();
	
		}
		else
		{
			System.out.println("Robot Detected");
		}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String[] args) {
		openchrome oc=new openchrome();
		oc.invokeBrowser();
		oc.getTitle();
		oc.verifyTitle();
		oc.closeBrowser();
	}*/
	
	
//---------------------------------------------------
/*
 * User ID :	mngr405274
Password :	vEjeqYn
 */
//---------------------------------------------------------

}

