class Solution {
    private int[] prefix;
    private Random rand;
    private int total;
    public Solution(int[] w) {
        rand = new Random();
        prefix = new int[w.length];
        for (int i = 0; i < w.length; i++){
            prefix[i] = i == 0? w[i] : w[i] + prefix[i - 1];
        }
        total = prefix[prefix.length - 1];
    }

    public int pickIndex() {
        int target = rand.nextInt(total);
        return smallestLarger(target);
    }

    private int smallestLarger(int target){
        int left = 0;
        int right = prefix.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (prefix[mid] <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}