import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
        	return s.length();
        int max = 0;
        HashMap<Character,Character> hashmap = new HashMap<Character,Character>();
        for (int i = 0; i < s.length(); i ++) {
        	int m = 1;
        	hashmap.put(s.charAt(i), s.charAt(i));
        	for (int l = i + 1; l < s.length(); l ++) {
        		if (hashmap.containsKey(s.charAt(l))) {
        			break;
        		}
        		hashmap.put(s.charAt(l), s.charAt(l));
        		m ++;
        	}
        	if (m > max)
        		max = m;
        	hashmap.clear();
        }
        return max;
    }
}