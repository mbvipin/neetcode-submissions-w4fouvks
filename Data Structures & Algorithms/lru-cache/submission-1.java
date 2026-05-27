class LRUCache {

    private int capacity;
    private List<int []> input;

    public LRUCache(int capacity) {

        this.capacity=capacity;
        input = new ArrayList<>();
    }
    
    public int get(int key) {

        for(int i=0 ; i< input.size(); i++)
        { 
            if(input.get(i)[0] == key)
            { 
                 int [] entry= input.get(i);
                 input.remove(i);
                 input.add(entry);
                 return entry[1];
            }
        }

        return -1;
        
    }
    
    public void put(int key, int value) {

        for( int i=0; i< input.size(); i++)
        { 
            if(input.get(i)[0] == key)
            { 
                int [] temp=input.get(i);
                temp[1]= value;
                input.remove(i);
                input.add(temp);
                return;
            }
        }

        if( capacity == input.size())
        { 
            input.remove(0);
        }

        input.add(new int []{key,value});
    }
}