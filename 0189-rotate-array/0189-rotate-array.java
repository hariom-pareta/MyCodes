class Solution {
    public void rotate(int[] nums, int k) {
    if(k == 0 || nums == null || nums.length == 0){
        return;
    }
    Map<Integer,Integer> map = new HashMap<>();
    int size = nums.length;
    k = k % size;
    for(int i = 0; i < size; i++){
        map.put((i + k) % size, nums[i]);
    }

    for(int i = 0; i< size; i++){
        nums[i] = map.get(i);
    }
}
}