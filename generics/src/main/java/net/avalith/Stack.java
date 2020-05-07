package net.avalith;

import java.util.LinkedList;

public class Stack <T extends Comparable<T>>{
    private LinkedList<T> stack;

    public Stack(){
        stack = new LinkedList<>();
    }

    public void push(T value){
        stack.push(value);
    }
    public T pop(){
        if(stack.isEmpty())
            return stack.pop();
        else
            return null;
    }
    public int size(){
        return stack.size();
    }
    public T getTop(){
        if(stack.isEmpty())
            return stack.getFirst();
        else
            return null;
    }
    public T getMax(){
        T max = this.getTop();
        for(T value : stack){
            if(max.compareTo(value)<0)
                max=value;
        }
        return max;
    }
    public T getMin(){
        T min = this.getTop();
        for(T value : stack){
            if(min.compareTo(value)>0)
                min=value;
        }
        return min;
    }

    @Override
    public String toString() {
        return "Stack{" + stack + '}';
    }
}
