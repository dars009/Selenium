package TestNgDemo.TestNgMaven;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Login_TestCase {

	public static WebDriver driver;
	ExtentHtmlReporter htmlReports;
	ExtentReports extent;
	ExtentTest test;
	String fileName = System.getProperty("user.dir") + "/test-output/HtmlTestResults.html";

	@BeforeTest
	public void setUp() {
		System.out.println("Extend Method Method Run");
		htmlReports = new ExtentHtmlReporter(fileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReports);
		htmlReports.config().setReportName("JBK Regression Testing");
		htmlReports.config().setTheme(Theme.STANDARD);
		htmlReports.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReports.config().setDocumentTitle("HtmlReportTestResults");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Java", "8.0");
	}

	@BeforeSuite(groups = "Smoke")
	public static WebDriver setup_Browser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver83.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///E:/AdminLTE/index.html");
		return driver;

	}

	@Test(priority = 1, groups = "Regression")
	public void Verify_Url() {
		test = extent.createTest("TC-1 : Verify_Url ");
		test.log(Status.INFO, "Execution Start : Verify_Url ");
		// Actual url
		String my_url = driver.getCurrentUrl();
		System.out.println("page title is " + my_url);
		// expected url
		String expected_url = "file:///E:/AdminLTE/index.html";
		Assert.assertEquals(my_url, expected_url);
		System.out.println("**************************");
		System.out.println("Test Case One with Thread Id:- " + Thread.currentThread().getId());
	}

	@Test(priority = 2, groups = "Regression")
	public void verifyApplicationTitle() {
		test = extent.createTest("TC-2 : verifyApplicationTitle ");
		test.log(Status.INFO, "Execution Start : verifyApplicationTitle ");
		// Actual title
		String my_title = driver.getTitle();
		System.out.println("page title is " + my_title);
		System.out.println("..................");

		// expected title
		String expected_title = "JavaByKiran | Log in";
		Assert.assertEquals(my_title, expected_title);
		System.out.println("************************");
		System.out.println("Test Case two with Thread Id:- " + Thread.currentThread().getId());
	}

	@Test(priority = 3, groups = "Regression")
	public void verify_Title() {
		test = extent.createTest("TC-3 : verify_Title ");
		test.log(Status.INFO, "Execution Start : verify_Title ");
		String stitle = driver.findElement(By.xpath("/html/body/div/header/a/span[2]/b")).getText();
		String exp = "Java By Kiran";
		Assert.assertEquals(stitle, exp);
		System.out.println("Application title verify " + stitle);
		System.out.println("**********************");
	}

	// start Log In Session
	@Test(priority = 4, groups = "Regression")
	public void loginsesion() {
		test = extent.createTest("TC-4 : loginsesion ");
		test.log(Status.INFO, "Execution Start : loginsesion ");

		driver.findElement(By.xpath("//p[contains(text(),'Sign in to start your session')]"));
		System.out.println("Sign in to start your session");
		System.out.println("***********************");

	}

	@Test(priority = 5, groups = "Regression")
	public void Check_PlaceHolder_Username() {
		test = extent.createTest("TC-5 : Check_PlaceHolder_Username ");
		test.log(Status.INFO, "Execution Start : Check_PlaceHolder_Username ");
		String str = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("placeholder");
		String exp = "Email";
		Assert.assertEquals(str, exp);
		System.out.println("placeholder Email-verified");
		System.out.println("*******************");
	}

	@Test(priority = 6, groups = "Regression")
	public void Check_PlaceHolder_Password() {
		test = extent.createTest("TC-6 : Check_PlaceHolder_Password ");
		test.log(Status.INFO, "Execution Start : Check_PlaceHolder_Password ");
		String str = driver.findElement(By.xpath("//input[@id='password']")).getAttribute("placeholder");
		String exp = "Password";
		Assert.assertEquals(str, exp);
		System.out.println("placeholder password- verified");
		System.out.println("*******************");
	}

	@Test(priority = 7, groups = "Regression")
	public void check_Button_color() {
		test = extent.createTest("TC-7 : check_Button_color ");
		test.log(Status.INFO, "Execution Start : check_Button_color ");
		WebElement signbtn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		System.out.println("befor mouse over button color is" + signbtn.getCssValue("background-color"));
		Actions act = new Actions(driver);
		act.moveToElement(signbtn).build().perform();
		System.out.println("after mouse over button color " + signbtn.getCssValue("color"));
		System.out.println("*******************");

	}

	@Test(priority = 8, groups = "Regression")
	public void check_Links() {
		test = extent.createTest("TC-8 : check_Links ");
		test.log(Status.INFO, "Execution Start : check_Links ");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		System.out.println("............");
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
	}

	@Test(priority = 9, groups = "Regression")
	public void blank_username_password() {
		test = extent.createTest("TC-9 : blank_username_password ");
		test.log(Status.INFO, "Execution Start : blank_username_password ");

		WebElement stract = driver.findElement(By.xpath("//input[@id='email']"));
		stract.sendKeys("");
		String strexp = "sa";
		Assert.assertNotEquals(stract, strexp);
		WebElement passact = driver.findElement(By.xpath("//input[@id='password']"));
		passact.sendKeys("");
		String passexp = "sa";
		driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[3]/div/button")).click();
		Assert.assertNotEquals(passact, passexp);
		String uname = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
		System.out.println(uname);
		String password = driver.findElement(By.xpath("//div[@id='password_error']")).getText();
		System.out.println(password);
		System.out.println("....................................");

	}

	@Test(priority = 10, groups = "Regression")
	public void invalidusername_password() throws InterruptedException {
		test = extent.createTest("TC-10 : invalidusername_password ");
		test.log(Status.INFO, "Execution Start : invalidusername_password ");

		WebElement stract = driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[1]/input"));
		stract.sendKeys("kiran12@gmail.com");
		String strexp = "kiran@gmail.com";
		Assert.assertNotEquals(stract, strexp);
		Thread.sleep(2000);
		stract.clear();
		WebElement passact = driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input"));
		passact.sendKeys("12345");
		Thread.sleep(2000);
		passact.clear();
		String passexp = "123456";
		Assert.assertNotEquals(passact, passexp);
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		System.out.println("Please enter email as kiran@gmail.com");
		System.out.println("Please enter password 123456");
		System.out.println("....................................");

	}

	@Test(priority = 11, groups = "Resgression")
	public void validUsername_Password() throws InterruptedException {
		test = extent.createTest("TC-11 : validUsername_Password ");
		test.log(Status.INFO, "Execution Start : validUsername_Password ");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kiran@gmail.com");
		;

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		;

		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		System.out.println("Online");
		System.out.println("..................................");
	}

	@Test(priority = 12, groups = "Smoke")
	public void Verify_Url_DashBoard() {
		test = extent.createTest("TC-12 : Verify_Url_DashBoard ");
		test.log(Status.INFO, "Execution Start : Verify_Url_DashBoard ");

		// Actual url
		String my_url = driver.getCurrentUrl();
		System.out.println("page title is " + my_url);

		// expected url
		String expected_url = "file:///D:/AdminLTE/pages/examples/dashboard.html";
		Assert.assertEquals(my_url, expected_url);

		System.out.println("**************************");
	}

	@Test(priority = 13, groups = "Smoke")
	public void verifyApplicationTitle_DashBoard() {
		test = extent.createTest("TC-13 : verifyApplicationTitle_DashBoard ");
		test.log(Status.INFO, "Execution Start : verifyApplicationTitle_DashBoard ");

		// Actual title
		String my_title = driver.getTitle();
		System.out.println("page title is " + my_title);
		System.out.println("..................");

		// expected title
		String expected_title = "JavaByKiran | Dashboard";
		Assert.assertEquals(my_title, expected_title);

		System.out.println("************************");
	}

	@Test(priority = 14, groups = "Smoke")
	public void heading_Dashboard() throws InterruptedException {
		test = extent.createTest("TC-14 : heading_Dashboard ");
		test.log(Status.INFO, "Execution Start : heading_Dashboard ");

		String stitle = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		String exp = "Dashboard Courses Offered";
		Assert.assertEquals(stitle, exp);
		System.out.println("Application title verify " + stitle);
		System.out.println("**********************");
		Thread.sleep(2000);
	}

	@Test(priority = 15, groups = "Unit")
	public void click_OnUser() throws InterruptedException {
		test = extent.createTest("TC-15 : click_OnUser ");
		test.log(Status.INFO, "Execution Start : click_OnUser ");

		driver.findElement(By.xpath("//a[@href='users.html']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='label label-danger']")).click();
		// click on 1St dlete button
		@SuppressWarnings("unused")
		Alert alt = driver.switchTo().alert();

		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		/*
		 * //2nd delete option
		 * driver.findElement(By.xpath("///span[@class='label label-danger ss']"
		 * )).click(); Alert alt1=driver.switchTo().alert();
		 * 
		 * System.out.println(driver.switchTo().alert().getText()); Thread.sleep(1000);
		 * driver.switchTo().alert().accept();
		 * 
		 * 
		 * Alert alt2=driver.switchTo().alert(); Thread.sleep(1000);
		 * System.out.println(driver.switchTo().alert().getText());
		 * driver.switchTo().alert().accept();
		 */
	}

	@Test(priority = 16, groups = "Unit")
	public void getTableData() throws InterruptedException {

		test = extent.createTest("TC-16 : getTableData ");
		test.log(Status.INFO, "Execution Start : getTableData ");

		WebElement Table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> tr = Table.findElements(By.tagName("tr"));
		System.out.println("total no of rows " + tr.size());
		for (WebElement row : tr) {
			List<WebElement> td = row.findElements(By.tagName("td"));
			for (WebElement col : td) {
				System.out.print(col.getText() + "  ");
			}
			System.out.println("----------------------------");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 17, groups = "Unit")
	public void Click_On_AddUser_Btn() throws InterruptedException {

		test = extent.createTest("TC-17 : Click_On_AddUser_Btn ");
		test.log(Status.INFO, "Execution Start : Click_On_AddUser_Btn ");

		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 18, groups = "Unit")
	public void Fill_Form() throws InterruptedException {

		test = extent.createTest("TC-18 : Fill_Form ");
		test.log(Status.INFO, "Execution Start : Fill_Form ");

		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		uname.sendKeys("darshit");
		Thread.sleep(2000);
		WebElement mobile = driver.findElement(By.xpath("//input[@id='mobile']"));
		mobile.sendKeys("987654321");
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("darshit@gmail.com");
		Thread.sleep(2000);
		WebElement course = driver.findElement(By.xpath("//*[@id=\"course\"]"));
		course.sendKeys("Java/J2EE");
		WebElement gender = driver.findElement(By.xpath("//input[@id='Male']"));
		gender.click();
		Thread.sleep(2000);

		WebElement we = driver
				.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div[5]/div/select"));
		Select s = new Select(we);
		s.selectByVisibleText("Maharashtra");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("dars");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='submit']")).submit();
		Thread.sleep(2000);

		@SuppressWarnings("unused")
		Alert alt2 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test(priority = 19, groups = "Unit")
	public void clickOn_OperatorBtn() throws InterruptedException {

		test = extent.createTest("TC-19 : clickOn_OperatorBtn ");
		test.log(Status.INFO, "Execution Start : clickOn_OperatorBtn ");

		driver.findElement(By.xpath("//a[@href='operators.html']")).click();
		Thread.sleep(2000);
		// Get Operator table Data

		WebElement Table1 = driver.findElement(By.xpath("//div[@class='box-body table-responsive no-padding']"));
		List<WebElement> tr1 = Table1.findElements(By.tagName("tr"));
		System.out.println("total no of rows " + tr1.size());
		for (WebElement row1 : tr1) {
			List<WebElement> td1 = row1.findElements(By.tagName("td"));
			for (WebElement col1 : td1) {
				System.out.println(col1.getText());
			}
			System.out.println("..........................");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 20, groups = "Unit")
	public void logOutBtn() {
		test = extent.createTest("TC-20 : logOutBtn ");
		test.log(Status.INFO, "Execution Start : logOutBtn ");

		driver.findElement(By.xpath("html/body/div[1]/aside[1]/section/ul/li[5]/a/span")).click();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Logout successfully')]")).getText());
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void tearDown() {
		// to write or update test information to reporter
		extent.flush();
	}

	@AfterSuite(groups = "Smoke")
	public void close_Browse() {
		driver.quit();
	}

}
