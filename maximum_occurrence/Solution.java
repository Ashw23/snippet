package maximum_occurrence;

import java.util.HashMap;
import java.util.Map;
// find out the word which has maximum occurrence in a String 
public class Solution {
	static String s = "I felt happy happy happy because I saw the others were happy and because I knew I should feel happy, but I wasn’t really happy";
	// Given a list of words find the word with max occurrence

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxOccurance(s));

	}

	static String maxOccurance(String s) {
		String str[] = s.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 0;
		String result = null;
		for (int i = 0; i < str.length; i++) {
			if (!map.isEmpty()) {
				if (map.containsKey(str[i])) {
					map.put(str[i], map.get(str[i]) + 1);
					Integer temp = map.get(str[i]);
					if (temp > count) {
						count = temp;
						
					}
				} else
					map.put(str[i], 1);
			}
			else map.put(str[i], 1);

		}
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			if(count == entry.getValue()){result=entry.getKey();}
		}
		return result;
	}
}
