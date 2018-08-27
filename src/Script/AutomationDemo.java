package radhika;

import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\eclipse\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();	
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        Thread.sleep(5000);
        driver.get("http://www.gmail.com");
        Thread.sleep(2000);
        driver.close();  
       
	}

}
