package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegexTest {
	
	public WebDriver driver;
	
	@BeforeClass
	 public void beforeClass() {
		  
		  System.setProperty("webdriver.gecko.driver", "\"C:\\Users\\Swapn\\OneDrive\\Desktop\\chromedriver.exe\"");
		  driver = new ChromeDriver();
		  
		  }
	
@Test(dataProvider = "credentials")
public void Verifycredentials(String scenario,String Name,String Phone,String date,String GID,String GiDNO,String address,String state,String testtype,String dateofvisit) {
	driver.get("http://localhost/Covid19-TMS%20Project%20Using%20PHP%20and%20MySQL/covid-tms/new-user-testing.php");
	
	driver.findElement(By.id("fullname")).sendKeys("Swapnil Take");
    // Send phone to text field
driver.findElement(By.id("mobilenumber")).sendKeys("8600787879");
   //  dob
driver.findElement(By.id("dob")).sendKeys("09-04-2000");
//  Govt Issued ID
driver.findElement(By.id("govtissuedid")).sendKeys("Adhar");
// ID Number
driver.findElement(By.id("govtidnumber")).sendKeys("979325686414");
//address
driver.findElement(By.id("address")).sendKeys("Newasa");
//State
driver.findElement(By.id("state")).sendKeys("Maharashtra");

driver.findElement(By.id("testtype")).sendKeys("RT-PCR");

driver.findElement(By.id("birthdaytime")).sendKeys("22-12-2022 13:20");

driver.findElement(By.xpath("/html/body/div/div/div/div/form/div/div[2]/div/div[2]/div[3]/input")).click();

if (scenario.equals("CorrectFormate")) {
	System.out.println("Sign Up Complete succesfully --  Test Complete");
	
}
else {
	System.out.println("Sign Up Fail Please re-enter your details -- Test Fail");
}

}
@DataProvider(name = "credentials")
public Object[][] getData() {
	return new Object[][] {
		{"CorrectFormate","Swapnil Rajendra Take","8600789879","20-10-2000","Adhar","979325686414","Newasa tal-Newasa dist-Ahmednagar","Maharashtra","RT-PCR","22-12-2022 13:20"},
		{"WrongFormate","Swapnil Take","8600789879","20-10-2000","Adhar","979325686414","Newasa tal-Newasa dist-Ahmednagar","Maharashtra","RT-PCR","22-12-2022 13:20"},
		{"WrongFormate","Swapnil","8600789879","20-10-2000","Adhar","979325686414","Newasa tal-Newasa dist-Ahmednagar","Maharashtra","RT-PCR","22-12-2022 13:20"}
	    
	};
}
@AfterClass
public void afterClass() {
driver.quit();
}
}
