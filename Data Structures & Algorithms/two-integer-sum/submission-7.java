class Solution {
    public int[] twoSum(int[] nums, int target) {

        int [] [] input = new int [nums.length][2];

        for( int i=0; i < nums.length; i++)
        {
            input[i][0]= nums[i];
            input[i][1]= i;
        }

        Arrays.sort(input,Comparator.comparingInt(a-> a[0]));

        int i=0;
        int j= nums.length-1;

        while( i < nums.length && j >=0)
        {
            int[] left= input[i];
            int [] right= input[j];

            int sum= left[0] + right[0];

            if( target == sum)
            {
                int [] res= new int[2];
                res[0]= Math.min(left[1],right[1]);
                res[1]= Math.max(left[1],right[1]);
                
                return res;

            }

            else if( target > sum)
            {
                i= i+1;
            }

            else
            {
                j= j-1;

            }






        }

        return new int [0];
        
    }
}
