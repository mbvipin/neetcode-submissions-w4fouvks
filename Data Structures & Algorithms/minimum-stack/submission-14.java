class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;


    public MinStack() {

        stack=new Stack<>();
        minStack=new Stack<>();
        
    }
    
    public void push(int val) {

      if(!minStack.isEmpty() &&  val<=minStack.peek())
      {
        minStack.push(val);
      }
      else if(minStack.isEmpty())
      {
        minStack.push(val);
      }
      stack.push(val);
        
    }
    
    public void pop() {

       if(!minStack.isEmpty() && minStack.peek().equals(stack.peek()))
       {
        minStack.pop();
       }
       
       stack.pop();
      
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
