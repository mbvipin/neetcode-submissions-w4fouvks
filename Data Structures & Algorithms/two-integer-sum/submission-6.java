class Solution {
    public int[] twoSum(int[] nums, int target) {

        TreeMap<Integer, Integer> input = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (input.containsKey(complement)) {
                int idx1 = input.get(complement);
                int idx2 = i;
                return new int[]{Math.min(idx1, idx2), Math.max(idx1, idx2)};
            }
            input.put(nums[i], i);
        }

        return new int[0];
    }
}