package generics;

public class GenerateClassCastException {
	public static void main(String[] args) {
		Object x = 1;
		String s = (String) x;
		
		System.out.println(s);
		
	}
}
