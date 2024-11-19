class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int low = 0, high = numbers.length - 1;
        if(numbers.length < 2) return null;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                result[0] = low + 1;
                result[1] = high + 1;
                break;
            }else if(sum > target)
                high--;
            else
                low++;
        }
        return low >= high ? null : result;
    }
}