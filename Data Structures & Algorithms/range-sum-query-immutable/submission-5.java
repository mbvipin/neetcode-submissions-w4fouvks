class SegmentTree
{
    private int [] tree;
    private int n;

    public SegmentTree(int [] nums)
    {
        this.n = nums.length;
        this.tree= new int[ 2 * n];

        for(int i= 0;  i < n; i++)
        {
            tree[n+ i]= nums[i];
        }

        for(int i= n-1; i > 0; i --)
        {
            tree[i]= tree[2* i]+ tree[(2 * i)+1];
        }


    }

    public int query(int left, int right)
    {
        int sum=0;
        left += n;
        right += n+1;

        while( left < right)
        {
            if( left % 2 == 1) sum += tree[left++];
            if( right % 2 == 1) sum += tree[-- right];

            left /= 2;
            right /=2;
        }

        return sum;

    }

}


class NumArray {

    private SegmentTree segTree;

    public NumArray(int[] nums) {

        segTree= new SegmentTree(nums);
        
    }
    
    public int sumRange(int left, int right) {

        return segTree.query(left,right);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */