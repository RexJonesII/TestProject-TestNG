package testproject.blog03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnGroups 
{
	@Test (groups = "initialize")
	public void launchWebServer ()
	{
		System.out.println("Launch Web Server");
	}
	
	@Test (dependsOnGroups = "initialize", groups = "deploy")
	public void deployQA1Environment ()
	{
		Assert.assertFalse(true);
		System.out.println("Deploy To QA1 Environment");
	}
	
	@Test (dependsOnGroups = "deploy")
	public void test1 ()
	{
		System.out.println("1st Test");
	}
	
	@Test (dependsOnGroups = "deploy")
	public void test2 ()
	{
		System.out.println("2nd Test");
	}
	
	@Test (dependsOnGroups = "deploy")
	public void test3 ()
	{
		System.out.println("3rd Test");
	}
}

