package testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\hp\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tendable.com/");

		WebElement ourStory = driver.findElement(By.xpath("//a[text() = 'Our Story']"));
		ourStory.click();
		Thread.sleep(2000);
		verifyRequestADemo(driver);

		WebElement ourSolution = driver.findElement(By.xpath("//a[text() = 'Our Solution']"));
		ourSolution.click();
		Thread.sleep(2000);
		verifyRequestADemo(driver);

		WebElement whyTendable = driver.findElement(By.xpath("//a[text() = 'Why Tendable?']"));
		whyTendable.click();
		Thread.sleep(2000);
		verifyRequestADemo(driver);

		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		contactUs.click();

		WebElement marketing = driver.findElement(By.xpath("(//button[text()='Contact'])[1]"));
		marketing.click();

		WebElement fullName = driver.findElement(By.xpath("(//input[@placeholder='Full Name'])[1]"));
		fullName.sendKeys("Lisa Patterson");

		WebElement organisationName = driver.findElement(By.xpath("(//input[@placeholder='Organisation Name '])[1]"));
		organisationName.sendKeys("Tendable");

		WebElement phoneNumber = driver.findElement(By.xpath("(//input[@placeholder='Phone Number'])[1]"));
		phoneNumber.sendKeys("1028384889");

		WebElement email = driver.findElement(By.xpath("(//input[@placeholder='Email'])[1]"));
		email.sendKeys("lisapatterson@tendable.com");

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,300)");

		WebElement jobRole = driver.findElement(By.xpath("(//select[@name='jobRole'])[1]"));
		Select s = new Select(jobRole);
		s.selectByIndex(3);

		WebElement iAgree = driver.findElement(By.xpath("(//input[@name='consentAgreed'])[1]"));
		iAgree.click();

		JavascriptExecutor jr = ((JavascriptExecutor) driver);
		jr.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);

		WebElement submit = driver.findElement(By.xpath("(//button[text()='Submit'])[1]"));
		submit.click();

		JavascriptExecutor jh = ((JavascriptExecutor) driver);
		jh.executeScript("window.scrollBy(0,-200)");

		WebElement error = driver.findElement(
				By.xpath("//p[text()='Sorry, there was an error submitting the form. Please try again.']"));
		String eText = error.getText();

		if (eText.contains("Sorry, there was an error submitting the form. Please try again.")) {
			System.out.println("Error message is displayed and mark the test as PASS.");
		} else {
			System.out.println("Error message is not displayed and and mark the test as Fail");
		}

	}

	public static void verifyRequestADemo(WebDriver driver) {
		WebElement requestADemo = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
		if (requestADemo.isDisplayed()) {
			requestADemo.click();
			System.out.println("requestADemo is present and clicked");
		}
	}

}
