public class LinkedStack<T> implements StackInterface<T>
{
    private LLNode<T> top;
    private int size;

    public LinkedStack()
    {
        top = new LLNode<T>(null);
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
            return top.getLink().getInfo();
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
            LLNode<T> pushed = top.getLink();
            top.setLink(pushed.getLink());
            size--;
            return pushed.getInfo();
        }
    }
    
    @Override 
    public T push(T item)
    {
        LLNode<T> added = new LLNode<T>(item);
        added.setLink(top.getLink());
        top.setLink(added);
        size++;
        return item;
    }
        

    @Override 
    public void clear()
    {
        top.setLink(null);
        size=0;
    }
 
    @Override 
    public int search(Object o)
    {
        int count = 0;
        if(size!=0){
        LLNode<T> using = top.getLink();
        T matchData = (T)(o);
        while(count<size)
        {
            if(using.getInfo().equals(matchData))
            {
                return count;
            }
            using = using.getLink();
            count++;
        }
        return -1;
        }
        throw new StackUnderflowException("Stack is empty");
    }
}
