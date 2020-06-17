package testproject.blog02;

import org.testng.annotations.DataProvider;

public class ProvideData_Default
{
	@DataProvider
	public Object [] [] logInData ()
	{
		Object [] [] data = new Object [3] [2];
		
		data [0] [0] = "SignUpForFree@InvalidEmail.com";		data [0] [1] = "Password_ABC";		
		data [1] [0] = "Rex.Jones@Test4Success.org";				data [1] [1] = "UseMyValidPassword"; 
		data [2] [0] = "InvalidLogIn@Test.com";						data [2] [1] = "InvalidPassword";	
		
		return data;
	}
}
























