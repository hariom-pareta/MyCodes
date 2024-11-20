class Solution {
    public boolean isHappy(int n) {

        Set<Integer> visit = new HashSet<>();

        while (n != 1 && !visit.contains(n)) {
            visit.add(n);
            int x = 0;

            while (n != 0) {
                x += (n % 10) * (n % 10);
                n /= 10;
            }

            n = x;
        }

        return n == 1;
    }
}