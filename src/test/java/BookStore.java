import java.sql.DriverManager;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStore {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.demoqa.com/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userName")).sendKeys("LS123");
		driver.findElement(By.id("password")).sendKeys("Lokesh@123");
		driver.findElement(By.xpath("//button[@id='login']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		//driver.findElement(By.xpath("//*[@id='gotoStore' and contains(text(),'Go To Book Store')]")).click();
		driver.navigate().to("https://www.demoqa.com/books");
		driver.findElement(By.id("searchBox")).sendKeys("Git Pocket Guide");
		driver.findElement(By.xpath("//span/a[@href='/books?book=9781449325862']")).click();
		String Profile = driver.findElement(By.xpath("//div[@class='profile-wrapper']")).getText();
		System.out.println("Book value are: "+ Profile);
		
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		driver.findElement(By.id("userName")).sendKeys("LS123");
		driver.findElement(By.id("password")).sendKeys("Lokesh@123");
		driver.findElement(By.xpath("//button[@id='login']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add To Your Collection' and @id='addNewRecordButton']"))).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add To Your Collection' and @id='addNewRecordButton']"))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Alert myalert = driver.switchTo().alert();
    		System.out.println(myalert.getText());
    		myalert.accept();
		}catch(NoAlertPresentException e){
			System.out.println("Alert is not available");
		}
		
		driver.navigate().to("https://www.demoqa.com/profile");
		driver.findElement(By.xpath("//div[@class='action-buttons']/span[@id='delete-record-undefined']")).click();
		Set<String> handles2 = driver.getWindowHandles();
	    System.out.println(handles2);
	    driver.findElement(By.xpath("//*[@id=\"closeSmallModal-ok\"]")).click();
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Alert myalert1 = driver.switchTo().alert();
    		System.out.println(myalert1.getText());
    		myalert1.accept();
		}catch(NoAlertPresentException e){
			System.out.println("Alert is not available");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Alert myalert2 = driver.switchTo().alert();
    		System.out.println(myalert2.getText());
    		myalert2.accept();
		}catch(NoAlertPresentException e){
			System.out.println("Alert is not available");
		}

		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@class='text-right col-md-5 col-sm-12']/button[@id=\"submit\"]")).click();
		String check = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h2")).getText();
		if(check.equals("Welcome,")) {
			System.out.println("Logout is Successfull");
		}else {
			System.out.println("Logout is failed");
		}
		Thread.sleep(10000);
		driver.quit();
	}

}
