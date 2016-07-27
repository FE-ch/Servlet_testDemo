package dao;

public class TestJavaSE {
	public static void main(String[] args) {
//		System.out.println(new TestJavaSE().test());
		
		String s1 = "a";
		String s2 = "b";
		System.out.println(s2.equals("ab"));
		String s3 = "a" + "b";
		System.out.println(s3 == "ab");
	}
	
	private int test() {
		int x = 1;
		try {
			return x;
		} finally {
			// TODO: handle finally clause
			++x;
		}
	}
	
	
}
