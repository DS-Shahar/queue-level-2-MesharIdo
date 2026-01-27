public class Main 
{

    public static void main(String[] args) 
    {
        Queue<Integer> q = new Queue<Integer>();
        q.insert(1);
        q.insert(4);
        q.insert(0);
        q.insert(9);
        q.insert(10);
        q.insert(4);
        q.insert(2);
        q.insert(6);
        Queue<Integer> q1 = new Queue<Integer>();
        q1.insert(7);
        q1.insert(3);
        q1.insert(11);
        q1.insert(2);
        q1.insert(6);
        q1.insert(8);
        q1.insert(2);
        q1.insert(6);
        Queue<String> str = new Queue<String>();
        str.insert("SHALOM");
        str.insert("HEY");
        str.insert("OLA");
        str.insert("BONJOUR");
        str.insert("HELLO");
        str.insert("HELLO");
        boolean ex2 = ex_2(str);
        System.out.println(ex2);
        ////ex_3(q);
        ex_4(q);
        ex_5(q,q1);
        int ex6 = ex_6(q1);
        System.out.println(ex6);
    }
    
    public static Queue<Integer> ex_1(Queue<Character> oti) ///O(n)
    {
    Queue<Character> temp = new Queue<>();
    Queue<Integer> result = new Queue<>();
    char prev = oti.remove();
    temp.insert(prev);
    int count = 1;
    while (!oti.isEmpty())
    {
        char curr = oti.remove();
        temp.insert(curr);

        if (curr == prev)
        {
            count++;
        }
        else
        {
            result.insert(count);
            count = 1;
            prev = curr;
        }
    }
    result.insert(count);
    while (!temp.isEmpty())
    {
        oti.insert(temp.remove());
    }
    return result;
    }

    
	public static <T> boolean isIn(Queue<T> q, T x) 
	{
		boolean r = false;
		Queue<T> save = new Queue<T>();
		while (!q.isEmpty()) 
		{
			T a = q.remove();
			save.insert(a);
			if (a.equals(x))
				r = true;
		}
		while (!save.isEmpty()) 
		{
			q.insert(save.remove());
		}
		return r;
	}
    
    public static boolean ex_2(Queue<String> str)///O(n)^2
    {
        Queue<String> temp = new Queue<String>();
        while (!str.isEmpty())
        {
            String a = str.remove();
            temp.insert(a);
            if (isIn(str,a))
            {
                return true;
            }
        }
        while (!temp.isEmpty()) 
		{
			str.insert(temp.remove());
		}
        return false;
    }
    
    public static void removing(Queue<Integer> q, int x)
    {
        Queue<Integer> temp = new Queue<Integer>();
        while (!q.isEmpty())
        {
            int a = q.remove();
            if (a!=x)
            {
                temp.insert(a);
            }
        }
        while (!temp.isEmpty())
        {
            q.insert(temp.remove());
        }
    }

    public static void ex_3(Queue<Integer> q)//// O(n)^2
    {
        Queue<Integer> temp = new Queue<Integer>();
        while (!q.isEmpty())
        {
            int a = q.remove();
            temp.insert(a);
            if (isIn(q,a))
            {
                removing(q,a);
            }
        }
        while (!temp.isEmpty())
        {
            q.insert(temp.remove());
        }
        System.out.println(q.toString());
    }
    
    public static void ex_4(Queue<Integer> q)///O(n)^2
    {
        int min=1000000000;
        Queue<Integer> temp = new Queue<Integer>();
        Queue<Integer> arranged = new Queue<Integer>();
        while (!q.isEmpty())
        {
            while (!q.isEmpty())
            {
                int x = q.remove();
                temp.insert(x);
                if (x<min)
                {
                    min =x;
                }
            }
            while (!temp.isEmpty())
            {
                int z  = temp.remove();
                if (z!=min)
                {
                    q.insert(z);
                }
            }
            arranged.insert(min);
            min=1000000;
        }
        System.out.println(arranged.toString());
    }
    
    public static Queue<Integer> ex_5(Queue<Integer> q1, Queue<Integer> q2)///O(n)
    {
    Queue<Integer> temp1 = new Queue<>();
    Queue<Integer> temp2 = new Queue<>();
    Queue<Integer> result = new Queue<>();
    while (!q1.isEmpty() && !q2.isEmpty())
    {
        if (q1.head() <= q2.head())
        {
            result.insert(q1.remove());
        }
        else
            result.insert(q2.remove());
    }
    while (!q1.isEmpty())
    {
        result.insert(q1.remove());
    }
    while (!q2.isEmpty())
    {
        result.insert(q2.remove());
    }
    System.out.println(result.toString());
    return result;
    }

    public static int ex_6(Queue<Integer> q)///O(n)
    {
    Queue<Integer> temp = new Queue<>();
    int maxLen = 0;
    int maxSum = 0;
    int currLen = 0;
    int currSum = 0;
    while (!q.isEmpty())
    {
        int x = q.remove();
        temp.insert(x);
        if (x % 2 == 0)
        {
            currLen++;
            currSum += x;
            if (currLen > maxLen)
            {
                maxLen = currLen;
                maxSum = currSum;
            }
        }
        else
        {
            currLen = 0;
            currSum = 0;
        }
    }
    while (!temp.isEmpty())
    {
        q.insert(temp.remove());
    }
    return maxSum;
    }

    
}
