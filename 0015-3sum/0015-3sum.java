class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	for (int x = 0; x < nums.length; x ++) {
            if (nums[x] > 0)
                break;
    		if (x != 0 && nums[x] == nums[x - 1])
    			continue;
    		ArrayList<Integer> l = new ArrayList<Integer>();
    		int m = x + 1;
    		int n = nums.length - 1;
    		while (m < n) {
    			if (0 - nums[x] - nums[m] > nums[n])
    				m ++;
    			else if (0 - nums[x] - nums[m] < nums[n])
    				n --;
    			else {
					l.add(nums[x]);
					l.add(nums[m]);
					l.add(nums[n]);
					list.add((List<Integer>)l.clone());
                    while (m < n && nums[m] == nums[m+1]) 
                        m++;  
                    while (m < n && nums[n] == nums[n-1]) 
                        n--;  
					l.clear();
					n --;
					m ++;
    			}
    		}
    	}
    	return list;
    }
}