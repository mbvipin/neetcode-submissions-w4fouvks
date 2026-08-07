class Solution {
    public int removeDuplicates(int[] nums) {

        Set<Integer> uniqueInOrder= new TreeSet<>();

        for(int num : nums)
        {
            uniqueInOrder.add(num);
        }

        int i=0;
        for(int num: uniqueInOrder)
        {
            nums[i++]=num;

        }

        return uniqueInOrder.size();
        
    }
}