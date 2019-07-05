import java.util.ArrayList;
import java.util.Iterator;

public class job_sequencing {
    static class A
    {
        char jobid;
        int deadline;
        int profit;
        A(char a,int b,int c)
        {
            jobid=a;
            deadline=b;
            profit=c;
        }
    }
    static void find(A ob[],int start,int finish,int count,ArrayList arr)
    {
        if(start==finish)
            return;
        else if(start==0)
        {
            arr.add(ob[start]);
            count=ob[start].deadline-1;
        }
        else if(ob[start].deadline > count && ob[start].deadline > 1 )
        {
            arr.add(ob[start]);
            count=ob[start].deadline-1;
        }
        start++;
        find(ob,start,finish,count,arr);
    }
    public static void main(String args[])
    {
        ArrayList<A> arr = new ArrayList<>();
        A ob[] = {new A('a', 1, 100),new A('b', 1, 19),new A('c', 1, 27),
                  new A('d', 3, 25), new A('e', 3, 15)};
        //A ob[] = {new A('a', 4, 20), new A('b', 1, 10), new A('c', 1, 40), new A('d', 1, 30)};
        for(int i=0;i<ob.length;i++)
        {
            for(int j=i+1;j<ob.length;j++)
            {
                if(ob[j].profit>ob[i].profit)
                {
                    A temp=ob[i];
                    ob[i]=ob[j];
                    ob[j]=temp;
                }
            }
        }
        for(int i=0;i<ob.length;i++)
        {
        System.out.println(ob[i].jobid + " " + ob[i].deadline + " " + ob[i].profit);
        }
        find(ob,0,ob.length,0,arr);
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i).jobid + " ");
        }



    }
}

