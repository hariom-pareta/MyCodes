	class Solution {
	    public String longestCommonPrefix(String[] strs) {
	        if(0 == strs.length) return "";		//Check the boundary conditions.
	        if(strs[0].length() == 0) return "";
	        String result = strs[0];
	        for(int i = 1; i < strs.length; i++){
	            if(strs[i].equals("")) return "";
	            int len = Math.min(result.length(), strs[i].length());	//Compare current result and next String.
	            result = result.substring(0, len);
	            for(int j = 0; j < len; j++){
	                if(result.charAt(j) != strs[i].charAt(j)){
	                    result = result.substring(0, j);
	                    break;
	                }
	            }
	        }
	        return result;
	    }
	}