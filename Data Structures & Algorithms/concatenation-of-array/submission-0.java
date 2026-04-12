class Solution {
    public int[] getConcatenation(int[] nums) {

        int [] result=new int [2* nums.length];

        int i=0;
        int newIndex=0;

        while( newIndex < result.length)
        {
            
            if( i >=nums.length)
            {
                i=i% nums.length;
            }

            System.out.println(newIndex);

          result[newIndex]=nums[i];
          newIndex++;
         i++;
        }

    

        

        

        return result;
        
    }
}