public class knapsack {
    static int knap(int W,int wt[],int val[],int n)
    {
        if(n==0 || W == 0)
            return 0;
        if(wt[n-1] > W)
            return knap(W,wt,val,n-1);
        else
            return Math.max(val[n-1]+knap(W-wt[n-1],wt,val,n-1),knap(W,wt,val,n-1));

    }
    static int knap_dp(int W,int wt[],int val[],int n)
    {
        int k[][]=new int[n+1][W+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(i==0 || j==0)
                    k[i][j]=0;
                else if(wt[i-1]<=j)
                    k[i][j]=Math.max(val[i-1]+k[i-1][j-wt[i-1]],k[i-1][j]);
                else
                    k[i][j]=k[i-1][j];
            }
        }
        return k[n][W];

    }
    public static void main(String args[])
    {
        int val[]={10,20,30};
        int wt[]={1,1,1};
        int W=2;
        int n=val.length;
        System.out.println(knap(W,wt,val,n));
        System.out.println(knap_dp(W,wt,val,n));
    }
}

