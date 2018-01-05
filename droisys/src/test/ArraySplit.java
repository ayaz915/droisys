package test;

public class ArraySplit{
	   public static void main(String args[]){
	      
		   String phone = "https://shop.business.spectrum.com/content/localization?v=SBDM";
			String[] output = phone.split("=");
			System.out.println(output[0]);
			System.out.println(output[1]);
	   }
	}