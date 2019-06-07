
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestNGSeleniumPractice  {
	public static WebDriver driver;
	String baseUrl = "http://demo.guru99.com/test/login.html";
	public static ExtentReports extent;
	public static ExtentTest test;
	 
/*	@BeforeSuite
	public void beforeSuite() {
		extent = new ExtentReports("C:\\Users\\580289\\eclipse-workspace\\TestNG\\ExtentReports\\MyExtentReport.html", true);
		extent.loadConfig(new File("C:\\Users\\580289\\eclipse-workspace\\TestNG\\extent-config.xml"));	 
		
 }
  */
	
  @BeforeMethod
  public void beforeMethod(Method method) {
	  //test = extent.startTest("TestNGSeleniumPractice");
	  //test = extent.startTest((this.getClass().getSimpleName()+" :: ")+method.getName(), method.getName());
	 // test.assignAuthor("Chinni Krishna");
	  //test.assignCategory("Sample Test");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\580289\\Desktop\\sel2\\chromedriver_win32_2.42\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 // test.log(LogStatus.PASS, "Browser launched successfully");
  }
  
  //1 - Find Elements
  @Test(priority=0, enabled=true)
  public void findElements() {
	  
	  driver.get("http://demo.guru99.com/test/ajax.html");
	  List <WebElement> elements = driver.findElements(By.name("name"));
	  System.out.println("No.of elements = "+elements.size());
	  
	  for(int i=0;i<elements.size();i++ ) {
		  System.out.println("Radio button text: "+ elements.get(i).getAttribute("alue"));
		  System.out.println();
	  	}
  }

  //2 - Submit Form
  @Test(priority=1, enabled=true)
  public void submitForm() {
	  driver.get(baseUrl);
	  WebElement email = driver.findElement(By.id("email"));
	  WebElement password = driver.findElement(By.id("passwd"));
	  WebElement button = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
	  
	  //enter values for email and password
	  email.sendKeys("abc@gmail.com");
	  password.sendKeys("passwd");
	  
	  //clear email and password
	  email.clear();
	  password.clear();
	  
	  //enter email and password and login
	  email.sendKeys("abc@gmail.com");
	  password.sendKeys("abcdefghlkjl");
	  button.submit();
	  System.out.println("Login Successful");	  
  }
  
  //3 - Radio button & Check-box, isSelected	  	  
  @Test(priority=2, enabled=false)
  public void raddioButtonCheckBox() {

	  driver.get("http://demo.guru99.com/test/radio.html");		  
	  WebElement rdbt1 = driver.findElement(By.id("vfb-7-1"));
	  WebElement rdbt2 = driver.findElement(By.id("vfb-7-2"));
	  WebElement rdbt3 = driver.findElement(By.id("vfb-7-3"));	  
	  WebElement chbx1 = driver.findElement(By.id("vfb-6-0"));
	  WebElement chbx2 = driver.findElement(By.id("vfb-6-1"));
	  WebElement chbx3 = driver.findElement(By.id("vfb-6-2"));	  
	  rdbt1.click();
	  rdbt2.click();
	  rdbt3.click();
	  
	  if(rdbt3.isSelected()) {
		  System.out.println("Radio Button 3 selected");
	  }	  
	  chbx1.click();
	  chbx2.click();
	  chbx3.click();
	  
	  if(chbx2.isSelected()) {
		  chbx2.click();
		  System.out.println("Check-box 2 is not selected");
	  }
	  
	//4 - Accessing image links
	  driver.get("https://www.tcs.com/consulting");	
	  WebElement img = driver.findElement(By.xpath("//*[@id=\"nav-local\"]/div/a[1]/div[1]/picture/img"));
	  img.click();
	  if(driver.getTitle().equalsIgnoreCase("Tata Consultancy Services | Technology, Digital Solutions, Consulting")) {
		  System.out.println("Ww clicked on image and landed on home page");
	  }
  }
  
  //5 - Handling Drop-Down Box
  @Test(priority=3, invocationCount=1,enabled=false)
  public void singleDropDown() {
	  //SELECT SINGLE ITEM FROM DROPDOWN
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		Select dropCountry = new Select(driver.findElement(By.name("country")));
		dropCountry.selectByVisibleText("ANTARCTICA");
		dropCountry.selectByIndex(2);
		dropCountry.selectByValue("AUSTRIA");
		dropCountry.deselectByIndex(3);
  	}

  // 6 - SELECT MULTIPLE ITEMS FROM DROPDOWN
  @Test(priority=4, invocationCount=1,enabled=false)
  public void miltiDropDown() {
		driver.get("http://jsbin.com/osebed/2");
		Select mulDrp = new Select(driver.findElement(By.id("fruits")));
		if(mulDrp.isMultiple()) {
			mulDrp.selectByIndex(2);
			mulDrp.selectByVisibleText("Grape");
			mulDrp.selectByValue("Orange");
			mulDrp.deselectAll();
			System.out.println();
		}				
  }

  // 7 - LINK TEXT 
	@Test(priority=5, invocationCount=1,enabled=false)
	public void linkText() {
		driver.get("http://demo.guru99.com/test/link.html");
		driver.findElement(By.linkText("click here")).click();	
}
	// 8 - PARTIAL LINK TEXT
	@Test(priority=6, invocationCount=2,enabled=false)
	public void partialLinkText() {
		driver.get("http://demo.guru99.com/test/accessing-link.html");
		driver.findElement(By.partialLinkText("go")).click();	
	}
  
	// 8 - MOUSE EVENTS
	 @Test(priority=6, groups="mouse", enabled=false)
	  public void mouseEvents() {
		Actions action = new Actions(driver);
		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement link_Home = driver.findElement(By.linkText("Home"));
		Action mouseoverhome = action.moveToElement(link_Home).build();
		mouseoverhome.perform();					
	  }
		
	@Test(priority=7, groups="mouse", enabled=false)
	public void mouseDragAndDropPage() {
			Actions action = new Actions(driver);
			driver.get("http://demo.guru99.com/test/drag_drop.html");
			WebElement from = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
			WebElement to = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
			Action dragAndDrop = action.dragAndDrop(from, to).build();
			dragAndDrop.perform();
	  }
	
	// 9 - UPLOAD A FILE
	@Test(priority=8, enabled=false)
	  public void uploadFile() {
		driver.get("http://demo.guru99.com/test/upload/");
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\580289\\Desktop\\HelpFile.rtf");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.name("send")).click();	  
	  }
	
	// 10 -  ALERTS
	@Test(priority=9, groups="windowhandle", enabled=false, description="This is alert method execution !")
	  public void alerts() {
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("1234");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Message: "+ alert.getText());
		alert.accept();
		System.out.println("Alert Message: "+ alert.getText());
		alert.accept();
		  
	  }
	 // 11 - POP-UPS OR WINDOW HANDLES 
	@Test(priority=10, enabled=true, groups="windowhandle")
	  public void popUps() {
		driver.get("http://demo.guru99.com/popup.php");
		driver.findElement(By.linkText("Click Here")).click();		
		
		String mainWIndow = driver.getWindowHandle();
		Set <String> windows = 	driver.getWindowHandles();
		Iterator <String> iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			if(!mainWIndow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				driver.close();
			}			
		}
		driver.switchTo().window(mainWIndow);
	  }
	
	//12 - WEB TABLES
	@Test(priority=11, enabled=false, groups="WebTables", description="This methos is define to practve statuc web tables")
	  public void webTables() {
		driver.get("http://demo.guru99.com/test/write-xpath-table.html");
		String td = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[2]/td[1]")).getText() ;
		System.out.println("Table 2 - 1 value is : "+td);		  
	  }
	
	//13 - DYNAMIC WEB TABLES 
	 @Test(priority=12, enabled = false, groups="WebTables")
	  public void dynamicWebTables() {
		 driver.get("http://demo.guru99.com/test/web-table-element.php");
		 List <WebElement> col = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th[1]"));
		 System.out.println("No.of columns are: "+ col.size());
		 
		 List <WebElement> row = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		 System.out.println("No.of columns are: "+ row.size()); 		  
	  }	 
	 
/*
  @Test(priority=)
  public void () {
	  
  }
*/  
	 
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
	 // test.log(LogStatus.PASS, "Browser closed successfully");
	  //extent.endTest(test);
  }
  
/*  @AfterSuite
  public void afterSuite() {
	 extent.flush();
	 extent.close();
  }*/

}

