package test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;


public class LatestfileDemo {

	 public static void main(String[] args) {
	 
		 String path = "D:\\PDF Reports";

		    File dir = new File(path);
		    File[] files = dir.listFiles();

		    Arrays.sort(files, new Comparator<File>() {
		        public int compare(File f1, File f2) {
		            return Long.valueOf(f2.lastModified()).compareTo(
		                    f1.lastModified());
		        }
		    });

		   for (int index = 0; index < files.length; index++) {
		        // Print out the name of files in the directory
		        System.out.println(files[index].getName());
		    }
		    
		    
		}
		 
	 }
