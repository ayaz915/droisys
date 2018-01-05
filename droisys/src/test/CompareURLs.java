/*package test;

import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;

public class CompareURLs {

	private BatchInfo batchInfoBaselines;
	private BatchInfo batchInfoComparison;
	private int numberOfMissMatches;
	private Eyes eyes;
	private int height;
	private int width;

	public int getNumberOfMissMatches() {
		return numberOfMissMatches;
	}

	public CompareURLs(int width, int height, String apiKey) {
		batchInfoBaselines = new BatchInfo("Creating Baseline");
		batchInfoComparison = new BatchInfo("URLs Comparison");

		this.width = width;
		this.height = height;
		
		eyes = new Eyes();

		// This is your api key, make sure you use it in all your tests.
		eyes.setApiKey(apiKey);
	}

	public void setAsBaseline(WebDriver driver) {

		eyes.setBaselineName("Comparison");

		// Makes sure that the 1st URL is saved as baseline
		eyes.setBatch(this.batchInfoBaselines);
		eyes.setSaveFailedTests(true);
		try {
			driver = eyes.open(driver, "app", "prod", new RectangleSize(this.width, this.height));

			// Visual validation point #1
			eyes.checkWindow("prod");

			// End visual testing. Validate visual correctness.
			eyes.close(false);
		} finally {
			eyes.abortIfNotClosed();
		}
	}

	public void compareAgainstBaseline(WebDriver driver) {
		try {

			eyes.setBatch(this.batchInfoComparison);
			eyes.setSaveFailedTests(false);

			driver = eyes.open(driver, "app", "prod", new RectangleSize(this.width, this.height));

			// Visual validation point #1
			eyes.checkWindow("prod");

			// End visual testing. Validate visual correctness.
			TestResults testResults = eyes.close(false);
			this.numberOfMissMatches += testResults.getMismatches();

		} finally {
			eyes.abortIfNotClosed();
		}
	}
}
*/