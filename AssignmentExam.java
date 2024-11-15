package AssignmentExam;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

@Test
public class AssignmentExam {
	public static WebDriver wd;
	public static WebElement we;
	public static String s2;

	public void register() throws InterruptedException {
		
		wd.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		wd.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Shweta");
		wd.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Padwal");
		wd.findElement(By.xpath("//input[@name='phone']")).sendKeys("7776975302");
		wd.findElement(By.xpath("//input[@name='userName']")).sendKeys("shwetapadwal17@gmail.com");
		wd.findElement(By.xpath("//input[@name='address1']")).sendKeys("Nigdi");
		wd.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
		wd.findElement(By.xpath("//input[@name='state']")).sendKeys("Maharashtra");
		wd.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("411044");
		Select sr = new Select(wd.findElement(By.name("country")));
		sr.selectByVisibleText("INDIA");
		wd.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
		wd.findElement(By.xpath("//input[@name='email']")).sendKeys("shwetapadwal17@gmail.com");
		wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Shweta@123");
		wd.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Shweta@123");
		Thread.sleep(2000);

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		wd = new ChromeDriver();
		wd.get("https://demo.guru99.com/test/newtours/index.php");
		wd.manage().window().maximize();
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		String s = wd.getTitle();
		System.out.println("Title is:" + s);
		String s1 = wd.getCurrentUrl();
		System.out.println("Current url:" + s1);
		Thread.sleep(3000);
		we = wd.findElement(By.xpath("//input[@name='firstName']"));
		s2 = we.getAttribute("value");
		System.out.println(s2);
		Thread.sleep(1000);
		we = wd.findElement(By.xpath("//input[@name='lastName']"));
		s2 = we.getAttribute("value");
		System.out.println(s2);
		Thread.sleep(3000);
		wd.close();
	}

}
