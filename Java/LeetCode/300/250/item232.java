class MyQueue {
    
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        return st2.pop();
    }

    /** Get the front element. */
    public int peek() {
        move();
        return st2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.empty() && st2.empty();
    }
    
    private void move() {
        if (st2.empty())
            while (!st1.empty())
                st2.push(st1.pop());
    }
}
