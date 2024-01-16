package chromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumScriptChrome {
	WebDriver driver = null;
	
	public void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Browser is Launched");
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Orange HRM url is opened");
		Thread.sleep(3000);
		
	}
	public void login(){
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		System.out.println("User is logined");
		
	}
	public void title() throws InterruptedException{
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		Thread.sleep(2000);
	}
	public void logout() {
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		driver.findElement(By.className("oxd-userdropdown-link")).click();
		System.out.println("User is logout");
	}

	public static void main(String[] args) throws InterruptedException {
		FirstSeleniumScriptChrome obj = new FirstSeleniumScriptChrome();
		obj.launchBrowser();
		obj.login();
		obj.title();
		obj.logout();
//		launchBrowser();
//		login();
//		title();
//		logout();
	}

}
