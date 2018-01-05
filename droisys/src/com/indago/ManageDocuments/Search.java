package com.indago.ManageDocuments;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.indago.util.TestUtil;


public class Search extends TestSuiteBase{
	
	
	String runmodes[]=null;
	static int count=-1;

	
	// Runmode of test case in a suite
	@BeforeTest
	public void checkTestSkip(){
		
		if(!TestUtil.isTestCaseRunnable(suiteManageDocumentsxls,this.getClass().getSimpleName())){
			Log.info("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
			throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
		}
		// load the runmodes off the tests
		runmodes=TestUtil.getDataSetRunmodes(suiteManageDocumentsxls, this.getClass().getSimpleName());
	}
	
	@Test(dataProvider="getTestData")
       public void Search(
			            String testCaseName,
			            String browserType,
			            String Url,
						String userName,
						String passWord,
						String searchData
		
							) throws Exception{
		// test the runmode of current dataset
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			skip=true;
			throw new SkipException("Runmode for test set data set to no "+count);
		}
		
		document = new XWPFDocument();
		String testName=testCaseName;
		fos = new FileOutputStream(new File(System.getProperty("user.dir")+"\\Documented Screenshots\\"+testName+".docx"));
	
		   Log.info("================================ Executing "+testName+"======================================================");
		   Log.info("==================================================================================================================================================");	  
		
//======================================WebDriver Code ================================================================

	/*	  		
	     openBrowser(browserType);
	     navigate(Url);
	     login(userName, passWord);
	     waitForTextToBeDisplayed("btn_manageDocuments_xpath", "Manage Documents");
	     click("btn_manageDocuments_xpath");
	     waitForTextToBeDisplayed("btn_search_xpath", "SEARCH");
	     input("txtbx_search_xpath", searchData);
	     click("btn_search_xpath");
	     fluentWait("txt_searchResultCount_id", 30, 2);
		 closeBrowser();*/
		
//===============================================================================================================================================		
	
	}
	
	@AfterMethod
	public void reportDataSetResult() throws IOException{

		if(skip)
			TestUtil.reportDataSetResult(suiteManageDocumentsxls, this.getClass().getSimpleName(), count+2, "SKIP");
		else if(fail){
			isTestPass=false;
			
			TestUtil.reportDataSetResult(suiteManageDocumentsxls, this.getClass().getSimpleName(), count+2, "FAIL");
		}
		else
			TestUtil.reportDataSetResult(suiteManageDocumentsxls, this.getClass().getSimpleName(), count+2, "PASS");
		if(!skip)
		{
		document.write(fos);
	    fos.flush();
		fos.close();
		}
		skip=false;
		fail=false;	
	}
	@AfterTest
	public void reportTestResult(){
		if(isTestPass)
			TestUtil.reportDataSetResult(suiteManageDocumentsxls, "Test Cases", TestUtil.getRowNum(suiteManageDocumentsxls,this.getClass().getSimpleName()), "PASS");
		else
			TestUtil.reportDataSetResult(suiteManageDocumentsxls, "Test Cases", TestUtil.getRowNum(suiteManageDocumentsxls,this.getClass().getSimpleName()), "FAIL");
	}
	@DataProvider
	public Object[][] getTestData(){
		return TestUtil.getData(suiteManageDocumentsxls, this.getClass().getSimpleName()) ;
	}
}
