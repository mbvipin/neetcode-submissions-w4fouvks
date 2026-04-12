// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {

      return mergeSort(pairs,0, pairs.size()-1);

    }

    public List<Pair> mergeSort( List<Pair> pairs,int start,int end)
    {
        if( end- start+1 <= 1)
        {
            return pairs;
        }

        int mid= (end +start)/2;

       mergeSort( pairs, start, mid);
        mergeSort(pairs, mid+1, end);

        merge(pairs,start,mid, end);

        return pairs;

    }

    public void merge( List<Pair> pairs, int start,int mid, int end)
    {
        int left=0;
        int right=0;
        int result= start;

        List<Pair> leftList= new ArrayList<> ( pairs.subList(start,mid+1));
        List<Pair> rightList= new ArrayList<> (pairs.subList(mid+1,end+1));

        while( left < leftList.size() && right < rightList.size())
        {
            if(leftList.get(left).key <= rightList.get(right).key)
            {    
                pairs.set(result,leftList.get(left));
                left++;
            }

            else
            {
                pairs.set(result,rightList.get(right));
                right++;
            }
              result++;

        }

        while( left < leftList.size())
        {
            pairs.set(result, leftList.get(left));

            left++;
            result++;
        }

        while( right < rightList.size())
        {
            pairs.set(result, rightList.get(right));
            right++;
            result++;
        }



    }

   
}
