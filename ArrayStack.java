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
            return pushed;
        }
    }
    
    @Override 
    public T push(T item)
    {
        stack[size]=item;
        size++;
        return item;
    }
        

    @Override 
    public void clear()
    {
        while(size>=0)
        {
            stack[size-1]=null;
            size--;
        }
        size=0;
    }
 
    @Override 
    public int search(Object o)
    {
        int count = size-1;
        while(count>=0)
        {
            if(stack[count]== o)
            {
                return count;
            }
            count--;
        }
        return -1;
    }
}
