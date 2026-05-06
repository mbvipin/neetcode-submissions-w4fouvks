class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset= new ArrayList<>();

        res.add( new ArrayList<>());

        for( int num : nums)
        {
            int size= res.size();

            for(int i=0; i < size; i++)
            {
               List<Integer> newList= new ArrayList<>(res.get(i));
               newList.add(num);
               res.add(newList);
            }

        }

        return res;
        
    }
}
