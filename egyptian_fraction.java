import java.util.Scanner;

public class egyptian_fraction {
    static void printegyptian(int nr, int dr)
    {
        if(nr==0 || dr==0)
            return;
        if(dr%nr==0)
        {
            System.out.print("1/"+dr/nr);
            return;
        }
        if(nr%dr==0)
        {
            System.out.println(nr/dr);
            return;
        }
        if(nr > dr)
        {
            System.out.print(nr/dr + "+");
            printegyptian(nr%dr,dr);
            return;
        }
        else
        {
            int n=dr/nr+1;
            System.out.print("1/" + n + "+");
            System.out.println(nr*n-dr + " " + dr*n);
            printegyptian(nr*n-dr,dr*n);

        }

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element - numerator and denominator");
        int nr = sc.nextInt();
        int dr = sc.nextInt();
        printegyptian(nr,dr);

    }
}

