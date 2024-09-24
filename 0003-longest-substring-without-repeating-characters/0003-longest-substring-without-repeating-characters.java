class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;   
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();  

        for (int right = 0; right < arr.length; right++) {
            int idx = map.getOrDefault(arr[right], -1);

            
            if (idx != -1 && idx >= left) {
                left = idx + 1;
            }

            map.put(arr[right], right);

            
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
