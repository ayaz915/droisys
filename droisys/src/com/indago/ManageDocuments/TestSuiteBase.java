package com.indago.ManageDocuments;
import java.lang.reflect.Method;

import org.testng.ITest;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.indago.base.TestBase;
import com.indago.util.TestParameters;
import com.indago.util.TestUtil;

public class TestSuiteBase extends TestBase implements ITest {
    private String mTestCaseName;
	// check if the suite ex has to be skiped
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{
		initialize();
		Log.info("Checking Runmode of HomePage suite");
		if(!TestUtil.isSuiteRunnable(suiteXls, "ManageDocuments suite")){
			Log.info("Skipped ManageDocuments suite as the runmode was set to NO");
			throw new SkipException("Runmode of ManageDocuments suite set to no. So Skipping all tests in ManageDocuments suite");
		}
		
	}
	@BeforeMethod(alwaysRun = true)
    public void testData(Method method, Object[] testData) {
        String testCase = "";
        if (testData != null && testData.length > 0) {
            TestParameters testParams = null;
            String _dyna_name = null;
            //Check if test method has actually received required parameters
            for (Object testParameter : testData) {
                if (testParameter instanceof TestParameters) {
                    testParams = (TestParameters) testParameter;
                    break;
                }
                if (testParameter instanceof String) {
                    _dyna_name = (String) testParameter;
                    break;
                }
            }
            if (testParams != null) {
                testCase = testParams.getTestName();
            }
            if(_dyna_name!=null){
                testCase = _dyna_name;
            }
        }
        this.mTestCaseName = String.format("%s (%s)",method.getName(),testCase);
    }
	@Override
    public String getTestName() {
        return this.mTestCaseName;
    }
}
