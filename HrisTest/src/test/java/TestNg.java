import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.*;

import org.testng.Assert;
import org.testng.annotations.Test;
public class TestNg{
	LoginForm hrs=new LoginForm(); 
	
@Test(priority= 0)
public void testOpenBrowserAndOpenHris() { 
	hrs.OpenBrowserAndOpenHris(); 
	Assert.assertTrue(hrs.URL().contains("hris.qainfotech"));
	}

@Test(priority=1)
public void testLoginWrongPass_LoginWrongUsr() { 
	hrs.Login("wrongusername", "123456789");
	hrs.clearFields(); 
	Assert.assertFalse(hrs.URL().contains("Login.php")); 
	} 

@Test(priority=2) 
public void testBlankUser_Pass(){ 
	hrs.clearFields();
	hrs.Login("",""); 
	Assert.assertFalse(hrs.URL().contains("timesheet")); 
	} 

@Test(priority=3) 
public void testLoginCorrectCredentials(){   
	hrs.Login("rahulgumber", "Rahul@321#");  
	Assert.assertTrue(hrs.URL().contains("timesheet")); 
	hrs.Logout(); 
	} 

}
