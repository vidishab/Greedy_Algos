import java.util.ArrayList;
import java.util.Hashtable;

public class activity_selection_problem {
    static int[] sort(int arr[],int temp[],int first,int last)
    {
        int mid;
        if (first<last)
        {
            mid=(last+first)/2;
            sort(arr,temp,first,mid);
            sort(arr,temp,mid+1,last);
            arr=merge(arr,temp,first,mid+1,last);
        }
        return arr;
    }
    static int[] merge(int arr[],int temp[],int first,int mid,int last)
    {
        int temp_pos=first;
        int left_end=mid-1;
        int size=last-first+1;
        while (first<=left_end && mid<=last)
        {
            if(arr[first] <= arr[mid])
            {
                temp[temp_pos]=arr[first];
                temp_pos++;
                first++;
            }
            else
            {
                temp[temp_pos]=arr[mid];
                mid++;
                temp_pos++;
            }
        }
        while (first<=left_end)
        {
            temp[temp_pos]=arr[first];
            temp_pos++;
            first++;
        }
        while (mid<=last)
        {
            temp[temp_pos]=arr[mid];
            mid++;
            temp_pos++;
        }
        for(int i=0;i<size;i++)
        {
            arr[last]=temp[last];
            last--;
        }
        return arr;

    }
    static void find(int start[], int finish[])
    {
        int count=0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        count++;
        int n=start.length-1;
        for(int i=1;i<=n;i++)
        {
            System.out.println(start[i] + " " + finish[i-1]);
            if(start[i]>=finish[arr.get(count-1)])
            {
                arr.add(i);
                count++;
            }

        }
        System.out.println(arr);
    }
    // Needs distince finish values since hashing collisions can occur otherwise.
    static void unsorted(int start[],int finish[])
    {
        int count=0;
        ArrayList<Integer> arr = new ArrayList<>();
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        int temp[]=new int[start.length];
        for(int i=0;i<start.length;i++)
        {
            ht.put(finish[i],start[i]);
        }
        finish=sort(finish,temp,0,(finish.length-1));
        for(int i=0;i<finish.length;i++)
        {
            start[i]=ht.get(finish[i]);
        }
        arr.add(0);
        count++;
        for(int i=1;i<start.length;i++)
        {
            if(start[i]>=finish[arr.get(count-1)])
                arr.add(i);
        }
        for(int i=0;i<finish.length;i++)
        {
            System.out.println(start[i] + " " + finish[i]);
        }
        System.out.println(arr);

    }
    public static void main(String args[])
    {
        int start[]={5,1,3,0,5,8};
        int finish[]={10,2,4,6,7,9};
        //find(start,finish);
        unsorted(start,finish);
    }
}

