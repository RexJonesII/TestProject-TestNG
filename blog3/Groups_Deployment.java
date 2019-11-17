package testproject.blog3;

import org.testng.annotations.Test;

@Test (groups = "deploy")
public class Groups_Deployment
{
	
	public void test1_DeployToDevEnvironment ()
	{
		System.out.println("1. Deploy To Dev Environment");
	}
	
	public void test2_DeployToQA1Environment ()
	{
		System.out.println("2. Deploy To QA1 Environment");
	}
	
	public void test3_DeployToQA2Environment ()
	{
		System.out.println("3. Deploy To QA2 Environment");
	}	
	
	private void test4_DeployToPrivateEnvironment ()
	{
		System.out.println("4. Deploy To Private Environment");
	}
}
