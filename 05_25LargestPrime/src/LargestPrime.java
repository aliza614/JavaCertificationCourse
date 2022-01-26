public class LargestPrime {
    public static int getLargestPrime(int number){
        if (number<2)
            return -1;
        int largestPrimeFactor=0;
        int a=number;
        for (int i=2;i<=a;i++)
        {
            int candidate=0;
            if (a%i==0)
            {
                candidate=i;
                for (int j=2;j<=Math.sqrt(candidate);j++)
                    if (candidate%j==0)
                        candidate=0;
                if (candidate!=0)
                    largestPrimeFactor=candidate;
            }
        }
        if (largestPrimeFactor==0)
            return -1;
        else return largestPrimeFactor;


    }
}
