package allCommons;

public class Find_All_Commons {
	/**
	 * I/p: {Apple, April, Ape} O/P: AP
	 * 
	 * @author Ashwini
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] st = { "Cat", "Catch", "Cater" };
		String str[] = new String[st.length - 1];
		;
		for (int i = 0; i < st.length - 1; i++) {
			System.out.println("testing");
			str[i] = commonPrefix(st[i], st[i + 1]);
		}
		StringBuffer result = new StringBuffer(str[0]);
		for (int i = 0; i < str.length ; i++) {
			if (str[i].length() > result.length())
				result = new StringBuffer(str[i]);
			System.out.println("result in loop: "+result);
		}
		System.out.println("result: "+result);
	}

	public static String commonPrefix(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		if (s1.length() > s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				for (int j = i; j < s2.length(); j++) {
					if (s1.charAt(i) == s2.charAt(j)) {
						sb.append(s1.charAt(i));
					}
				}

			}
		} else {
			for (int i = 0; i < s2.length(); i++) {
				for (int j = i; j < s1.length(); j++) {
					if (s2.charAt(i) == s1.charAt(j))
						sb.append(s2.charAt(i));

				}

			}
		}
		return sb.toString();
	}
}
