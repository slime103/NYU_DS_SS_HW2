
public class Algorithms {
	
	public static int isReversed(String s1, String s2) {
		
		System.out.println("Is " + s1 + " the same as " + s2 + " reversed?");
		if (s1.length() == s2.length()) {
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			for (int i = 0; i < s1.length()-1;i++) {
				if (!(s1.charAt(i) == s2.charAt(s1.length()-1-i))) {
					System.out.println("no");
					return 0;
				}
			}
			System.out.println("yes");
			return 1;
		}
		System.out.println("no");
		return 0;
	}
}
