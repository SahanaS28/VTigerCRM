package practice.datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import javax.tools.FileObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Organization {

	public static void main(String[] args) throws IOException {
		File fb= new File("C:\\\\\\\\Users\\\\\\\\DELL\\\\\\\\Desktop\\\\\\\\CommonData.properties");
		FileInputStream fis= new FileInputStream(fb);
		Properties pro= new Properties();
		pro.load(fis);
		String BROWSER=pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		/*
		 * Scanner sc= new Scanner(System.in); System.out.println("Enter the Browser");
		 * String browser=sc.next();
		 */
		WebDriver driver= null;
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		
		//WebDriver driver=new EdgeDriver();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
		
	}

}
