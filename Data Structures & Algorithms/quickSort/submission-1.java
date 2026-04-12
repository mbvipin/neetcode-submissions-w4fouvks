class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {

        return merge(pairs,0, pairs.size()-1);
        
    }

    public List<Pair> merge(List<Pair> pairs,int start, int end)
    {
        if( end - start+1 <=1)
        {
            return pairs;
        }

        Pair pivot= pairs.get(end);
        int left=start;
    

        for( int i=start ; i< end ; i++)
        {
            if(pairs.get(i).key < pivot.key)
            {
                Pair temp= pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left,temp);

                left++;
            }


        }

        Pair temp= pairs.get(left);
        pairs.set(left,pivot);
        pairs.set(end,temp);

        merge(pairs,start,left-1);
        merge(pairs,left+1,end);

        return pairs;


    }

   
    
}