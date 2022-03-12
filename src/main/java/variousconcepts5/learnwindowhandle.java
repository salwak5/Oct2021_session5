
	
	package variousconcepts5;

	import java.util.Set;
import java.util.concurrent.TimeUnit;

	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class learnwindowhandle {
		
		WebDriver driver;
		@Before
		public void init() {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.get("https://www.cnn.com/?refresh=1");
			//driver.get("https://techfios.com/billing/?ng=dashboard/");
			//driver.get("https://techfios.com/billing/?ng=contacts/companies/");
			driver.get("https://www.yahoo.com/?guccounter=1");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
		}
		@Test
		public void windowhandle1() throws InterruptedException {
			System.out.println(driver.getTitle());
			//String handle1= driver.getWindowHandle();
			//System.out.println(handle1);
			
			driver.findElement(By.id("ybar-sbq")).sendKeys("xpath");
			driver.findElement(By.id("ybar-search")).click();
			Thread.sleep(3000);
		//	System.out.println(driver.getTitle());
			String handle2= driver.getWindowHandle();
			System.out.println(handle2);
			
			driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
			//driver.findElement(By.xpath("//*[@id=\"topnav\"]/div/div[1]/a[4]")).click();
			Set<String> handle3= driver.getWindowHandles();
			System.out.println(handle3);
			for(String i:handle3) {
				System.out.println(i);
				driver.switchTo().window(i);
			}
			
			System.out.println(driver.getTitle());
			driver.switchTo().window(handle2);
		}
	}



