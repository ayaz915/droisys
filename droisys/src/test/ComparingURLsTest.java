/*package test;

import java.util.HashMap;
import java.util.Map.Entry;

public class ComparingURLsTest {

	public static void main(String[] args) {
		CompareURLs compareURLS = new CompareURLs();

		HashMap<String, String> urls = new HashMap<String, String>();

		urls.put("https://shop.charter.com/buyflow/buyflow-localization?v=accaf",
				"https://shop.charter.com/buyflow/buyflow-localization?v=DGSAF");

		for (Entry<String, String> pair : urls.entrySet()) {
			compareURLS.compareSites(pair.getKey(), pair.getValue());
		}

		System.out.println("Number of Mismatches:" + compareURLS.getNumberOfMissMatches());
	}

}
*/