public class Brackets
{
    public static void main(String[] args)
    {
        System.out.println("Should be true");
        System.out.println(checkBrackets(" "));
        System.out.println(checkBrackets("{}"));
        System.out.println(checkBrackets("{}{}"));
        System.out.println(checkBrackets("{{}}"));
        System.out.println(checkBrackets("{{{}{{}}}}"));

        System.out.println("\nShould be false");
        System.out.println(checkBrackets("{"));
        System.out.println(checkBrackets("}{"));
        System.out.println(checkBrackets("{}}{"));
        System.out.println(checkBrackets("{{}"));
        System.out.println(checkBrackets("{{}}}{}"));
    }
    
    public static boolean checkBrackets(String b)
    {
        LinkedStack<String> bList = new LinkedStack<String>();
        if(b.equals(" "))
        {
            return true;
        }
        
        if(b.length()%2!=0||b.substring(0,1).equals("}"))
        {
            return false;
        }
    
        for(int i = 0; i<b.length();i++)
        {
            if(b.substring(i,i+1).equals("{"))
            {
                String l = bList.push("pushed");
            }
            else 
            {
                if(bList.empty())
                {
                    return false;
                }
                String m = bList.pop();
            }
        }
        return bList.empty();

    }
}
