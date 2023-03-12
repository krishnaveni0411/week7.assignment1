package week7.day4.assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {
public static void main(String[] args) throws InterruptedException  {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("start-Maximized" , "--remote-allow-origins=*" );
	ChromeDriver driver=new ChromeDriver(options);
	driver.get("https://www.nykaa.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
	WebElement brandSearch = driver.findElement(By.xpath("//div[@id='list_topbrands']//following::div[6]/a"));
	Actions builder=new Actions(driver);
	builder.moveToElement(brand).sendKeys(brandSearch,Keys.ENTER).perform();
	Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[@class='sort-name']")).click();
	 driver.findElement(By.xpath("//label[@class='control control-radio']//following::label[3]/div[2]")).click();
	driver.findElement(By.xpath("//div[@id='first-filter']//following::div[@class='filter-action']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Hair']//following::span[@class='side-count']")).click();
	
	driver.findElement(By.xpath("//span[text()='Hair Care']//following::span[@class='side-count'][2]")).click();
	driver.findElement(By.xpath("//label[@class='control control-checkbox']//following::div[@class='control-indicator checkbox ']")).click();
	driver.findElement(By.xpath("//span[text()='Concern']//following::div")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Concern']//following::div/span[text()='Color Protection']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Concern']//following::div/div[@class='css-xrzmfa']")).click();
	String parentWindow = driver.getWindowHandle();
	Set<String> openedWindow = driver.getWindowHandles();
	List<String> childWindow=new ArrayList<String>(openedWindow);
	int size = childWindow.size();
	System.out.println(size);
	driver.switchTo().window(childWindow.get(1));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='180ml']")).click();
	String oldPrice = driver.findElement(By.xpath("//div[@class='css-f5j3vf']//following::span")).getText();
	String price= oldPrice.replaceAll("[^0-9]", "");
	
	System.out.println("price of the product : "+price);
	driver.findElement(By.xpath("//button[@type='button']//following::span[@class='btn-text']")).click();
	driver.findElement(By.xpath("//button[@type='button']")).click();
	
	driver.switchTo().frame(0);
	 String oldGrandTotal = driver.findElement(By.xpath("(//span[text()='Grand Total']/preceding::span)[last()]")).getText();
	 String grandTotal= oldGrandTotal.replaceAll("[^0-9]", "");
	 System.out.println("Grand Total of the product : "+grandTotal);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	driver.findElement(By.xpath("//input[@class='input-element  ']")).sendKeys("600062",Keys.ENTER);
	Thread.sleep(5000);
		
			driver.findElement(By.xpath("(//div/div/div/div/div/input)[4]")).sendKeys("plot no c-16");
		
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@class='inner-wrap']/textarea[@class='input-element input-area ']")).sendKeys("anna street");
	driver.findElement(By.xpath("(//div[@class='form-field']//input[@type='text'])[last()]")).sendKeys("ammu");
	driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("8745129631");
	driver.findElement(By.xpath("(//input[@class='input-element  '])[last()]")).sendKeys("krefud@gmail.com");
	if(price.equals(grandTotal)) {
		System.out.println("There is no delivery charges to this product");
	}else {
	System.out.println("There is a delivery charge to this product");
	}
	Thread.sleep(2000);
	driver.quit();
	
}
}
