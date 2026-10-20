public class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int size;

    public ArrayStack()
    {
        stack = (T[]) new Object[10];
        size = 0;
    }

    @Override 
    public int size()
    {
        return size;
    }

    @Override 
    public boolean empty()
    {
        return size == 0;
    }

    @Override 
    public T peek() throws StackUnderflowException
    {
        if (empty())
        {
            throw new StackUnderflowException("Stack is empty");
        }
        else
        {
            return stack[size - 1];
        }
    }
    
    @Override 
    public T pop() throws StackUnderflowException
    {
        if(empty())
        {
            throw new StackUnderflowException("Stack is Empty");
        }
        else
        {
            T pushed = stack[size-1];
            stack[size-1]=null;
            size--;
            int quarterOfMemory = (this.stack.length) / 4;
            if (size < quarterOfMemory)
            {
                halfLength();
            } 
            return pushed;
        }
    }
    
    @Override 
    public T push(T item)
    {
        
        if (size == this.stack.length)
        {
            doubleLength();
        }
        stack[size]=item;
        size++;
        return item;
    }
        

    @Override 
    public void clear()
    {
        stack = (T[]) new Object[10];
        size=0;
    }
 
    @Override 
    public int search(Object o)
    {
        if(size!=0){
        int count = 0;
        while(count<size)
        {
            if(stack[count].equals((T)(o)))
            {
                return count;
            }
            count++;
        }
        return -1;
        }
        throw new StackUnderflowException("Stack is empty");
    }

    public void doubleLength()
    {
        int length = stack.length;
        T[] tempArray = (T[]) new Object[length*2];
        for(int i = 0; i<this.stack.length; i++)
        {
            tempArray[i]=this.stack[i];
        }
        this.stack=tempArray; 
    }
    public void halfLength()
    {
        int length = this.stack.length;
        T[] tempArray = (T[]) new Object[length/2];
        for(int i = 0; i<this.size; i++)
        {
            tempArray[i]=this.stack[i];
        }
        this.stack=tempArray; 
    }
}
