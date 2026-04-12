class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    private int currentMin;

    public MinStack() {

        stack=new Stack<>();
        minStack=new Stack<>();
        currentMin=Integer.MAX_VALUE;
        
        
    }
    
    public void push(int val) {

       

        if( !minStack.isEmpty())
        {
         currentMin=minStack.peek();

         if(val <= currentMin)
         {

            minStack.push(val);
            
         }
        }
        else
        {
        
            minStack.push(val);
        }
        
        stack.push(val);
        
    }
    
    public void pop() {

        if( !minStack.isEmpty() && stack.peek().equals(minStack.peek()))
        {
        

        minStack.pop();
            
        }

      if(!stack.isEmpty())
      {
        stack.pop();
      }

     
        
    }
    
    public int top() {

        return stack.peek();
        
    }
    
    public int getMin() {

    if(!minStack.isEmpty())
    {
    return minStack.peek();
    }

    return 0;
        
    }
}
