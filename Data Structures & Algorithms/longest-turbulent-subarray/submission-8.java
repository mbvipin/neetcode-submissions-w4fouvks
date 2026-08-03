class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int left=0;
        int right=1;
        int res=1;

        String prev = "";

        while( right < arr.length)
        {
            if( arr[right] > arr[right -1] && !prev.equals(">"))
            {
                res= Math.max(res,right -left+1);
                prev= ">";
                right++;
            }

            else if( arr[right] < arr[right-1] && !prev.equals("<"))
            {
                res= Math.max( res, right-left +1);
                prev = "<";
                right++;
            }

            else
            {
                right=(arr[right] == arr[right - 1])? right+1: right;
                left= right -1;
                prev = "";
               


            }


        }
    
       return res;

        
    }
}