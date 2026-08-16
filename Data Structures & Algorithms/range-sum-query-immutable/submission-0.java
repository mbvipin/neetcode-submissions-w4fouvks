class NumArray {

    private int [] prefixSum;

    public NumArray(int[] nums) {

        prefixSum = new int[nums.length];

        int total=0;
        int index=0;

        for(int num: nums)
        {
            total += num;
            prefixSum[index++]=total;
        }


        
    }
    
    public int sumRange(int left, int right) {

        if( left <0 || right >= prefixSum.length)
        {
            return 0;
        }

        int rightPrefixSum= prefixSum[right];
        int leftPrefixSum=left > 0? prefixSum[left -1]: 0;

        return (rightPrefixSum- leftPrefixSum);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */