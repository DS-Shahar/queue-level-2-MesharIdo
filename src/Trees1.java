public static void ex1(BinNode<Integer> t) 
{
    if (t == null) 
      return;

    if (t.getValue() % 2 == 0 &&
        (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
        (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
    {
        System.out.println(t.getValue());
    }

    ex1(t.getLeft());
    ex1(t.getRight());
}

public static int ex2(BinNode<Integer> t) 
{
    if (t == null) 
      return 0;

    int count = 0;
    if (t.getValue() % 2 == 0 &&
        (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
        (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
    {
        count = 1;
    }
    return count + ex2(t.getLeft()) + ex2(t.getRight());
}

public static boolean ex3(BinNode<Integer> t) 
{
    if (t == null) 
      return false;

    if (t.getValue() % 2 == 0 &&
        (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
        (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
    {
        return true;
    }
    return ex3(t.getLeft()) || ex3(t.getRight());
}

public static boolean ex4(BinNode<Integer> t) 
{
    if (t == null) 
      return true;

    if (t.getValue() % 2 == 0 &&
       ((t.hasLeft() && t.getLeft().getValue() % 2 != 0) ||
        (t.hasRight() && t.getRight().getValue() % 2 != 0))) 
    {
        return false;
    }
    return ex4(t.getLeft()) && ex4(t.getRight());
}


