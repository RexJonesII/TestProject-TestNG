package testproject.blog03;

import org.testng.annotations.Test;

public class Groups_Methods
{
	@Test (groups = "initialize")
	public void test1_LaunchWebServer ()
	{
		System.out.println("1. Launch Web Server");
	}
	
	@Test (groups = "deploy")
	public void test2_DeployToEnvironments ()
	{
		System.out.println("2. Deploy To DEV, QA1, QA2 Environments");
	}
	
	@Test (groups = "unit")
	public void test3_CreateAutomatedMobileTest ()
	{
		System.out.println("3. Create Automated Mobile Test / Group = unit" + "\n");
	}
	
	@Test (groups = { "integration", "regression" } )
	public void test4_CreateAutomatedWebTest ()
	{
		System.out.println("4. Create Automated Web Test / Group = integration, regression" + "\n");
	}
	
	@Test (groups = { "regression", "acceptance" , "bug.fix"} )
	public void test5_ExtendRecordedTest ()
	{
		System.out.println("5. Extend Recorded Test / Group = regression, acceptance, bug.fix" + "\n");
	}
	
	@Test (groups = { "acceptance", "bug.in-progress" } )
	public void test6_CreateTestUsingLibraries ()
	{
		System.out.println("6. Create Test Using Libraries / Group = acceptance, bug.in-progress" + "\n");
	}
	
	@Test 
	public void test7_ExploreAnalytics ()
	{
		System.out.println("7. Explore Analytics / No Group" + "\n");
	}
}
