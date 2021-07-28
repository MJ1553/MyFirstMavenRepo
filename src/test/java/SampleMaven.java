import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleMaven {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://sqengineer.com/practice-sites/basic-web-elements/");
		
		driver.findElement(By.id("firstName")).sendKeys("Mani");
		driver.findElement(By.name("lname")).sendKeys("Jambabkula");
		driver.findElement(By.id("maleGender")).click();
		driver.findElement(By.className("mail-address")).sendKeys("jambakualmani123@gmail.com");
		driver.findElement(By.linkText("Selenium Tutorials Link")).click();
		
		driver.navigate().back();
		
		//Relative xpath
	    //driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//CSS selector
	    driver.findElement(By.cssSelector("input[value=Submit]")).click();
		
		Thread.sleep(10000);
		//htmlTag[@attributename='attributevalue']
		//htmlTag[@attributename='attributevalue'][@atttributname2='attributeValue']
		//input[@type='text' and @name='lname']
		// (//input[@type='text' and @name='lname'])[2] - using index
		//htmlTag[@attributename='attributevalue']// - to get inside elements directly without traversing (to move forward multiple steps)
		//htmlTag[@attributename='attributevalue']/../.. - back to previous tag (UP)
		//*[text()="Click on the selenium tutorials link : "] - Using exact text
		//*[contains(text(),'Click on the selenium')] - Using Partial text as Contains
		//*[starts-with(@class,'New_Tab_Heading')] - starts with
		//*[ends-with(@class,'New_Tab_Heading')] - ends with
		/*
			 .. to move backward
			/ to move forward one step
			// to more forward multiple steps
		 */
		
		driver.quit();
	}

}
