package test;

public class Hyphanate {

	public static void main(String[] args) {
		
		String str = "5121454544";
		StringBuilder builder = new StringBuilder(str);
		builder.insert(1, '-').insert(4, '-').insert(8, '-');//change here
		String hyphenated = builder.toString();
		System.out.println(hyphenated);

	}

}
