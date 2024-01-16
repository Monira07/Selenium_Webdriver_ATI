package chromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumScriptIDE {
	WebDriver driver = null;
	
	public void launchBrowser() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println("Browser is Launched");
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Orange HRM url is opened");
		Thread.sleep(2000);
		
	}
	public void login(String loginusernmae, String loginpassword){
		driver.findElement(By.name("username")).sendKeys(loginusernmae);
		
		driver.findElement(By.name("password")).sendKeys(loginpassword);
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
		FirstSeleniumScriptIDE obj = new FirstSeleniumScriptIDE();
		obj.launchBrowser();
		obj.login("Admin","admin123");
		obj.title();
		obj.logout();
//		launchBrowser();
//		login();
//		title();
//		logout();
	}

}
