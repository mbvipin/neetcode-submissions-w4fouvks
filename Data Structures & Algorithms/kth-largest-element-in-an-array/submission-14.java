class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1);
    }

    private int partition(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;
        swap(nums, mid, left + 1);

        if (nums[right] > nums[left]) {
            swap(nums, left, right);
        }

        if (nums[right] > nums[left + 1]) {
            swap(nums, left + 1, right);
        }

        if (nums[left + 1] > nums[left]) {
            swap(nums, left, left + 1);
        }

        int pivot = nums[left + 1];
        int i = left + 1;
        int j = right;

        while (true) {
            while (nums[++i] > pivot) {

            }

            while (nums[--j] < pivot) {

            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
        }
        nums[left + 1] = nums[j];
        nums[j] = pivot;
        return j;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    private int quickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            if (right <= left + 1) {
                if (right == left + 1 && nums[right] > nums[left]) {
                    swap(nums, right, left);
                }
                return nums[k];
            }

            int j = partition(nums, left, right);

            if (j >= k) right = j - 1;
            if (j <= k) left = j + 1;
        }
    }
}